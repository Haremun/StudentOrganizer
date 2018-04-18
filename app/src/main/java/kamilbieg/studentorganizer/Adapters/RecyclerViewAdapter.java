package kamilbieg.studentorganizer.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kamilbieg.studentorganizer.Note;
import kamilbieg.studentorganizer.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Note> mNoteList;
    //private RecyclerView mRecyclerView;

    private class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;

        public MyViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.card_title);
        }
    }

    public RecyclerViewAdapter(List<Note> noteList){

        this.mNoteList = noteList;
        //this.mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_card_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Note note = mNoteList.get(position);

        ((MyViewHolder) holder).mTitle.setText(note.getName());

    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }
}
