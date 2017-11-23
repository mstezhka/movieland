package com.stezhka.entity;

public class MovieCountry {
    private int movieId;
    private int countryId;

    public MovieCountry(int movieId, int countryId) {
        this.movieId = movieId;
        this.countryId = countryId;
    }

    public int getMovieId() {return movieId;}

    public void setMovieId(int movieId) {this.movieId = movieId;}

    public int getCountryId() {return countryId;}

    public void setCountryId(int countryId) {this.countryId = countryId;}

    @Override
    public String toString() {
        return "MovieCountry{" +
                "movieId=" + movieId +
                ", countryId=" + countryId +
                '}';
    }
}
