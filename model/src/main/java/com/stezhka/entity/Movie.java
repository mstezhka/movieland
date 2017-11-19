package com.stezhka.entity;

import java.util.List;

public class Movie {
    private int id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String description;
    private double rating;
    private double price;
    private String poster;
    private int votes;
//    private List<Country> countries;
//    private List<Genre> genres;

    public Movie(int id, String nameRussian, String nameNative, int yearOfRelease, String description, double rating, double price, String poster, int votes
//                 List<Genre> genres, List<Country> countries
    ) {
        this.id = id;
        this.nameRussian = nameRussian;
        this.nameNative = nameNative;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.poster = poster;
        this.votes = votes;
//        this.genres = genres;
//        this.countries = countries;
    }

    public Movie() {

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNameRussian() {return nameRussian;}
    public void setNameRussian(String name_russian) {this.nameRussian = name_russian;}

    public String getNameNative() {return nameNative;}
    public void setNameNative(String name_native) {this.nameNative = name_native;}

    public int getYearOfRelease() {return yearOfRelease;}
    public void setYearOfRelease(int yearOfRelease) {this.yearOfRelease = yearOfRelease;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getRating() {return rating;}
    public void setRating(double rating) {this.rating = rating;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getPoster() {return poster;}
    public void setPoster(String poster) {this.poster = poster;}

    public int getVotes() {return votes;}
    public void setVotes(int votes) {this.votes = votes;}

//    public List<Country> getCountries() {return countries;}

//    public void setCountries(List<Country> countries) {this.countries = countries;}


//    public List<Genre> getGenres() {return genres;}

//    public void setGenres(List<Genre> genres) {this.genres = genres;}

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name_russian='" + nameRussian + '\'' +
                ", name_native='" + nameNative + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", poster='" + poster + '\'' +
                ", votes=" + votes +
//                ", countries=" + countries +
//                ", genres=" + genres +
                '}';
    }
}
