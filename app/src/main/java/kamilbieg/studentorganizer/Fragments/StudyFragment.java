package kamilbieg.studentorganizer.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import kamilbieg.studentorganizer.Enums.NotesFilter;
import kamilbieg.studentorganizer.Enums.RecyclerViewLayoutType;
import kamilbieg.studentorganizer.GUI.RecyclerViewGui;
import kamilbieg.studentorganizer.NotesAdapter;
import kamilbieg.studentorganizer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {

    @BindView(R.id.recycler_study) RecyclerView recyclerView;

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
        RecyclerViewGui recyclerViewGui = new RecyclerViewGui(getContext(), recyclerView);
        recyclerViewGui.setRecyclerView(RecyclerViewLayoutType.LinearLayout);
        notesAdapter.loadNotesToRecyclerView(recyclerView, NotesFilter.Study);

        return view;
    }

}
