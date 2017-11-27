package com.stezhka.dao.jdbc;

import com.stezhka.dao.MovieDao;
import com.stezhka.dao.jdbc.mapper.MovieRowmapper;
import com.stezhka.dao.jdbc.mapper.MovieRandomRowmapper;
import com.stezhka.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    private static final MovieRowmapper MOVIE_ROW_MAPPER = new MovieRowmapper();
    private static final MovieRandomRowmapper MOVIE_RANDOM_ROW_MAPPER = new MovieRandomRowmapper();

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

