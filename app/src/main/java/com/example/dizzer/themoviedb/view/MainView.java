package com.example.dizzer.themoviedb.view;

import com.example.dizzer.themoviedb.model.Movie;

import java.util.List;

public interface MainView {
    void showMovieList(List<Movie> movies);

    void showLoading();

    void showEmpty();

    void showNoConnectionInfo();
}
