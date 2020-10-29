package com.nickxiu.fitimer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class PageFragment extends Fragment {
    private static final String TAG = "LandingPage";

    private ViewGroup viewGroup;
    private OnClickListener callback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(
                R.layout.slide_page_1, container, false);
        setEventTrackers();
        return viewGroup;
    }

    private void setEventTrackers() {
        Log.i(TAG, "setEventTrackers");
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick");
                callback.onLandingPageClick();
            }
        });
    }

    public void setOnClickListener(OnClickListener callback) {
        Log.i(TAG, "setOnClickListener");
        this.callback = callback;
    }

    public interface OnClickListener {
        void onLandingPageClick();
    }
}
