package com.stezhka.web.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.stezhka.entity.Country;
import com.stezhka.entity.Genre;

import java.util.List;

public class GenreDto {

    private int id;
    private String name;

    public GenreDto(int id, String name){
        this.id = id;
        this.name = name;
    }

    public GenreDto() {
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
