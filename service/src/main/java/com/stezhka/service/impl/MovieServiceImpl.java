package com.stezhka.service.impl;

import com.stezhka.dao.MovieDao;
import com.stezhka.entity.Movie;
import com.stezhka.service.CountryService;
import com.stezhka.service.GenreService;
import com.stezhka.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private CountryService countryService;

    @Autowired
    protected GenreService genreService;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAllMovies();
    }

    @Override
    public List<Movie> getRandom() {
        List<Movie> movies = movieDao.getThreeRandomMovies();
        countryService.FillMoviesWithCountries(movies);
        genreService.FillMovieWithGenres(movies);
        return movies;
    }
}
