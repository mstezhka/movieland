package com.stezhka.web.controller;

import com.stezhka.entity.Movie;
import com.stezhka.service.MovieService;
import com.stezhka.web.dto.MovieDto;
import com.stezhka.web.util.JsonJacksonConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/movie", produces = "application/json;charset=utf-8")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    protected ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll() {
        List<Movie> movies = movieService.getAll();
        List<MovieDto> movieDtos = movies.stream().map(movie -> movieToDto(movie))
                .collect(Collectors.toList());
        return JsonJacksonConverter.toJson(movieDtos);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public String getRandom() {
        List<Movie> movies = movieService.getRandom();
        List<MovieDto> movieDtos = movies.stream().map(movie -> movieToDto(movie))
                .collect(Collectors.toList());
        String json = JsonJacksonConverter.toJson(movieDtos);
        return json;
    }

    private MovieDto movieToDto(Movie movie){
        MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
        return movieDto;
    }
}
