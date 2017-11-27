package com.stezhka.dao.jdbc;

import com.stezhka.dao.GenreDao;
import com.stezhka.dao.jdbc.mapper.GenreRowmapper;
import com.stezhka.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao {
    private static final GenreRowmapper GENRE_ROW_MAPPER = new GenreRowmapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllGenresSQL;

    @Override
    public List<Genre> getAllGenres(){
        List<Genre> genres = jdbcTemplate.query(getAllGenresSQL, GENRE_ROW_MAPPER);
        return genres;
    }
}
