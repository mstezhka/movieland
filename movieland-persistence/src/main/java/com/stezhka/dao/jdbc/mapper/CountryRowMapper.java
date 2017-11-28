package com.stezhka.dao.jdbc.mapper;

import com.stezhka.entity.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();

        country.setId(resultSet.getInt("id"));
        country.setCountryName(resultSet.getString("name"));

        return country;
    }

}
