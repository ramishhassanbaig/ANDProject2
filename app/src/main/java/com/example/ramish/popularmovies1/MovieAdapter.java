package com.example.ramish.popularmovies1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {


    private ItemSelectedListener itemSelectedListener;
    private ArrayList<Movie> movieArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);

        holder.title_tv.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView post_img;
        TextView title_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            post_img = itemView.findViewById(R.id.poster_img);
            title_tv = itemView.findViewById(R.id.title_tv);


        }
    }

    public void setItemSelectedListener(@Nullable ItemSelectedListener itemSelectedListener) {
        this.itemSelectedListener = itemSelectedListener;
    }

    public interface ItemSelectedListener {
        void onItemClicked(Movie movie);
    }
}
