package com.learn.robby.moviecatalogue2.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.robby.moviecatalogue2.DetailActivity;
import com.learn.robby.moviecatalogue2.Model.Tv;
import com.learn.robby.moviecatalogue2.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.CardViewViewHolder>{

    private ArrayList<Tv> listTv;

    public TvAdapter(ArrayList<Tv> list) {
        this.listTv = list;
    }

    @NonNull
    @Override
    public TvAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv, viewGroup, false);
        return new TvAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.CardViewViewHolder holder, final int position) {
        Tv tv = listTv.get(position);
        holder.tvTitle.setText(tv.getTitle());
        String[] arrFact = tv.getFact().split("-");
        holder.tvDate.setText(arrFact[3]);
        holder.tvDescription.setText(tv.getDescription());
        holder.imgPhoto.setImageResource(tv.getPhoto());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Tv", listTv.get(position));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTv.size();
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
