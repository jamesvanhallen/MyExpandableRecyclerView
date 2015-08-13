package com.futureinapps.myexpandablerecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fappsilya on 29.07.15.
 */
public class ContentFragment extends Fragment {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, v);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewCreator();


        return v;
    }

    private void RecyclerViewCreator() {

       List<String> list = Arrays.asList("1 итем 1 секция", "2 итем 1 секция", "1 итем 2 секция", "2 итем 2 секция", "3 итем 2 секция", "1 итем 3 секция", "2 итем 3 секция");

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), list);

        List<ContentAdapter.Section> sections =
                new ArrayList<>();

            sections.add(new ContentAdapter.Section(0, "Первая секция"));
            sections.add(new ContentAdapter.Section(2, "Вторая секция"));
            sections.add(new ContentAdapter.Section(5, "Третья секция"));


        ContentAdapter.Section[] dummy = new ContentAdapter.Section[sections.size()];
        ContentAdapter mSectionedAdapter = new
                ContentAdapter(getActivity(), R.layout.section, R.id.section_text, adapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        mRecyclerView.setAdapter(mSectionedAdapter);
    }


}
