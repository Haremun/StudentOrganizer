package kamilbieg.studentorganizer.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kamilbieg.studentorganizer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {


    public StudyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study, container, false);
    }

}
