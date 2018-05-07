package com.stezhka.movieland.web.controller;

import com.stezhka.movieland.entity.Genre;
import com.stezhka.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public GenreController(GenreService genreService
                           ) {
        this.genreService = genreService;
    }

    @RequestMapping(method = GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Genre> getAll() {
        log.info("Sending request to get all genres");
        long startTime = System.currentTimeMillis();
        List<Genre> genres = genreService.getAll();
        log.info("Genres are received. It took {} ms", System.currentTimeMillis() - startTime);
        return genres;
    }


}
