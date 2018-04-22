package kamilbieg.studentorganizer.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kamilbieg.studentorganizer.R;

public class CallCardViewHolder extends RecyclerView.ViewHolder {

    private TextView mText;
    public CallCardViewHolder(View itemView) {
        super(itemView);
        mText = itemView.findViewById(R.id.text_call_person);
    }

    public TextView getText() {
        return mText;
    }
}
