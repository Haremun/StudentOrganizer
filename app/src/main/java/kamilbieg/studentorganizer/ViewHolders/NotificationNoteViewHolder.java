package kamilbieg.studentorganizer.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kamilbieg.studentorganizer.R;

public class NotificationNoteViewHolder extends RecyclerView.ViewHolder {

    private TextView mText;
    private TextView mTextDayOfTheYear;
    private TextView mTextMonth;

    public NotificationNoteViewHolder(View itemView) {
        super(itemView);
        mText = (TextView) itemView.findViewById(R.id.text_fast_note);
        mTextDayOfTheYear = itemView.findViewById(R.id.text_day_of_the_month);
        mTextMonth = itemView.findViewById(R.id.text_month);
    }

    public TextView getText() {
        return mText;
    }

    public TextView getTextDayOfTheYear() {
        return mTextDayOfTheYear;
    }

    public TextView getTextMonth() {
        return mTextMonth;
    }
}
