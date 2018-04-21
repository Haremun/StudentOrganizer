package kamilbieg.studentorganizer;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import kamilbieg.studentorganizer.Callbacks.DatabaseLoaderCallback;
import kamilbieg.studentorganizer.Callbacks.NotesLoaderCallback;
import kamilbieg.studentorganizer.DataBase.DatabaseLoaderThread;
import kamilbieg.studentorganizer.Adapters.RecyclerViewAdapter;

public class NotesAdapter implements NotesLoaderCallback, DatabaseLoaderCallback {

    private Activity mActivity;
    private RecyclerView mRecyclerView;

    public NotesAdapter(Activity activity) {

        this.mActivity = activity;
    }

    public void loadNotesToRecyclerView(RecyclerView recyclerView) {

        this.mRecyclerView = recyclerView;

        DatabaseLoaderThread databaseLoaderThread = new DatabaseLoaderThread(mActivity, this);
        databaseLoaderThread.start();

    }


    @Override
    public void onLoad(List<Note> noteList) {

        final List<Note> mNoteList = getFilteredList(noteList);


        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(new RecyclerViewAdapter(mNoteList));
                Log.i("NotesAdapter", "onLoad");
            }
        });

    }

    @Override
    public void onDatabaseLoad(List<Note> noteList) {

        if (noteList.isEmpty()) {
            NotesLoaderThread notesLoaderThread = new NotesLoaderThread(mActivity, this);
            notesLoaderThread.start();
        } else {
            final List<Note> mNoteList = getFilteredList(noteList);
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mRecyclerView.setAdapter(new RecyclerViewAdapter(mNoteList));
                    Log.i("NotesAdapter", "OnDataBaseLoad");
                }
            });
        }
    }

    private List<Note> getFilteredList(List<Note> noteList) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        String string = simpleDateFormat.format(date);

        List<Note> list = new LinkedList<>();

        for (Note note :
                noteList) {
            if (String.valueOf(note.getDate()).equals(string)) {
                list.add(note);
            }
        }

        return list;
    }


}
