package kamilbieg.studentorganizer.DataBase;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import kamilbieg.studentorganizer.Callbacks.DatabaseLoaderCallback;
import kamilbieg.studentorganizer.Callbacks.NotesLoaderCallback;
import kamilbieg.studentorganizer.Note;

public class DatabaseLoaderThread extends Thread {

    private Activity mActivity;
    private DatabaseLoaderCallback mCallback;

    public DatabaseLoaderThread(Activity activity, DatabaseLoaderCallback callback){
        this.mActivity = activity;
        this.mCallback = callback;
    }

    @Override
    public void run() {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(mActivity);
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();

        Cursor cursor = db.query(
                DatabaseStructure.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        List<Note> noteList = new LinkedList<>();
        while (cursor.moveToNext()){

            Note tempNote = new Note();
            tempNote.setType(cursor.getString(1));
            tempNote.setName(cursor.getString(2));
            tempNote.setDate(cursor.getString(3));
            tempNote.setStartHour(cursor.getString(4));
            tempNote.setStopHour(cursor.getString(5));
            tempNote.setDescription(cursor.getString(6));
            tempNote.setmNoteType(cursor.getString(7));

            noteList.add(tempNote);
        }
        cursor.close();
        mCallback.onDatabaseLoad(noteList);
        super.run();
    }
}
