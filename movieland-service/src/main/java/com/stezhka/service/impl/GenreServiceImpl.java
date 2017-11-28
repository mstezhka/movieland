package com.stezhka.service.impl;


import com.stezhka.dao.GenreDao;
import com.stezhka.entity.Genre;
import com.stezhka.entity.Movie;
import com.stezhka.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService{

    private GenreDao genreDao;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public GenreServiceImpl(GenreDao genreDao) {this.genreDao = genreDao;}

    @Override
    public List<Genre> getAll() {
        return genreDao.getAllGenres();
    }

    @Override
    public void FillMovieWithGenres(List<Movie> movies) {

        logger.info("Start enrichment of movies with genres");
        long startTime = System.currentTimeMillis();

        Map<Integer, String> genreMap = genreDao.getAllGenres().stream().collect(Collectors.toMap(Genre::getId, Genre::getGenreName));
        for (Movie movie: movies)
            for (Genre movieGenre : movie.getGenres()) {
            movieGenre.setGenreName(genreMap.get(movieGenre.getId()));
            }

        logger.info("End enrichment of movies with genres. It was enriched in {} ms", System.currentTimeMillis() - startTime);

    }

}
