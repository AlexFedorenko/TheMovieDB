package com.example.dizzer.themoviedb.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dizzer.themoviedb.R;
import com.example.dizzer.themoviedb.model.Movie;
import com.example.dizzer.themoviedb.util.MovieUtil;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.internal.Util;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MovieListAdapter(Context context) {
        this.context = context;
        this.movies = new ArrayList<>();
    }

    public void sedData(List<Movie> movies) {
        if (this.movies != null && movies.size() > 0) {
            this.movies.clear();
            this.movies.addAll(movies);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        double voteAverage = movies.get(position).getVoteAverage();
        int voteCount = movies.get(position).getVoteCount();
        Picasso.get()
                .load(MovieUtil.constructURL(movies.get(position)))
                .into(holder.ivMoviePoster);
        holder.tvMovieTitle.setText(movies.get(position).getTitle());
        holder.tvRateInfo.setText(context.getString(R.string.movie_votes, String.valueOf(voteAverage), voteCount));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivMoviePoster)
        ImageView ivMoviePoster;
        @BindView(R.id.tvMovieTitle)
        TextView tvMovieTitle;
        @BindView(R.id.tvRateInfo)
        TextView tvRateInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
