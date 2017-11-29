package com.stezhka.web.controller;

import com.stezhka.entity.Movie;
import com.stezhka.service.MovieService;
import com.stezhka.web.dto.MovieDto;
import com.stezhka.web.util.JsonJacksonConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    private final MovieService movieService;

    private final ModelMapper modelMapper;

    @Autowired
    public MovieController(MovieService movieService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getAll() {
        List<Movie> movies = movieService.getAll();
        List<MovieDto> movieDtos = movies.stream().map(this::movieToDto)
                .collect(Collectors.toList());
        return JsonJacksonConverter.movietoJson(movieDtos);
    }

    @RequestMapping(value = "/movie/random", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getRandom() {
        List<Movie> movies = movieService.getRandom();
        List<MovieDto> movieDtos = movies.stream().map(this::movieToDto)
                .collect(Collectors.toList());
        return JsonJacksonConverter.movietoJson(movieDtos);
    }

    private MovieDto movieToDto(Movie movie){
        return modelMapper.map(movie, MovieDto.class);
    }
}
