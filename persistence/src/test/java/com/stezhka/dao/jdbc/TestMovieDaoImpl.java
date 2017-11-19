package com.stezhka.dao.jdbc;

import com.stezhka.dao.MovieDao;
import com.stezhka.entity.Movie;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@ContextConfiguration(locations = "classpath:/spring/jdbc-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMovieDaoImpl {
    @Autowired
    private MovieDao movieDao;

    @Test
    public void testGetAll(){
        List<Movie> movies = movieDao.getAllMovies();
        for (Movie movie:movies) {
            assertNotNull(movie.getId());
            assertNotNull(movie.getNameNative());
            assertNotNull(movie.getNameRussian());
            assertNotNull(movie.getPrice());
            assertNotNull(movie.getRating());
            assertNotNull(movie.getPoster());
        }
    }
    @Test
    public void testGetThreeRandom(){
        List<Movie> movies = movieDao.getThreeRandomMovies();
        assertEquals(3, movies.size());
    }
}
