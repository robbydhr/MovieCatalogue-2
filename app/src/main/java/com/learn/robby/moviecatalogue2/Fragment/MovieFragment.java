package com.learn.robby.moviecatalogue2.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.robby.moviecatalogue2.Adapter.MovieAdapter;
import com.learn.robby.moviecatalogue2.Model.Movie;
import com.learn.robby.moviecatalogue2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;
    private ArrayList<Movie> list = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovie = rootView.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        list.addAll(getListMovie());
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(list);
        rvMovie.setAdapter(movieAdapter);
        rvMovie.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    public ArrayList<Movie> getListMovie() {
        String[] dataTitle = getResources().getStringArray(R.array.data_title_film);
        String[] dataDescription = getResources().getStringArray(R.array.data_description_film);
        String[] dataFact = getResources().getStringArray(R.array.data_fact_film);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo_film);
        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setFact(dataFact[i]);
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            listMovie.add(movie);
        }
        return listMovie;
    }
}
