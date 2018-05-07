package com.stezhka.movieland.service;

import com.stezhka.movieland.entity.Genre;
import com.stezhka.movieland.entity.Movie;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();

    void enrichMoviesWithGenres(List<Movie> movies);

    void enrichMovieWithGenres(Movie movie);

    void addGenreMapping(List<Genre> genres,int movieId);

    void removeGenreMappingsByIds(List<Genre> genres, int movieId);
}
