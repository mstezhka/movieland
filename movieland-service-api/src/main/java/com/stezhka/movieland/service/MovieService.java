package com.stezhka.movieland.service;

import com.stezhka.movieland.entity.Movie;
import com.stezhka.movieland.dao.enums.SortDirection;

import java.util.List;
import java.util.Map;

public interface MovieService {
    List<Movie> getAllMovies(Map<String, SortDirection> sortType);

    List<Movie> getRandomMovies();

    List<Movie> getMoviesByGenreId(int id, Map<String, SortDirection> sortType);

    Movie getMovieById(int movieId);

    Movie addMovie(Movie movie);

    void editMovie(Movie movie);
}
