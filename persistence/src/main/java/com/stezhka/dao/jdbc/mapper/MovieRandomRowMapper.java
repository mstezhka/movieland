package com.stezhka.dao.jdbc.mapper;

import com.stezhka.entity.Country;
import com.stezhka.entity.Genre;
import com.stezhka.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRandomRowMapper implements RowMapper<Movie> {
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

        List<Country> countries = new ArrayList<>();
        for (String contryId: resultSet.getString("movie_ids").split(",")) {
            Country country = new Country();
            country.setId(Integer.parseInt(contryId));
            countries.add(country);
        }

        List<Genre> genres = new ArrayList<>();
        for (String genreId: resultSet.getString("genre_ids").split(",")){
            Genre genre = new Genre();
            genre.setId(Integer.parseInt(genreId));
            genres.add(genre);
        }

        movie.setCountries(countries);
        movie.setGenres(genres);

        return movie;
    }
}