//package com.stezhka.util;
//
//import com.stezhka.entity.Movie;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class JsonManualConverter {
//    private static final String COMMA_SEPARATOR = ",";
//    private static final String COLON_SEPARATOR = ":";
//
//    public String toJson(List<Movie> movie) {
//        StringBuilder json = new StringBuilder("{");
//        String[] movieFieldNames = {"id", "nameNative", "nameRussian", "yearOfRelease", "description", "rating", "price", "poster", "votes", "countries", "genres"};
//        Object[] movieFields = {movie.getId(), movie.getNameNative(), movie.getNameRussian(), movie.getYearOfRelease(), movie.getDescription(), movie.getRating(), movie.getPrice(), movie.getPoster(), movie.getVotes(), movie.getCountries(), movie.getGenres()};
//        for (int i = 0; i < movieFieldNames.length; i++) {
//            json.append(surroundByQuotes(movieFieldNames[i]));
//            json.append(COLON_SEPARATOR);
//            json.append(surroundByQuotes(movieFields[i]));
//            if (i != movieFieldNames.length - 1) {
//                json.append(COMMA_SEPARATOR);
//            }
//        }
//        json.append("}");
//        return json.toString();
//    }
//
//    private String surroundByQuotes(Object value) {
//        return "\"" + value + "\"";
//    }
//}
//
////    id, nameRussian, nameNative, yearOfRelease, description, rating, price, poster, votes;
////    List<Country> countries, List<Genre> genres;