package com.stezhka.movieland.dao.jdbc.cache;

import com.stezhka.movieland.dao.GenreDao;
import com.stezhka.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class GenreCache implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private volatile List<Genre> genresCache;

    @Autowired
    @Qualifier("jdbcGenreDao")
    private GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        List<Genre> genresCacheCopy = genresCache;
        List<Genre> genresCacheToReturn = new ArrayList<>();
        for (Genre genre : genresCacheCopy) {
            Genre copyGenre = new Genre();
            copyGenre.setId(genre.getId());
            copyGenre.setName(genre.getName());
            genresCacheToReturn.add(copyGenre);
        }
        return genresCacheToReturn;
    }

    @Override
    public void addGenreMapping(List<Genre> genres, int movieId) {
        genreDao.addGenreMapping(genres, movieId);
    }

    @Override
    public void removeGenreMappingsByIds(List<Genre> genres, int movieId) {
        genreDao.removeGenreMappingsByIds(genres, movieId);
    }

    @PostConstruct
    @Scheduled(fixedDelayString = "${genre.cache.refresh.interval}", initialDelayString = "${genre.cache.refresh.interval}")
    private void invalidate() {
        log.info("Start genre cache refresh");
        long startTime = System.currentTimeMillis();
        genresCache = genreDao.getAll();
        log.info("Genre chache has been reloaded. It took {} ms", System.currentTimeMillis() - startTime);
    }


}
