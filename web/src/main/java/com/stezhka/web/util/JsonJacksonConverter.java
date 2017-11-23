package com.stezhka.web.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stezhka.web.dto.MovieDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonJacksonConverter {

    @Autowired
    private ModelMapper modelMapper;

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(List<MovieDto> movies){
        try {
            return objectMapper.writeValueAsString(movies);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
