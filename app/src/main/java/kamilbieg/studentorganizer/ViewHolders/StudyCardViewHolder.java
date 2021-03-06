package kamilbieg.studentorganizer.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kamilbieg.studentorganizer.R;

public class StudyCardViewHolder extends RecyclerView.ViewHolder {

    private TextView mName;
    private TextView mHour;
    private TextView mDesc;
    private TextView mType;


    public StudyCardViewHolder(View view) {
        super(view);
        mName = (TextView) view.findViewById(R.id.text_name);
        mHour = (TextView) view.findViewById(R.id.text_hour);
        mDesc = (TextView) view.findViewById(R.id.text_desc);
        mType = (TextView) view.findViewById(R.id.text_type);
    }

    public TextView getmName() {
        return mName;
    }

    public TextView getmHour() {
        return mHour;
    }

    public TextView getmDesc() {
        return mDesc;
    }

    public TextView getmType() {
        return mType;
    }
}
