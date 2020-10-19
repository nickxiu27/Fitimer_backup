package com.nickxiu.fitimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideStatusBar();

        // FrameLayout mainContainer = findViewById(R.id.main_container);
        View.inflate(this, R.layout.timer_view, (ViewGroup) findViewById(R.id.main_container));
        new TimerImpl(this, findViewById(R.id.timer_view));
        // Removing nav bar according to new design
        // View.inflate(this, R.layout.nav_bar, (ViewGroup) findViewById(R.id.nav_bar_container));
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideStatusBar();
    }

    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
