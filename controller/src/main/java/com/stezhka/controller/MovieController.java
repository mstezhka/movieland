package com.stezhka.controller;

import com.stezhka.entity.Movie;
import com.stezhka.service.MovieService;
import com.stezhka.util.JsonJacksonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonJacksonConverter jsonJacksonConverter;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getAll() {
        List<Movie> movies = movieService.getAll();
        String json=JsonJacksonConverter.toJson(movies);
        return json;
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public String getRandom() {
        List<Movie> movies = movieService.getRandom();
        String json = JsonJacksonConverter.toJson(movies);
        return json;
    }
}
