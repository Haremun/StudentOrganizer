package kamilbieg.studentorganizer.HttpConection;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnection {

    private BufferedReader bufferedReader;
    private Activity activity;

    public void connect(){
        final String path = "http://api.ukw.edu.pl/services/tt/upcoming_ical?lang=pl&user_id=56721&key=Y4zJPByUy3Nh66vmYAfB";
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Connect to server
            InputStream inputStream = connection.getInputStream(); //Get input stream
            InputStreamReader isReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(isReader); //Load stream to buffered reader


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader getInputFromSite() {
        return bufferedReader;
    }
}
