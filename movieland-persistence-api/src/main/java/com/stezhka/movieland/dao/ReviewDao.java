package com.stezhka.movieland.dao;


import com.stezhka.movieland.entity.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getReviewsByMovieId(int movieId);
    Review addReview(Review review);
}
