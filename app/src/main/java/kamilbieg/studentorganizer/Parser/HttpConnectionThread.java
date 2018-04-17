package kamilbieg.studentorganizer.Parser;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnectionThread extends Thread {

    private BufferedReader bufferedReader;
    private Activity activity;

    public HttpConnectionThread(Activity activity){
        this.activity = activity;
    }

    @Override
    public void run() {
        final String path = "http://api.ukw.edu.pl/services/tt/upcoming_ical?lang=pl&user_id=56721&key=Y4zJPByUy3Nh66vmYAfB";
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Connect to server
            InputStream inputStream = connection.getInputStream(); //Get input stream
            InputStreamReader isReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(isReader); //Load stream to buffered reader

            ICalParser iCalParser = new ICalParser();
            try {
                iCalParser.parseICalStringToList(bufferedReader, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
