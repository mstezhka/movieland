package com.stezhka.movieland.dao;

import com.stezhka.movieland.entity.Country;

import java.util.List;

public interface CountryDao {
    List<Country> getAll();

    void addCountryMapping(List<Country> countries, int movieId);

    void removeCountryMappingsByIds(List<Country> countries, int movieId);
}
