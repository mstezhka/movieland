package com.stezhka.movieland.service;


import com.stezhka.movieland.entity.UserMovieRate;

import java.util.Optional;

public interface MovieRatingService {
    void rateMovie(UserMovieRate userMovieRate);
    Optional<Double> getMovieRating(int movieId);

}
