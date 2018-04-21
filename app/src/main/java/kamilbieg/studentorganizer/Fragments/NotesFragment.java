package kamilbieg.studentorganizer.Fragments;


import android.content.res.Resources;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import kamilbieg.studentorganizer.AnimatedFab;
import kamilbieg.studentorganizer.Enums.Direction;
import kamilbieg.studentorganizer.MainActivity;
import kamilbieg.studentorganizer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {


    public NotesFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.fab_new_note) FloatingActionButton fabNewNote;
    @BindView(R.id.fab_bottom) FloatingActionButton fab_bottom;
    @BindView(R.id.fab_center) FloatingActionButton fab_center;
    @BindView(R.id.fab_top) FloatingActionButton fab_top;


    private Unbinder unbinder;
    private boolean btnClicked = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        unbinder = ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab_new_note)
    public void oneOfTree() {

        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_animated_add, null);
        AnimatedVectorDrawable reverseAnimation = (AnimatedVectorDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_animated_add_reverse, null);

        AnimatedFab fab1 = new AnimatedFab(getContext(), fab_bottom, Direction.Bottom);
        AnimatedFab fab2 = new AnimatedFab(getContext(), fab_center, Direction.Center);
        AnimatedFab fab3 = new AnimatedFab(getContext(), fab_top, Direction.Top);
        fab1.setMoveVector(1.7, 0.25);
        fab2.setMoveVector(1.5, 1.5);
        fab3.setMoveVector(0.25, 1.7);
        if (!btnClicked){
            fab1.show();
            fab2.show();
            fab3.show();
            btnClicked = true;
            fabNewNote.setImageDrawable(animatedVectorDrawable);
            animatedVectorDrawable.start();
        }
        else{
            fab1.hide();
            fab2.hide();
            fab3.hide();
            btnClicked = false;
            fabNewNote.setImageDrawable(reverseAnimation);
            reverseAnimation.start();
        }
    }


}
