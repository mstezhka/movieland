package com.stezhka.dao.jdbc;

import com.stezhka.dao.GenreDao;
import com.stezhka.dao.jdbc.mapper.GenreRowMapper;
import com.stezhka.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();

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
