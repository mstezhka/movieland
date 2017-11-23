package com.stezhka.controller;

import com.stezhka.entity.Movie;
import com.stezhka.web.dto.MovieDto;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class MovieControllerTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testMovieToDto(){
        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("ТестФиль2");
        movie.setNameNative("TestMovie2");
        movie.setYearOfRelease(1984);
        movie.setDescription("Good TestMovie2");
        movie.setRating(9.5);
        movie.setPrice(100.1);
        movie.setPoster("http://TestMovie2");
        movie.setVotes(100);

        MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
        assertEquals(movieDto.getId(), movie.getId());
        assertEquals(movieDto.getNameRussian(), movie.getNameRussian());
        assertEquals(movieDto.getNameNative(), movie.getNameNative());
        assertEquals(movieDto.getYearOfRelease(), movie.getYearOfRelease());
        assertEquals(movieDto.getDescription(), movie.getDescription());
        assertEquals(movieDto.getRating(), movie.getRating(), 0.001);
        assertEquals(movieDto.getPrice(), movie.getPrice(), 0.001);
        assertEquals(movieDto.getPoster(), movie.getPoster());
        assertEquals(movieDto.getVotes(), movie.getVotes());
    }

}
