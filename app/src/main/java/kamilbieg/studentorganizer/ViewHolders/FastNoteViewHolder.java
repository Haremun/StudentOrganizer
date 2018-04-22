package kamilbieg.studentorganizer.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kamilbieg.studentorganizer.R;

public class FastNoteViewHolder extends RecyclerView.ViewHolder {

    private TextView mText;

    public FastNoteViewHolder(View itemView) {
        super(itemView);
        mText = (TextView) itemView.findViewById(R.id.text_fast_note);
    }

    public TextView getText() {
        return mText;
    }
}
