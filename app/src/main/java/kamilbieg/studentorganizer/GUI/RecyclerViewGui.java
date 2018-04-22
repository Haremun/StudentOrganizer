package kamilbieg.studentorganizer.GUI;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import kamilbieg.studentorganizer.Enums.RecyclerViewLayoutType;

public class RecyclerViewGui {

    private RecyclerView mRecyclerView;
    private Context mContext;

    public RecyclerViewGui(Context context, RecyclerView recyclerView){

        this.mRecyclerView = recyclerView;
        this.mContext = context;
    }

    public void setRecyclerView(RecyclerViewLayoutType layoutType){
        mRecyclerView.setHasFixedSize(true);
        switch (layoutType){
            case LinearLayout:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                break;
            case StaggeredGridLayout:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(null);
    }
}
