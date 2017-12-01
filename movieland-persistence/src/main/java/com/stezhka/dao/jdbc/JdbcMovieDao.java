package com.stezhka.dao.jdbc;

import com.stezhka.dao.MovieDao;
import com.stezhka.dao.jdbc.mapper.MovieRowMapper;
import com.stezhka.dao.jdbc.mapper.MovieRandomRowMapper;
import com.stezhka.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {

    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private static final MovieRandomRowMapper MOVIE_RANDOM_ROW_MAPPER = new MovieRandomRowMapper();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMoviesSQL;

    @Autowired
    private String getRandomMoviesSQL;

    @Autowired
    private String getMoviesByGenreSQL;

    public List<Movie> getAllMovies() {
        logger.debug("Start getting all movies from DB");
        long startTime = System.currentTimeMillis();

        List<Movie> movies = jdbcTemplate.query(getAllMoviesSQL, MOVIE_ROW_MAPPER);

        logger.debug("End getting all movies from DB. It was taken in {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    public List<Movie> getThreeRandomMovies() {
        logger.debug("Start getting three random movies from DB");
        long startTime = System.currentTimeMillis();

        List<Movie> movies = jdbcTemplate.query(getRandomMoviesSQL, MOVIE_RANDOM_ROW_MAPPER);

        logger.debug("End getting three random movies from DB. It was taken in {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    public List<Movie> getMoviesByGenreId(int genreId) {
        logger.debug("Start getting movies by genre id from DB");
        long startTime = System.currentTimeMillis();

        List<Movie> movies = jdbcTemplate.query(getMoviesByGenreSQL, MOVIE_ROW_MAPPER, genreId);

        logger.debug("End getting movies by genre id from DB. It was taken in {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

}