package com.nickxiu.fitimer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class LandingPage extends Fragment {
    private static final String TAG = "LandingPage";

    private ViewGroup viewGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(
                R.layout.timer_view, container, false);
        setEventTrackers();
        return viewGroup;
    }

    private void addPage() {

    }

    private void setEventTrackers() {
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPage();
            }
        });
    }
}
