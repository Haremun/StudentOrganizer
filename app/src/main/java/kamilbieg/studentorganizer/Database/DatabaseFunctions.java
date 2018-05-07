package kamilbieg.studentorganizer.Database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import kamilbieg.studentorganizer.Note;

public class DatabaseFunctions {

    public void addListToDatabase(Activity activity, List<Note> noteList){

        for (Note note :
                noteList) {
            addNoteToDatabase(activity, note);
        }

    }

    public void addNoteToDatabase(Activity activity, Note note){

        SQLiteHelper sqLiteHelper = new SQLiteHelper(activity);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseStructure.COLUMN_NAME_CLASS_TYPE, note.getClassType());
        contentValues.put(DatabaseStructure.COLUMN_NAME_NAME, note.getName());
        contentValues.put(DatabaseStructure.COLUMN_NAME_START_DATE, note.getStartDate());
        contentValues.put(DatabaseStructure.COLUMN_NAME_END_DATE, note.getEndDate());
        contentValues.put(DatabaseStructure.COLUMN_NAME_START_HOUR, note.getStartHour());
        contentValues.put(DatabaseStructure.COLUMN_NAME_END_HOUR, note.getEndHour());
        contentValues.put(DatabaseStructure.COLUMN_NAME_DESC, note.getDescription());
        contentValues.put(DatabaseStructure.COLUMN_NAME_NOTE_TYPE, note.getNoteType());

        db.insert(DatabaseStructure.TABLE_NAME, null, contentValues);
    }
}
