package com.example.dizzer.themoviedb.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.dizzer.themoviedb.model.Movie;
import com.example.dizzer.themoviedb.model.MovieList;
import com.example.dizzer.themoviedb.util.App;
import com.example.dizzer.themoviedb.view.MainView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<List<Movie>, MainView> {

    private String TAG = "MainPresenter";
    private boolean isLoadingData = false;

    @Override
    protected void updateView() {
        if (model.size() == 0) {
            view().showEmpty();
        } else {
            view().showMovieList(model);
        }
    }

    @Override
    public void bindView(@NonNull MainView view) {
        super.bindView(view);

        if (model == null && !isLoadingData) {
            view().showLoading();
            loadData();
        }
    }

    public void retryLoadData(){
        view().showLoading();
        loadData();
    }

    private void loadData() {
        isLoadingData = true;
        loadMovieList();
    }

    private void loadMovieList(){

        final Call<MovieList> call = App.getApi().fetchTopRated(App.API_KEY);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                Log.i(TAG, call.request().url().toString());
                Log.i(TAG, "Response Status code: " + response.code());

                MovieList fetchedMovies = response.body();
                model = new ArrayList<>();
                model.addAll(fetchedMovies.getResults());

                view().hideNoConnectionInfo();
                setModel(model);

                Log.i(TAG, model.size() + " movies found");
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                view().showNoConnectionInfo();
            }
        });

    }
}
