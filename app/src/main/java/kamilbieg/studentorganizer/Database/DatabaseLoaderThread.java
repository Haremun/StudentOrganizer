package kamilbieg.studentorganizer.Database;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import kamilbieg.studentorganizer.Callbacks.DatabaseLoaderCallback;
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

            Note tempNote = Note.builder()
                    .classType(cursor.getString(1))
                    .name(cursor.getString(2))
                    .startDate(cursor.getString(3))
                    .endDate(cursor.getString(4))
                    .startHour(cursor.getString(5))
                    .endHour(cursor.getString(6))
                    .description(cursor.getString(7))
                    .noteType(cursor.getString(8))
                    .build();

            noteList.add(tempNote);
        }
        cursor.close();
        mCallback.onDatabaseLoad(noteList);
        super.run();
    }
}
