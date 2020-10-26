package com.nickxiu.fitimer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TimerImpl implements BaseTimerInterface {
    private static final String TAG = "TimerImpl";
    private static final int UNIT = 60;

    private final Context mContext;
    private final View mView;
    private final TextView mMinuteTextView;
    private final TextView mSecondTextView;

    private boolean isRunning = false;
    private int currentTextViewSeconds = 0;
    private Timer timer;

    // The starting point of a running segment.
    private long startingTimestamp = 0;
    // If pauses happened, this is the actual starting point, summing up previous running segments.
    private long cumulativeStartingTime = 0;
    // This keeps track of the total time of all running segments.
    private long cumulativeRunningTime = 0;

    public TimerImpl(Context context, View view) {
        mContext = context;
        mView = view;
        mMinuteTextView = view.findViewById(R.id.minute_text_view);
        mSecondTextView = view.findViewById(R.id.second_text_view);

        setEventTrackers();

    }

    @Override
    public void start() {
        Log.i(TAG, "start");
        isRunning = true;
        timer = new Timer();
        startingTimestamp = System.currentTimeMillis();
        cumulativeStartingTime = startingTimestamp - cumulativeRunningTime;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if ((System.currentTimeMillis() - cumulativeStartingTime) / 1000 > currentTextViewSeconds) {
                    currentTextViewSeconds++;
                    setTextView();
                }
            }
        }, 0, 50);
    }

    @Override
    public void pause() {
        Log.i(TAG, "pause");
        isRunning = false;
        cumulativeRunningTime += System.currentTimeMillis() - startingTimestamp;
        timer.cancel();
    }

    @Override
    public void reset() {
        Log.i(TAG, "reset");
        isRunning = false;
        timer.cancel();
        currentTextViewSeconds = 0;
        setTextView();
    }

    private void setTextView() {
        mSecondTextView.setText(String.format(Locale.US, "%02d", currentTextViewSeconds % UNIT));
        mMinuteTextView.setText(String.format(Locale.US, "%02d", currentTextViewSeconds / UNIT % UNIT));
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

        mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reset();
                return true;
            }
        });
    }
}
