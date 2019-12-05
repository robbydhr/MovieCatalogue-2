package com.learn.robby.moviecatalogue2.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.robby.moviecatalogue2.DetailActivity;
import com.learn.robby.moviecatalogue2.Model.Movie;
import com.learn.robby.moviecatalogue2.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CardViewViewHolder>{

    private ArrayList<Movie> listMovie;

    public MovieAdapter(ArrayList<Movie> list) {
        this.listMovie = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.CardViewViewHolder holder, final int position) {
        final Movie movie = listMovie.get(position);
        holder.tvTitle.setText(movie.getTitle());
        String[] arrFact = movie.getFact().split("-");
        holder.tvDate.setText(arrFact[3]);
        holder.tvDescription.setText(movie.getDescription());
        holder.imgPhoto.setImageResource(movie.getPhoto());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Movie", listMovie.get(position));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvDescription, tvDate;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvTitle = itemView.findViewById(R.id.txt_title);
            tvDate = itemView.findViewById(R.id.txt_date);
            tvDescription = itemView.findViewById(R.id.txt_description);
        }
    }
}
