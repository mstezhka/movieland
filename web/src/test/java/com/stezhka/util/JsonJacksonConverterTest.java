package com.stezhka.util;

import com.stezhka.entity.Country;
import com.stezhka.entity.Genre;
import com.stezhka.entity.Movie;
import com.stezhka.web.controller.MovieController;
import com.stezhka.web.dto.MovieDto;
import com.stezhka.web.util.JsonJacksonConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class JsonJacksonConverterTest {

    @Test
    public void testToJson() {

        String json = "[{\"id\":1,\"nameRussian\":\"ТестФильм1\",\"nameNative\":\"TestMovie1\",\"yearOfRelease\":1984,\"description\":\"description1\",\"rating\":9.5,\"price\":100.5,\"poster\":\"http://posterfilm1.com\",\"votes\":100,\"countries\":[{\"id\":1,\"countryName\":\"USSR\"}],\"genres\":[{\"id\":1,\"genreName\":\"horror\"}]}]";
        List<Country> countries = new ArrayList<>();
        countries.add(new Country(1, "USSR"));
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(1, "horror"));
        MovieDto movieDto1 = new MovieDto(1, "ТестФильм1", "TestMovie1", 1984, "description1", 9.5, 100.5, "http://posterfilm1.com", 100, countries, genres);
        List<MovieDto> movies = new ArrayList<>();
        movies.add(movieDto1);
        String jsonConverted = JsonJacksonConverter.toJson(movies);

        assertEquals(json, jsonConverted);
    }

}
