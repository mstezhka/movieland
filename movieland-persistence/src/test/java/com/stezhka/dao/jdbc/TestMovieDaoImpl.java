package com.stezhka.dao.jdbc;

import com.stezhka.dao.MovieDao;
import com.stezhka.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.*;
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

    @Test
    public void testGetMoviesByGenreId(){
        List<Movie> movies = movieDao.getMoviesByGenreId(13);
        int i = 0;

        String sql="select * from movie_genre where genre_id=13";

        try {
            Connection connection = getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
               i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(i, movies.size());

    }

    private static Connection getDBConnection() {
        final String DB_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_CONNECTION = "jdbc:mysql://localhost:3306/movieland?characterEncoding=UTF-8";
        final String DB_USER = "root";
        final String DB_PASSWORD = "qaz";
        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
