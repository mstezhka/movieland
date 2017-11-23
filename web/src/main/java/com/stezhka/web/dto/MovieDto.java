package com.stezhka.web.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.stezhka.entity.Country;
import com.stezhka.entity.Genre;

import java.util.List;

public class MovieDto {

    public MovieDto(int id, String nameRussian, String nameNative, int yearOfRelease, String description, double rating, double price, String poster, int votes, List<Country> countries, List<Genre> genres) {
        this.id = id;
        this.nameRussian = nameRussian;
        this.nameNative = nameNative;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.poster = poster;
        this.votes = votes;
        this.countries = countries;
        this.genres = genres;
    }

    public MovieDto() {
    }

    @JsonView(MovieView.Base.class)
    private int id;

    @JsonView(MovieView.Base.class)
    private String nameRussian;

    @JsonView(MovieView.Base.class)
    private String nameNative;

    @JsonView(MovieView.Base.class)
    private int yearOfRelease;

    @JsonView(MovieView.Base.class)
    private String description;

    @JsonView(MovieView.Base.class)
    private double rating;

    @JsonView(MovieView.Base.class)
    private double price;

    @JsonView(MovieView.Base.class)
    private String poster;

    @JsonView(MovieView.Base.class)
    private int votes;

    @JsonView(MovieView.Extended.class)
    private List<Country> countries;

    @JsonView(MovieView.Extended.class)
    private List<Genre> genres;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNameRussian() {return nameRussian;}
    public void setNameRussian(String nameRussian) {this.nameRussian = nameRussian;}

    public String getNameNative() {return nameNative;}
    public void setNameNative(String nameNative) {this.nameNative = nameNative;}

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

    public List<Country> getCountries() {return countries;}
    public void setCountries(List<Country> countries) {this.countries = countries;}

    public List<Genre> getGenres() {return genres;}
    public void setGenres(List<Genre> genres) {this.genres = genres;}

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameNative='" + nameNative + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", poster='" + poster + '\'' +
                ", votes=" + votes +
                ", countries=" + countries +
                ", genres=" + genres +
                '}';
    }

}
