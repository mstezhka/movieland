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
public class MovieDaoImpl implements MovieDao {

    private static final MovieRowMapper movieRowMapper = new MovieRowMapper();
    private static final MovieRandomRowMapper movieRandomRowMapper = new MovieRandomRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMoviesSQL;

    @Autowired
    private String getRandomMoviesSQL;

    public List<Movie> getAllMovies() {
        List<Movie> movies = jdbcTemplate.query(getAllMoviesSQL, movieRowMapper);
        return movies;
    }

    public List<Movie> getThreeRandomMovies() {
        List<Movie> movies = jdbcTemplate.query(getRandomMoviesSQL, movieRandomRowMapper);
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

