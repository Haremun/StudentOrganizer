package kamilbieg.studentorganizer.Fragments;


import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.Unbinder;
import kamilbieg.studentorganizer.AnimatedFab;
import kamilbieg.studentorganizer.DialogFragments.CallDialog;
import kamilbieg.studentorganizer.DialogFragments.SimpleDialog;
import kamilbieg.studentorganizer.Enums.Direction;
import kamilbieg.studentorganizer.Enums.NotesFilter;
import kamilbieg.studentorganizer.Enums.RecyclerViewLayoutType;
import kamilbieg.studentorganizer.GUI.RecyclerViewGui;
import kamilbieg.studentorganizer.NotesAdapter;
import kamilbieg.studentorganizer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {


    public NotesFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.fab_new_note)
    FloatingActionButton fabNewNote;
    @BindView(R.id.fab_bottom)
    FloatingActionButton fab_bottom;
    @BindView(R.id.fab_center)
    FloatingActionButton fab_center;
    @BindView(R.id.fab_top)
    FloatingActionButton fab_top;
    @BindView(R.id.recycler_notes)
    RecyclerView recyclerViewNotes;

    private AnimatedFab fab1;
    private AnimatedFab fab2;
    private AnimatedFab fab3;


    private Unbinder unbinder;
    private boolean btnClicked = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        unbinder = ButterKnife.bind(this, view);

        NotesAdapter notesAdapter = new NotesAdapter(getActivity());
        RecyclerViewGui recyclerViewGui = new RecyclerViewGui(getContext(), recyclerViewNotes);
        recyclerViewGui.setRecyclerView(RecyclerViewLayoutType.StaggeredGridLayout);
        notesAdapter.loadNotesToRecyclerView(recyclerViewNotes, NotesFilter.All);

        fab1 = new AnimatedFab(getContext(), fab_bottom, Direction.Bottom);
        fab2 = new AnimatedFab(getContext(), fab_center, Direction.Center);
        fab3 = new AnimatedFab(getContext(), fab_top, Direction.Top);
        fab1.setMoveVector(1.7, 0.25);
        fab2.setMoveVector(1.5, 1.5);
        fab3.setMoveVector(0.25, 1.7);

        return view;
    }

    @Override
    public void onResume() {
        Log.i("NoteFragment", "onResume");
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab_new_note)
    public void oneOfTree() {

        if (!btnClicked) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_animated_add, null);
            fab1.show();
            fab2.show();
            fab3.show();
            btnClicked = true;
            fabNewNote.setImageDrawable(animatedVectorDrawable);
            if (animatedVectorDrawable != null)
                animatedVectorDrawable.start();
        } else {
            AnimatedVectorDrawable reverseAnimation = (AnimatedVectorDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_animated_add_reverse, null);
            fab1.hide();
            fab2.hide();
            fab3.hide();
            btnClicked = false;
            fabNewNote.setImageDrawable(reverseAnimation);
            if (reverseAnimation != null)
                reverseAnimation.start();
        }
    }

    @OnLongClick(R.id.fab_new_note)
    public boolean addFast() {

        if(!btnClicked){
            Vibrator v = (Vibrator) Objects.requireNonNull(getContext()).getSystemService(Context.VIBRATOR_SERVICE);
            AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
            if (v != null && audioManager != null && audioManager.getRingerMode() != AudioManager.RINGER_MODE_SILENT) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(80, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v.vibrate(80);
                }
            }

            DialogFragment simpleDialog = new SimpleDialog();
            simpleDialog.show(Objects.requireNonNull(getFragmentManager()), "SimpleDialog");
        }
        return true;

    }

    @OnClick({R.id.fab_center, R.id.fab_top, R.id.fab_bottom})
    public void onClickCall(FloatingActionButton fab){

        switch (fab.getId()){
            case R.id.fab_center:
                DialogFragment callDialog = new CallDialog();
                callDialog.show(Objects.requireNonNull(getFragmentManager()), "CallDialog");
        }
    }


}
