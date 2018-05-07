package com.stezhka.movieland.service;

import com.stezhka.movieland.entity.Movie;
import com.stezhka.movieland.entity.Review;


public interface ReviewService {
    void enrichMovieWithReviews(Movie movie);
    Review addReview(Review review);
}
