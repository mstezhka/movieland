package com.stezhka.service;

import com.stezhka.entity.Genre;
import com.stezhka.entity.Movie;

import java.util.List;

public interface GenreService {

    List<Genre> getAll();

    void FillMovieWithGenres(List<Movie> movies);

}
