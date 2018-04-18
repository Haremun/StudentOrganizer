package kamilbieg.studentorganizer.Parser;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;

public class NotesLoader extends Thread {

    private Activity activity;
    private NotesLoaderCallback mCallback;

    public NotesLoader(Activity activity, NotesLoaderCallback callback){
        this.activity = activity;
        this.mCallback = callback;
    }

    @Override
    public void run() {
        try {

            HttpConnection httpConnection = new HttpConnection();
            httpConnection.connect();
            BufferedReader bufferedReader = httpConnection.getInputFromSite();
            ICalParser parser = new ICalParser();
            parser.parseICalStringToList(bufferedReader);

        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
