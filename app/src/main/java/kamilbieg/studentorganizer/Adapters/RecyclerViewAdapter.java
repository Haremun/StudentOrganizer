package kamilbieg.studentorganizer.Adapters;

import android.graphics.Color;
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

import kamilbieg.studentorganizer.MyViewHolder;
import kamilbieg.studentorganizer.Note;
import kamilbieg.studentorganizer.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Note> mNoteList;
    //private RecyclerView mRecyclerView;



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

        String type = note.getType();
        if(type.equals("WYK"))
            ((MyViewHolder) holder).getmType().setTextColor(0xFF3030F0);
        else
            ((MyViewHolder) holder).getmType().setTextColor(0xFFF03030);
        ((MyViewHolder) holder).getmType().setText(type);
        ((MyViewHolder) holder).getmDesc().setText(note.getDescription());
        ((MyViewHolder) holder).getmName().setText(note.getName());
        String tempHour = note.getStartHour();
        String hour = tempHour.substring(0, 2) + ":" + tempHour.substring(2, 4);
        ((MyViewHolder) holder).getmHour().setText(hour);

    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }
}
