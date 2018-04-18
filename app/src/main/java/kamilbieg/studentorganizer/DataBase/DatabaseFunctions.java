package kamilbieg.studentorganizer.DataBase;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import kamilbieg.studentorganizer.Note;

public class DatabaseFunctions {

    public void addListToDatabase(Activity activity, List<Note> noteList){

        for (Note note :
                noteList) {
            SQLiteHelper sqLiteHelper = new SQLiteHelper(activity);
            SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseStructure.COLUMN_NAME_TYPE, note.getType());
            contentValues.put(DatabaseStructure.COLUMN_NAME_NAME, note.getName());
            contentValues.put(DatabaseStructure.COLUMN_NAME_DATE, note.getDate());
            contentValues.put(DatabaseStructure.COLUMN_NAME_STARTHOUR, note.getStartHour());
            contentValues.put(DatabaseStructure.COLUMN_NAME_STOPTHOUR, note.getStopHour());
            contentValues.put(DatabaseStructure.COLUMN_NAME_DESC, note.getDescription());
            contentValues.put(DatabaseStructure.COLUMN_NAME_NOTETYPE, note.getmNoteType());

            Log.i("Database", note.getStartHour());
            db.insert(DatabaseStructure.TABLE_NAME, null, contentValues);
        }

    }
}
