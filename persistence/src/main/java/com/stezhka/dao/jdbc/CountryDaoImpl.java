package com.stezhka.dao.jdbc;

import com.stezhka.dao.CountryDao;
import com.stezhka.dao.jdbc.mapper.CountryRowmapper;
import com.stezhka.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    private static final CountryRowmapper COUNTRY_ROW_MAPPER = new CountryRowmapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllCountriesSQL;

    @Override
    public List<Country> getAllCountries(){
        List<Country> countries = jdbcTemplate.query(getAllCountriesSQL, COUNTRY_ROW_MAPPER);
        return countries;
    }

}