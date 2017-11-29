package com.stezhka.controller;

import com.stezhka.entity.Genre;
import com.stezhka.web.dto.GenreDto;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class GenreControllerTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testGenreToDto(){
        Genre genre = new Genre();
        genre.setId(1);
        genre.setName("TestGenre");

        GenreDto genreDto = modelMapper.map(genre, GenreDto.class);

        assertEquals(genreDto.getId(), genre.getId());
        assertEquals(genreDto.getName(), genre.getName());
    }
}
