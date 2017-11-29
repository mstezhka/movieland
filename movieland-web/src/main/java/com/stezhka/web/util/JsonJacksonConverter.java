package com.stezhka.web.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stezhka.web.dto.MovieDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JsonJacksonConverter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(List<MovieDto> movies){
        try {
            return objectMapper.writeValueAsString(movies);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Movie can't be sesialized to JSON", e);
        }
    }
}
