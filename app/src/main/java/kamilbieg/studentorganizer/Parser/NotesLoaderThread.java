package kamilbieg.studentorganizer.Parser;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;

public class NotesLoaderThread extends Thread {

    private NotesLoaderCallback mCallback;

    public NotesLoaderThread(NotesLoaderCallback callback){
        this.mCallback = callback;
    }

    @Override
    public void run() {
        try {

            HttpConnection httpConnection = new HttpConnection();
            httpConnection.connect();
            BufferedReader bufferedReader = httpConnection.getInputFromSite();
            ICalParser parser = new ICalParser();
            mCallback.onLoad(parser.parseICalStringToList(bufferedReader));

        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
