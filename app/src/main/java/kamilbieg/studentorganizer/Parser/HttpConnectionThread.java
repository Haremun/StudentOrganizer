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

    private String input;
    private Activity activity;

    public HttpConnectionThread(Activity activity){
        this.activity = activity;
    }

    @Override
    public void run() {
        final String path = "http://api.ukw.edu.pl/services/tt/upcoming_ical?lang=pl&user_id=56721&key=Y4zJPByUy3Nh66vmYAfB";
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(isReader);
            String line;
            while ( (line = bufferedReader.readLine()) != null){
                input += line;
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

    public String getInput() {
        return input;
    }
}
