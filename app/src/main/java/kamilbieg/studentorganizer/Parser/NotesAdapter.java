package kamilbieg.studentorganizer.Parser;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import kamilbieg.studentorganizer.DataBase.SQLiteHelper;
import kamilbieg.studentorganizer.Note;
import kamilbieg.studentorganizer.Adapters.RecyclerViewAdapter;

public class NotesAdapter implements NotesLoaderCallback{

    private Activity mActivity;
    private RecyclerView mRecyclerView;

    public NotesAdapter(Activity activity){

        this.mActivity = activity;
    }

    public void loadNotesToRecyclerView(RecyclerView recyclerView){

        this.mRecyclerView = recyclerView;
        NotesLoaderThread notesLoaderThread = new NotesLoaderThread(this);
        notesLoaderThread.start();

        SQLiteHelper db = new SQLiteHelper(mActivity);
        SQLiteDatabase database = db.getWritableDatabase();

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

    private List<Note> getFilteredList(List<Note> noteList){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        String string = simpleDateFormat.format(date);

        List<Note> list = new LinkedList<>();

        for (Note note:
                noteList) {
            if(String.valueOf(note.getDate()).equals(string)){
                list.add(note);
            }
        }

        return list;
    }
}
