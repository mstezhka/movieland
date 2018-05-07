package com.stezhka.movieland.service.impl;


import com.stezhka.movieland.dao.CountryDao;
import com.stezhka.movieland.entity.Country;
import com.stezhka.movieland.entity.Movie;
import com.stezhka.movieland.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final CountryDao countryDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<Country> getAll() {
        return countryDao.getAll();
    }

    @Override
    public void enrichMoviesWithCountries(List<Movie> movies) {
        Map<Integer, String> countriesMap = countryDao.getAll().stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

        for (Movie movie : movies) {
            for (Country movieCountry : movie.getCountries()) {
                movieCountry.setName(countriesMap.get(movieCountry.getId()));
            }
        }
    }

    @Override
    public void enrichMovieWithCountries(Movie movie) {
        Map<Integer, String> countriesMap = countryDao.getAll().stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

            for (Country movieCountry : movie.getCountries()) {
                if (Thread.currentThread().isInterrupted()) {
                    log.info("enrichMovieWithCountries was interrupted due to timeout");
                    break;
                }
                else {
                    movieCountry.setName(countriesMap.get(movieCountry.getId()));
                }
            }

    }

    @Override
    public void addCountryMapping(List<Country> countries, int movieId) {
        countryDao.addCountryMapping(countries,movieId);
    }

    @Override
    public void removeCountryMappingsByIds(List<Country> countries, int movieId) {
        countryDao.removeCountryMappingsByIds(countries,movieId);
    }

}