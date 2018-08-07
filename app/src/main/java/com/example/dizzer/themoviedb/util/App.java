package com.example.dizzer.themoviedb.util;

import android.app.Application;

import com.example.dizzer.themoviedb.view.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "7c06988ba1e4f3e8df0df5d8392bb21e";
    public static MovieApi movieApi;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieApi = retrofit.create(MovieApi.class);
    }

    public static MovieApi getApi(){
        return movieApi;
    }
}
