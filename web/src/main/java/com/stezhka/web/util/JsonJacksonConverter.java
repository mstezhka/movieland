package com.stezhka.web.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stezhka.entity.Movie;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JsonJacksonConverter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(List<Movie> movies){
        try {
            return objectMapper.writeValueAsString(movies);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
