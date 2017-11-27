package com.stezhka.dao.jdbc.mapper;

import com.stezhka.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowmapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();

        movie.setId(resultSet.getInt("id"));
        movie.setNameRussian(resultSet.getString("name_russian"));
        movie.setNameNative(resultSet.getString("name_native"));
        movie.setYearOfRelease(resultSet.getInt("year_of_release"));
        movie.setDescription(resultSet.getString("description"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPoster(resultSet.getString("picture_path"));
        movie.setVotes(resultSet.getInt("votes"));

        return movie;
    }
}
