package com.stezhka.movieland.service;


import com.stezhka.movieland.entity.Country;
import com.stezhka.movieland.entity.Movie;

import java.util.List;

public interface CountryService {
    List<Country> getAll();

    void enrichMoviesWithCountries(List<Movie> movies);

    void enrichMovieWithCountries(Movie movie);

    void addCountryMapping(List<Country> countries, int movieId);

    void removeCountryMappingsByIds(List<Country> countries, int movieId);
}
