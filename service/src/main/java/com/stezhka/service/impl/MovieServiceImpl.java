package com.stezhka.service.impl;

import com.stezhka.dao.MovieDao;
import com.stezhka.entity.Movie;
import com.stezhka.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAllMovies();
    }

    @Override
    public List<Movie> getRandom() {
        return movieDao.getThreeRandomMovies();
    }
}
