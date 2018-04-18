package kamilbieg.studentorganizer.Parser;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import kamilbieg.studentorganizer.Note;

public class ICalParser {


    public List<Note> parseICalStringToList(BufferedReader bufferedReader) throws IOException {

        List<Note> noteList = new LinkedList<>();
        String line;
        Note temp = null;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null){


            if(line.length() > 11){
                if(line.substring(0, 12).equals("BEGIN:VEVENT")){
                    temp = new Note();
                    temp.setmNoteType("Study"); //Note from student schedule
                    count = 0;
                    Log.i("ICalParser", "New Object------------------");
                    continue;
                }
            }
            if(count == 0 && temp != null){
                temp.setType(line.substring(8, 11));
                temp.setName(line.substring(14, line.length()));
                Log.i("ICalParser", line.substring(14, line.length()));
                //Log.i("ICalParser", tempString.length()+"");
            } else if(count == 1 && temp != null){
                temp.setDate(line.substring(24, 32));
                temp.setStartHour(line.substring(33, line.length()));
                Log.i("ICalParser", line.substring(33, line.length()));
            } else if(count == 2 && temp != null){
                temp.setStopHour(line.substring(31, line.length()));
                Log.i("ICalParser", line.substring(31, line.length()));

            } else if(count == 5 && temp != null){
                temp.setDescription(line.substring(12, line.indexOf("n") - 1));
                Log.i("ICalParser", line.substring(12, line.indexOf("n") - 1));
                noteList.add(temp);
            }

            count++;
        }
        return noteList;

    }
}
