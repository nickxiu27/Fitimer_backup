package com.nickxiu.fitimer;

import android.content.Context;
import android.util.Log;
import android.view.View;

public class TimerImpl implements BaseTimerInterface {
    private static final String TAG = "TimerImpl";

    private final Context mContext;
    private final View mView;

    private boolean isRunning = false;

    public TimerImpl(Context context, View view) {
        mContext = context;
        mView = view;

        setEventTrackers();
    }

    @Override
    public void start() {
        Log.i(TAG, "start");
        isRunning = true;
    }

    @Override
    public void pause() {
        Log.i(TAG, "pause");
        isRunning = false;
    }

    @Override
    public void reset() {
        Log.i(TAG, "reset");
    }

    private void setEventTrackers() {
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    pause();
                } else {
                    start();
                }
            }
        });
    }
}
