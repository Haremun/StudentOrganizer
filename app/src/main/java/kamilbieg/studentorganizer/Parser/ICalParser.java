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
        String[] noteValues = new String[7];;
        int count = 0;

        while ((line = bufferedReader.readLine()) != null){


            if(line.length() > 11){
                if(line.substring(0, 12).equals("BEGIN:VEVENT")){
                    temp = new Note();
                    noteValues[0] = "Study";
                    //temp.setNoteType("Study"); //Note from student schedule
                    count = 0;
                    Log.i("ICalParser", "New Object------------------");
                    continue;
                }
            }
            if(count == 0 && temp != null){
                noteValues[1] = line.substring(8, 11);
                noteValues[2] = line.substring(14, line.length());
                //temp.setType(line.substring(8, 11));
                //temp.setName(line.substring(14, line.length()));
                Log.i("ICalParser", line.substring(14, line.length()));

            } else if(count == 1 && temp != null){
                noteValues[3] = line.substring(24, 32);
                noteValues[4] = line.substring(33, line.length());
                Log.i("ICalParser", line.substring(33, line.length()));
            } else if(count == 2 && temp != null){
                noteValues[5] = line.substring(31, line.length());
                Log.i("ICalParser", line.substring(31, line.length()));

            } else if(count == 5 && temp != null){
                noteValues[6] = line.substring(12, line.indexOf("n") - 1);
                Log.i("ICalParser", line.substring(12, line.indexOf("n") - 1));
                temp = Note.builder()
                        .noteType("Study")
                        .classType(noteValues[1])
                        .name(noteValues[2])
                        .startDate(noteValues[3])
                        .endDate(noteValues[3])
                        .startHour(noteValues[4])
                        .endHour(noteValues[5])
                        .description(noteValues[6])
                        .build();

                noteList.add(temp);
            }

            count++;
        }
        return noteList;

    }
}
