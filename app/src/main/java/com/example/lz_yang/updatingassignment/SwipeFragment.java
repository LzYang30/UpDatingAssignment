package com.example.lz_yang.updatingassignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;
import com.mindorks.butterknifelite.annotations.OnClick;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import com.example.lz_yang.updatingassignment.swipe.*;

/**
 * Created by Lz-Yang on 18/12/2016.
 */

public class SwipeFragment extends Fragment {

    @BindView(R.id.swipeView)
    private SwipePlaceHolderView mSwipView;

    public SwipeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        ButterKnifeLite.bind(this,view);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSwipView.disableTouchSwipe();
        mSwipView.getBuilder()
//                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_VERTICAL)
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setWidthSwipeDistFactor(15)
                .setHeightSwipeDistFactor(20)
                .setSwipeDecor(new SwipeDecor()
//                        .setMarginTop(300)
//                        .setMarginLeft(100)
//                        .setViewGravity(Gravity.TOP)
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        TinderCard tinderCard1 = new TinderCard();
        TinderCard tinderCard2 = new TinderCard();
        TinderCard tinderCard3 = new TinderCard();
        TinderCard tinderCard4 = new TinderCard();
        TinderCard tinderCard5 = new TinderCard();
        TinderCard tinderCard6 = new TinderCard();
        TinderCard tinderCard7 = new TinderCard();
        TinderCard tinderCard8 = new TinderCard();

        mSwipView.addView(tinderCard1)
                .addView(tinderCard2)
                .addView(tinderCard3)
                .addView(tinderCard4)
                .addView(tinderCard5)
                .addView(tinderCard6)
                .addView(tinderCard7)
                .addView(tinderCard8)
                .addView(new TinderCard())
                .addView(new TinderCard());

        tinderCard1.setProfileImageView(R.drawable.yoona1);
        tinderCard2.setProfileImageView(R.drawable.yoona2);
        tinderCard3.setProfileImageView(R.drawable.yoona3);
//        tinderCard4.setProfileImageView(R.drawable.yoona4);
//        tinderCard5.setProfileImageView(R.drawable.yoona5);
//        tinderCard6.setProfileImageView(R.drawable.yoona6);
//        tinderCard7.setProfileImageView(R.drawable.yoona7);
//        tinderCard8.setProfileImageView(R.drawable.yoona8);

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(8000);
                    mSwipView.enableTouchSwipe();
//                    mSwipView.lockViews();
//                    Thread.currentThread().sleep(4000);
//                    mSwipView.unlockViews();
//                    Thread.currentThread().sleep(4000);
//                    mSwipView.lockViews();
//                    Thread.currentThread().sleep(4000);
//                    mSwipView.unlockViews();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @OnClick(R.id.imageViewDown)
    private void onRejectClick(){
        mSwipView.doSwipe(false);
    }

    @OnClick(R.id.imageViewUp)
    private void onAcceptClick(){
        mSwipView.doSwipe(true);
    }
}
