package com.stezhka.dao.jdbc;

import com.stezhka.dao.CountryDao;
import com.stezhka.dao.jdbc.mapper.CountryRowMapper;
import com.stezhka.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    private static final CountryRowMapper countryRowMapper = new CountryRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllCountriesSQL;

    @Override
    public List<Country> getAllCountries(){
        List<Country> countries = jdbcTemplate.query(getAllCountriesSQL, countryRowMapper);
        return countries;
    }

}