package com.stezhka.service;

import com.stezhka.entity.Country;
import com.stezhka.entity.Movie;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    void fillMoviesWithCountries(List<Movie> movies);

}
