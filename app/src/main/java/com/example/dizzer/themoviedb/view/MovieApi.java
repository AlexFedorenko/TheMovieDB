package com.example.dizzer.themoviedb.view;

import com.example.dizzer.themoviedb.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/top_rated")
    Call<MovieList> fetchTopRated(@Query("api_key") String apiKey);
}
