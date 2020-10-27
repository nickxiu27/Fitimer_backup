package com.nickxiu.fitimer;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideStatusBar();

        // FrameLayout mainContainer = findViewById(R.id.main_container);
        // View.inflate(this, R.layout.timer_view, (ViewGroup) findViewById(R.id.main_container));
        // View.inflate(this, R.layout.activity_screen_slide, (ViewGroup) findViewById(R.id.main_container));
        // View.inflate(this, R.layout.slide_page_1, (ViewGroup) findViewById(R.id.main_container));
        // View.inflate(this, R.layout.slide_page_2, (ViewGroup) findViewById(R.id.main_container));
        // new TimerImpl(this, findViewById(R.id.timer_view));
        // Removing nav bar according to new design
        // View.inflate(this, R.layout.nav_bar, (ViewGroup) findViewById(R.id.nav_bar_container));

        ViewPager viewPager
                = findViewById(
                R.id.view_pager);

        // Create an adapter that
        // knows which fragment should
        // be shown on each page
        TimerFragmentPagerAdapter
                adapter
                = new TimerFragmentPagerAdapter(
                getSupportFragmentManager());

        // Set the adapter onto
        // the view pager
        viewPager.setAdapter(adapter);
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
