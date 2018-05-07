package kamilbieg.studentorganizer;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import kamilbieg.studentorganizer.Callbacks.NotesLoaderCallback;
import kamilbieg.studentorganizer.Database.DatabaseFunctions;
import kamilbieg.studentorganizer.HttpConection.HttpConnection;
import kamilbieg.studentorganizer.Parser.ICalParser;

public class NotesLoaderThread extends Thread {

    private NotesLoaderCallback mCallback;
    private Activity mActivity;

    public NotesLoaderThread(Activity activity, NotesLoaderCallback callback){
        this.mCallback = callback;
        this.mActivity = activity;
    }

    @Override
    public void run() {
        try {

            HttpConnection httpConnection = new HttpConnection();
            httpConnection.connect();
            BufferedReader bufferedReader = httpConnection.getInputFromSite();
            ICalParser parser = new ICalParser();
            List<Note> noteList = parser.parseICalStringToList(bufferedReader);
            DatabaseFunctions databaseFunctions = new DatabaseFunctions();
            databaseFunctions.addListToDatabase(mActivity, noteList);
            mCallback.onLoad(noteList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
