package com.stezhka.util;

import com.stezhka.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonJacksonConverterTest {

    @Test
    public void testToJson() {

        String json = "[{\"id\":1,\"nameRussian\":\"ТестФильм1\",\"nameNative\":\"TestMovie1\",\"yearOfRelease\":1984,\"description\":\"description1\",\"rating\":9.5,\"price\":100.5,\"poster\":\"http://posterfilm1.com\",\"votes\":100}]";
        Movie movie1 = new Movie(1, "ТестФильм1", "TestMovie1", 1984, "description1", 9.5, 100.5, "http://posterfilm1.com", 100);
        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        String jsonConverted = JsonJacksonConverter.toJson(movies);

        assertEquals(json, jsonConverted);
    }

}
