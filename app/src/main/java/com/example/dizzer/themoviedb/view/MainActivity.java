package com.example.dizzer.themoviedb.view;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dizzer.themoviedb.R;
import com.example.dizzer.themoviedb.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showMovieList(List<Movie> movies) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showNoConnectionInfo() {

    }
}
