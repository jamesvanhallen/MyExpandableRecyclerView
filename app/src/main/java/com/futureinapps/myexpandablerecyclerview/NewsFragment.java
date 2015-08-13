package com.futureinapps.myexpandablerecyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by James on 04.07.2015.
 */
public class NewsFragment extends Fragment {

    @Bind(R.id.recyclerView)
    RecyclerView rv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, v);
        setupRecyclerView(rv, container);


        return  v;
    }

    private void setupRecyclerView(RecyclerView recyclerView, final ViewGroup container) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<String> newsList = Arrays.asList("news 1", "news 2", "news 2");


        final NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

    }
}
