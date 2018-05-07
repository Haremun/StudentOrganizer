package kamilbieg.studentorganizer.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kamilbieg.studentorganizer.R;

public class CallCardViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.text_call_person)
    TextView mText;

    private Context mContext;
    private String mNumber;

    public CallCardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();

    }

    public TextView getText() {
        return mText;
    }
    public void setNumber(String number){
        mNumber = number;
    }

    @OnClick(R.id.img_call)
    public void call(){
        if(!mNumber.equals("")){
            String phone = "+48" + mNumber;
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            mContext.startActivity(intent);
        }

    }
}
