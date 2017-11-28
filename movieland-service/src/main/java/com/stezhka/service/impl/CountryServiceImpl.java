package com.stezhka.service.impl;

import com.stezhka.dao.CountryDao;
import com.stezhka.entity.Country;
import com.stezhka.entity.Movie;
import com.stezhka.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService{

    private CountryDao countryDao;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {this.countryDao = countryDao;}

    @Override
    public List<Country> getAll() {
        return countryDao.getAllCountries();
    }

    @Override
    public void fillMoviesWithCountries(List<Movie> movies) {
        logger.info("Start enrichment of movies with countries");
        long startTime = System.currentTimeMillis();

        Map<Integer, String> countryMap = countryDao.getAllCountries().stream().collect(Collectors.toMap(Country::getId, Country::getCountryName));
        for (Movie movie: movies)
            for (Country movieCountry : movie.getCountries()) {
                movieCountry.setCountryName(countryMap.get(movieCountry.getId()));
            }

        logger.info("End enrichment of movies with countries. It was taken in {} ms", System.currentTimeMillis() - startTime);

    }

}
