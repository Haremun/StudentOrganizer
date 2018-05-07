package kamilbieg.studentorganizer.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private SqlQuery sqlQuery;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes_database.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        sqlQuery = new SqlQuery();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlQuery.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sqlQuery.dropTable());
        onCreate(db);

    }

}
