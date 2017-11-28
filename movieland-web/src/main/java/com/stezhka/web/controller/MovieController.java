package com.stezhka.web.controller;

import com.stezhka.entity.Movie;
import com.stezhka.service.MovieService;
import com.stezhka.web.dto.MovieDto;
import com.stezhka.web.util.JsonJacksonConverter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    private final MovieService movieService;
    private final ModelMapper modelMapper;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public MovieController(MovieService movieService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getAll() {
        logger.debug("Start getting all movies from service");
        long startTime = System.currentTimeMillis();

        List<Movie> movies = movieService.getAll();
        List<MovieDto> movieDtos = movies.stream().map(this::movieToDto)
                .collect(Collectors.toList());

        logger.debug("End getting all movies from service. It was taken in {} ms", System.currentTimeMillis() - startTime);

        return JsonJacksonConverter.toJson(movieDtos);
    }

    @RequestMapping(value = "/movie/random", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getRandom() {
        logger.debug("Start getting three random movies from service");
        long startTime = System.currentTimeMillis();

        List<Movie> movies = movieService.getRandom();
        List<MovieDto> movieDtos = movies.stream().map(this::movieToDto)
                .collect(Collectors.toList());

        logger.debug("End getting three random movies from service. It was taken in {} ms", System.currentTimeMillis() - startTime);
        return JsonJacksonConverter.toJson(movieDtos);
    }

    private MovieDto movieToDto(Movie movie){
        return modelMapper.map(movie, MovieDto.class);
    }
}
