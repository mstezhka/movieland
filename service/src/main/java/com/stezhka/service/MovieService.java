package com.stezhka.service;

import com.stezhka.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    List<Movie> getRandom();
}
