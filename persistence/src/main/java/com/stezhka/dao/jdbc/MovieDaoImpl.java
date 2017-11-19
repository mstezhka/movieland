package com.stezhka.dao.jdbc;

import com.stezhka.dao.MovieDao;
import com.stezhka.dao.jdbc.mapper.MovieRowMapper;
import com.stezhka.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieDaoImpl implements MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private String getAllMoviesSQL;

    @Autowired
    private String getRandomMoviesSQL;

    public List<Movie> getAllMovies() {

        List<Movie> movies = jdbcTemplate.query(getAllMoviesSQL, new MovieRowMapper());
        return movies;
    }

    public List<Movie> getThreeRandomMovies() {

        List<Movie> movies = jdbcTemplate.query(getRandomMoviesSQL, new MovieRowMapper());
        return movies;
    }

//    @Override
//    public void add(Movie movie) {
//        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
//        parameterSource.addValue("name_russian", movie.getNameRussian());
//        parameterSource.addValue("name_native", movie.getNameNative());
//        parameterSource.addValue("released_date", movie.getYearOfRelease());
//        parameterSource.addValue("description", movie.getDescription());
//        parameterSource.addValue("rating", movie.getRating());
//        parameterSource.addValue("price", movie.getPrice());
//        parameterSource.addValue("picture_path", movie.getPoster());
//        parameterSource.addValue("vote", movie.getVotes());
//        namedJdbcTemplate.update(addMovieSQL, parameterSource);
//    }

}

