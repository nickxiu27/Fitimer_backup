package com.nickxiu.fitimer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

public class LandingPage extends Fragment {
    private static final String TAG = "LandingPage";

    private ViewGroup viewGroup;
    private OnClickListener callback;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(
                R.layout.landing_page_view, container, false);
        setEventTrackers();
        return viewGroup;
    }

    // On page click:
    // Show a pop up menu including all available timers.
    // Tapping on certain timer will create one, and jump to it if non-existing.
    // Otherwise go to the timer directly.
    private void setEventTrackers() {
        Log.i(TAG, "setEventTrackers");
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick");
                showPopupMenu();
            }
        });
    }

    private void showPopupMenu() {
        PopupMenu menu = new PopupMenu(context, viewGroup.findViewById(R.id.landing_page_text));
        menu.getMenuInflater().inflate(R.menu.timers_menu, menu.getMenu());
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Log.i(TAG, (String) item.getTitle());
                switch (item.getItemId()) {
                    case R.id.create_timer:
                        callback.createTimer();
                        return true;
                    case R.id.create_fit_timer:
                        callback.createFitTimer();
                        return true;
                    default:
                        return false;
                }
            }
        });
        menu.show();
    }

    public void setOnClickListener(OnClickListener callback) {
        Log.i(TAG, "setOnClickListener");
        this.callback = callback;
    }

    public interface OnClickListener {
        void createTimer();
        void createFitTimer();
    }
}
