package kamilbieg.studentorganizer;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import kamilbieg.studentorganizer.Enums.Direction;

public class AnimatedFab {

    private Context mContext;
    private FloatingActionButton mFab;
    private double moveX;
    private double moveY;
    private Direction mDirection;

    public AnimatedFab(Context context, FloatingActionButton fab, Direction direction) {
        this.mContext = context;
        this.mFab = fab;
        this.mDirection = direction;

        moveX = 1.7;
        moveY = 0.25;

    }

    public void setMoveVector(double x, double y){
        moveX = x;
        moveY = y;
    }


    public void show() {
        Animation show_fab = null;
        switch (mDirection){
            case Top:
                show_fab = AnimationUtils.loadAnimation(mContext, R.anim.show_top_fab);
                break;
            case Center:
                show_fab = AnimationUtils.loadAnimation(mContext, R.anim.show_center_fab);
                break;
            case Bottom:
                show_fab = AnimationUtils.loadAnimation(mContext, R.anim.show_bottom_fab);
        }

        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mFab.getLayoutParams();
        layoutParams.rightMargin += (int) (mFab.getWidth() * moveX); //1.7
        layoutParams.bottomMargin += (int) (mFab.getHeight() * moveY); //0.25
        mFab.setLayoutParams(layoutParams);
        mFab.startAnimation(show_fab);
        mFab.setClickable(true);
    }

    public void hide() {
        Animation hide_fab = null;
        switch (mDirection){
            case Top:
                hide_fab = AnimationUtils.loadAnimation(mContext, R.anim.hide_top_fab);
                break;
            case Center:
                hide_fab = AnimationUtils.loadAnimation(mContext, R.anim.hide_center_fab);
                break;
            case Bottom:
                hide_fab = AnimationUtils.loadAnimation(mContext, R.anim.hide_bottom_fab);
        }

        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mFab.getLayoutParams();
        layoutParams.rightMargin -= (int) (mFab.getWidth() * moveX);
        layoutParams.bottomMargin -= (int) (mFab.getHeight() * moveY);
        mFab.setLayoutParams(layoutParams);
        mFab.startAnimation(hide_fab);
        mFab.setClickable(false);
    }
}
