package com.stezhka.dao.jdbc;

import com.stezhka.dao.MovieDao;
import com.stezhka.dao.jdbc.mapper.MovieRowMapper;
import com.stezhka.dao.jdbc.mapper.MovieRandomRowMapper;
import com.stezhka.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {

    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private static final MovieRandomRowMapper MOVIE_RANDOM_ROW_MAPPER = new MovieRandomRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMoviesSQL;

    @Autowired
    private String getRandomMoviesSQL;

    public List<Movie> getAllMovies() {
        List<Movie> movies = jdbcTemplate.query(getAllMoviesSQL, MOVIE_ROW_MAPPER);
        return movies;
    }

    public List<Movie> getThreeRandomMovies() {
        List<Movie> movies = jdbcTemplate.query(getRandomMoviesSQL, MOVIE_RANDOM_ROW_MAPPER);
        return movies;
    }

}

