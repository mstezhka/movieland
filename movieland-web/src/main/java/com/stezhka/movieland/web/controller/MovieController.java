package com.stezhka.movieland.web.controller;

import com.stezhka.movieland.dao.enums.UserRole;
import com.stezhka.movieland.entity.Movie;
import com.stezhka.movieland.dao.enums.Currency;
import com.stezhka.movieland.dao.enums.SortDirection;
import com.stezhka.movieland.entity.UserMovieRate;
import com.stezhka.movieland.service.MovieRatingService;
import com.stezhka.movieland.service.MovieService;
import com.stezhka.movieland.web.util.dto.ToDtoConverter;
import com.stezhka.movieland.web.util.currency.CurrencyService;
import com.stezhka.movieland.web.util.json.JsonJacksonConverter;
import com.stezhka.movieland.web.security.Protected;
import com.stezhka.movieland.web.security.entity.PrincipalUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping(value = "/movie", method = GET, produces = "application/json;charset=UTF-8")
public class MovieController {
    private Logger log = LoggerFactory.getLogger(getClass());
    private MovieService movieService;
    private JsonJacksonConverter jsonConverter;
    private ToDtoConverter toDtoConverter;
    private CurrencyService currencyService;
    private MovieRatingService movieRatingService;

    @Autowired
    public MovieController(MovieService movieService, JsonJacksonConverter jsonConverter,
                           ToDtoConverter toDtoConverter, CurrencyService currencyService,
                           MovieRatingService movieRatingService) {
        this.movieService = movieService;
        this.jsonConverter = jsonConverter;
        this.toDtoConverter = toDtoConverter;
        this.currencyService = currencyService;
        this.movieRatingService = movieRatingService;
    }

    @RequestMapping()
    @ResponseBody
    public String getAllMovies(
            @RequestParam(value = "rating", defaultValue = "nosort") String rating,
            @RequestParam(value = "price", defaultValue = "nosort") String price) {
        log.info("Sending request to get all movies");
        long startTime = System.currentTimeMillis();

        Map<String, SortDirection> sortType = new HashMap<>();
        sortType.put("rating", SortDirection.getDirection(rating));
        sortType.put("price", SortDirection.getDirection(price));

        String jsonMovies = jsonConverter.convertAllMoviesToJson(
                toDtoConverter.convertMoviestoMoviesDto(movieService.getAllMovies(sortType)));
        log.info("Movies are received. It took {} ms", System.currentTimeMillis() - startTime);
        return jsonMovies;
    }

    @RequestMapping(value = "/random")
    @ResponseBody
    public String getRandomMovies() {
        log.info("Sending request to get random movies");
        long startTime = System.currentTimeMillis();
        String jsonMovies = jsonConverter.convertRandomMoviesToJson(
                toDtoConverter.convertMoviestoMoviesDto(movieService.getRandomMovies()));
        log.info("Random Movies are received. It took {} ms", System.currentTimeMillis() - startTime);
        return jsonMovies;
    }

    @RequestMapping(value = "/genre/{genreid}")
    @ResponseBody
    public String getMoviesByGenreId(@PathVariable int genreid,
                                     @RequestParam(value = "rating", defaultValue = "nosort") String rating,
                                     @RequestParam(value = "price", defaultValue = "nosort") String price) {
        log.info("Sending request to get movies by genre id {}", genreid);
        long startTime = System.currentTimeMillis();

        Map<String, SortDirection> sortType = new HashMap<>();
        sortType.put("rating", SortDirection.getDirection(rating));
        sortType.put("price", SortDirection.getDirection(price));

        String jsonMovies = jsonConverter.convertAllMoviesToJson(
                toDtoConverter.convertMoviestoMoviesDto(movieService.getMoviesByGenreId(genreid, sortType)));
        log.info("Movies are received. It took {} ms", System.currentTimeMillis() - startTime);
        return jsonMovies;
    }

    @RequestMapping(value = "/{movieId}")
    @ResponseBody
    public String getMovieById(@PathVariable int movieId,
                               @RequestParam(value = "currency", defaultValue = "UAH") String currency) {
        log.info("Sending request to get movie by movie id {}", movieId);
        long startTime = System.currentTimeMillis();
        Movie movie = movieService.getMovieById(movieId);
        Currency reqCurrency = Currency.getCurrency(currency);
        if (reqCurrency != Currency.UAH) {
            currencyService.convertMoviePrice(movie, currencyService.getCurrencyRate(reqCurrency));
        }

        String jsonMovie = jsonConverter.convertMovieToJson(toDtoConverter.convertMovietoMovieDto(movie));
        log.info("Movie was received. It took {} ms", System.currentTimeMillis() - startTime);
        return jsonMovie;
    }

    @RequestMapping(method = POST, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    @Protected(roles = {UserRole.ADMIN})
    public Movie addMovie(@RequestBody String movieJson) {
        log.info("Sending request to add movie");
        long startTime = System.currentTimeMillis();
        Movie movie = movieService.addMovie(jsonConverter.jsonToObject(movieJson, Movie.class));

        log.info("Movie {} was added. It took {} ms", movie, System.currentTimeMillis() - startTime);
        return movie;
    }

    @RequestMapping(value = "/{movieId}", method = PUT, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    @Protected(roles = {UserRole.ADMIN})
    public void editMovie(@RequestBody String movieJson, @PathVariable int movieId) {
        log.info("Sending request to update movie");
        long startTime = System.currentTimeMillis();
        Movie movie = jsonConverter.jsonToObject(movieJson, Movie.class);
        movie.setMovieId(movieId);
        movieService.editMovie(movie);

        log.info("Movie  was updated. It took {} ms", System.currentTimeMillis() - startTime);

    }

    @RequestMapping(value="/{movieId}/rate",method = POST, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    @Protected(roles = {UserRole.USER})
    public void rateMovie(@RequestBody String rateJson,@PathVariable int movieId, PrincipalUser principal) {
        log.info("Sending request to rate movie");
        long startTime = System.currentTimeMillis();
        UserMovieRate userMovieRate = new UserMovieRate();
        userMovieRate.setMovieId(movieId);
        userMovieRate.setRating(jsonConverter.extractRate(rateJson));
        userMovieRate.setUserId(principal.getUserId());
        movieRatingService.rateMovie(userMovieRate);

        log.info("Movie {} was rated. It took {} ms", movieId, System.currentTimeMillis() - startTime);

    }
}
