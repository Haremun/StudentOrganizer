package kamilbieg.studentorganizer.Callbacks;

import java.util.List;

import kamilbieg.studentorganizer.Note;

public interface NotesLoaderCallback {

    void onLoad(List<Note> noteList);
}
