package kamilbieg.studentorganizer.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kamilbieg.studentorganizer.ViewHolders.FastNoteViewHolder;
import kamilbieg.studentorganizer.ViewHolders.StudyCardViewHolder;
import kamilbieg.studentorganizer.Note;
import kamilbieg.studentorganizer.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Note> mNoteList;
    //private RecyclerView mRecyclerView;


    public RecyclerViewAdapter(List<Note> noteList) {

        this.mNoteList = noteList;
        //this.mRecyclerView = recyclerView;
    }

    @Override
    public int getItemViewType(int position) {
        switch (mNoteList.get(position).getmNoteType()) {
            case "Study":
                return 0;
            case "fastNote":
                return 1;
            default:
                return 0;

        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case 0: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view_study, parent, false);

                return new StudyCardViewHolder(view);
            }
            case 1: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view_fast_note, parent, false);

                return new FastNoteViewHolder(view);
            }
            default: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view_study, parent, false);

                return new StudyCardViewHolder(view);
            }
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Note note = mNoteList.get(position);

        switch (holder.getItemViewType()) {
            case 0: {
                String type = note.getType();
                if (type.equals("WYK"))
                    ((StudyCardViewHolder) holder).getmType().setTextColor(0xFF3030F0);
                else
                    ((StudyCardViewHolder) holder).getmType().setTextColor(0xFFF03030);
                ((StudyCardViewHolder) holder).getmType().setText(type);
                ((StudyCardViewHolder) holder).getmDesc().setText(note.getDescription());
                ((StudyCardViewHolder) holder).getmName().setText(note.getName());
                String tempHour = note.getStartHour();
                String hour = tempHour.substring(0, 2) + ":" + tempHour.substring(2, 4);
                ((StudyCardViewHolder) holder).getmHour().setText(hour);
            }
            case 1:{
                String text = note.getDescription();
                ((FastNoteViewHolder) holder).getText().setText(text);
            }
        }

    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }
}
