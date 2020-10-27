package com.nickxiu.fitimer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TimerFragmentPagerAdapter
        extends FragmentPagerAdapter {

    public TimerFragmentPagerAdapter(
            FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TimerImpl();
        } else if (position == 1) {
            return new PageFragment();
        } else {
            return new PageFragment2();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}