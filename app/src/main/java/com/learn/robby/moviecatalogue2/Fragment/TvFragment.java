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

import com.learn.robby.moviecatalogue2.Adapter.TvAdapter;
import com.learn.robby.moviecatalogue2.Model.Tv;
import com.learn.robby.moviecatalogue2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {

    private RecyclerView rvTv;
    private ArrayList<Tv> list = new ArrayList<>();

    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tv, container, false);

        rvTv = rootView.findViewById(R.id.rv_tv);
        rvTv.setHasFixedSize(true);
        list.addAll(getListTv());
        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvAdapter tvAdapter = new TvAdapter(list);
        rvTv.setAdapter(tvAdapter);
        rvTv.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    public ArrayList<Tv> getListTv() {
        String[] dataTitle = getResources().getStringArray(R.array.data_title_tv);
        String[] dataDescription = getResources().getStringArray(R.array.data_description_tv);
        String[] dataFact = getResources().getStringArray(R.array.data_fact_tv);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo_tv);
        ArrayList<Tv> listTv = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Tv tv = new Tv();
            tv.setTitle(dataTitle[i]);
            tv.setDescription(dataDescription[i]);
            tv.setFact(dataFact[i]);
            tv.setPhoto(dataPhoto.getResourceId(i, -1));
            listTv.add(tv);
        }
        return listTv;
    }

}
