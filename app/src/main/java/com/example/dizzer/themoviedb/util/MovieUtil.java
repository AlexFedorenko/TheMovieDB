package com.example.dizzer.themoviedb.util;

import com.example.dizzer.themoviedb.model.Movie;

public class MovieUtil {
    private static String PREFIX_URL_CONST = "http://image.tmdb.org/t/p/w500";
    public static String constructURL(Movie movie) {
        return  PREFIX_URL_CONST + movie.getPosterPath();
    }
}
