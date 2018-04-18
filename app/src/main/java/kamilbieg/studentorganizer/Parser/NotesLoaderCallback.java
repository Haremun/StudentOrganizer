package kamilbieg.studentorganizer.Parser;

import java.util.List;

import kamilbieg.studentorganizer.Note;

public interface NotesLoaderCallback {

    void onLoad(List<Note> noteList);
}
