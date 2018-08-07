package com.example.dizzer.themoviedb.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dizzer.themoviedb.R;
import com.example.dizzer.themoviedb.model.Movie;
import com.example.dizzer.themoviedb.presenter.MainPresenter;
import com.example.dizzer.themoviedb.presenter.MovieListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    @BindView(R.id.offlineContainer)
    ConstraintLayout offlineContainer;
    private MovieListAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MainPresenter();

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RecyclerView recyclerView = findViewById(R.id.rvMovies);
        adapter = new MovieListAdapter(this);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bindView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unbindView();
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
        offlineContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoConnectionInfo() {
        offlineContainer.setVisibility(View.GONE);
    }

    @OnClick(R.id.btnRetry)
    public void retryClick(){
        presenter.retryLoadData();
    }
}
