package com.example.dizzer.themoviedb.view;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dizzer.themoviedb.R;
import com.example.dizzer.themoviedb.model.Movie;
import com.example.dizzer.themoviedb.presenter.MovieListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private MovieListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvMovies);
        adapter = new MovieListAdapter(this);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        recyclerView.setAdapter(adapter);


        List<Movie> testList = new ArrayList<>();

        for (int i = 0; i <= 9; i++){
            Movie movie = new Movie();
            movie.setPosterPath("\\/uC6TTUhPpQCmgldGyYveKRAu8JN.jpg");
            movie.setTitle(""+i);
            movie.setVoteCount(i);
            movie.setVoteAverage(7.2d);
            testList.add(movie);
        }

        showMovieList(testList);
    }

    @Override
    public void showMovieList(List<Movie> movies) {
        adapter.sedData(movies);
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
