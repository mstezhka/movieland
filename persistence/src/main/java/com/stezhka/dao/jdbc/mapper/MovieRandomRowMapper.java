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
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException, NullPointerException {
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
        movie.setCountries(getMovieCountries(resultSet));
        movie.setGenres(getMovieGenres(resultSet));

        return movie;
    }

    private List<Country> getMovieCountries(ResultSet resultSet) throws SQLException, NullPointerException {
        List<Country> countries = new ArrayList<>();
        for (String countryId: resultSet.getString("country_ids").split(",")){
            Country country = new Country();
            country.setId(Integer.parseInt(countryId));
            countries.add(country);
        }
        return countries;
    }

    private List<Genre> getMovieGenres(ResultSet resultSet) throws SQLException {
        List<Genre> genres = new ArrayList<>();
        for (String genreId: resultSet.getString("genre_ids").split(",")){
            Genre genre = new Genre();
            genre.setId(Integer.parseInt(genreId));
            genres.add(genre);
        }
        return genres;
    }

}
