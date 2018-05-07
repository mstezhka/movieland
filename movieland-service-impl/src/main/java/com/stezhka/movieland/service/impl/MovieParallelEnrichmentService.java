package com.stezhka.movieland.service.impl;

import com.stezhka.movieland.entity.Movie;
import com.stezhka.movieland.service.CountryService;
import com.stezhka.movieland.service.GenreService;
import com.stezhka.movieland.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class MovieParallelEnrichmentService {

    private static final int TIMEOUT_IN_SECONDS = 5;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private GenreService genreService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ExecutorService threadPool;


    void enrichMovie(Movie movie) {
        List<Future<?>> tasksList = new ArrayList<>();

        Runnable enrichGenresTask = () -> {
            genreService.enrichMovieWithGenres(movie);
        };

        Runnable enrichCountriesTask = () -> {
            countryService.enrichMovieWithCountries(movie);
        };

        Runnable enrichReviewsTask = () -> {
            reviewService.enrichMovieWithReviews(movie);
        };


        log.info("Submit enrichMovie tasks for movieId {}", movie.getMovieId());
        long startTime = System.currentTimeMillis();
        tasksList.add(threadPool.submit(enrichCountriesTask));
        tasksList.add(threadPool.submit(enrichGenresTask));
        tasksList.add(threadPool.submit(enrichReviewsTask));

        long totalWaitTime = TimeUnit.SECONDS.toNanos(TIMEOUT_IN_SECONDS);

        for (Future<?> futureTask : tasksList) {
            final long taskStart = System.nanoTime();
            long timeSpent;
            try {
                futureTask.get(totalWaitTime, TimeUnit.NANOSECONDS);
            } catch (TimeoutException e) {
                futureTask.cancel(true);
            } catch (Exception e) {
                log.error("enrichMovieTask Failed: {}", e);
            } finally {
                timeSpent = System.nanoTime() - taskStart;
                totalWaitTime = Math.max(totalWaitTime - timeSpent, 0);
            }
        }

        log.info("enrichMovie task for movieId {} was completed. It took {} ms", movie.getMovieId(), System.currentTimeMillis() - startTime);
    }

}
