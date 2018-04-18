package kamilbieg.studentorganizer.Callbacks;

import java.util.List;

import kamilbieg.studentorganizer.Note;

public interface DatabaseLoaderCallback {

    void onDatabaseLoad(List<Note> noteList);
}
