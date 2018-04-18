package kamilbieg.studentorganizer.Parser;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

import kamilbieg.studentorganizer.Note;

public class NotesAdapter implements NotesLoaderCallback{

    private Activity mActivity;

    public NotesAdapter(Activity activity){

        this.mActivity = activity;
    }

    public void loadNotesToLayout(Activity activity){

        NotesLoader notesLoader = new NotesLoader(activity, this);
        notesLoader.start();
    }


    @Override
    public void onLoad(List<Note> noteList) {


        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
