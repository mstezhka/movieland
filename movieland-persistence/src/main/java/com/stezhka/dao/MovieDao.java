package com.stezhka.dao;

import com.stezhka.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAllMovies();

    List<Movie> getThreeRandomMovies();

    List<Movie> getMoviesByGenreId(int genreId);
}
