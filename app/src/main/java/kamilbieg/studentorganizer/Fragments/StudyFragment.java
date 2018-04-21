package kamilbieg.studentorganizer.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import kamilbieg.studentorganizer.NotesAdapter;
import kamilbieg.studentorganizer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {

    @BindView(R.id.my_recycler_view) RecyclerView recyclerView;

    public StudyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study, container, false);
        ButterKnife.bind(this, view);

        NotesAdapter notesAdapter = new NotesAdapter(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(null);
        notesAdapter.loadNotesToRecyclerView(recyclerView);

        return view;
    }

}
