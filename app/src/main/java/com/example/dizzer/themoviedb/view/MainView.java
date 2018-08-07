package com.example.dizzer.themoviedb.view;

import android.graphics.Movie;

import java.util.List;

public interface MainView {
    void showMovieList(List<Movie> movies);

    void showLoading();

    void showEmpty();

    void showNoConnectionInfo();
}
