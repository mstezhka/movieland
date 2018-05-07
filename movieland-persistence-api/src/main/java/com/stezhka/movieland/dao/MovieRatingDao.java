package com.stezhka.movieland.dao;


import com.stezhka.movieland.entity.Rating;
import com.stezhka.movieland.entity.UserMovieRate;

import java.util.List;
import java.util.Map;


public interface MovieRatingDao {
    void flushRatesToPersistence(List<UserMovieRate> rates);
    Map<Integer,Rating> getMoviesRatings();
}
