package com.stezhka.web.controller;

import com.stezhka.entity.Genre;
import com.stezhka.service.GenreService;
import com.stezhka.web.dto.GenreDto;
import com.stezhka.web.util.JsonJacksonConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GenreController {

    private final GenreService genreService;
    private final ModelMapper modelMapper;

    @Autowired
    public GenreController(GenreService genreService, ModelMapper modelMapper) {
        this.genreService = genreService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/genre", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getAll() {
        List<Genre> movies = genreService.getAll();
        List<GenreDto> genreDtos = movies.stream().map(this::genreToDto)
                .collect(Collectors.toList());
        return JsonJacksonConverter.genretoJson(genreDtos);
    }

    private GenreDto genreToDto(Genre genre){
        return modelMapper.map(genre, GenreDto.class);
    }
}
