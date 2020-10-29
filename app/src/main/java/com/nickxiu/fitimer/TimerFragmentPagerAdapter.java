package com.nickxiu.fitimer;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TimerFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public TimerFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<>();
        initializeLandingPage();
    }

    public void addFragment(Fragment fragment) {
        if (fragments.isEmpty()) {
            fragments.add(fragment);
        } else {
            fragments.add(fragments.size()-1/* Always add to the immediate left */, fragment);
        }
        notifyDataSetChanged();
    }

    private void initializeLandingPage() {
        addFragment(new PageFragment());
    }

    public void initializeTimer() {
        addFragment(new TimerImpl());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
//        if (position == 0) {
//            return new TimerImpl();
//        } else if (position == 1) {
//            return new PageFragment();
//        } else {
//            return new PageFragment2();
//        }
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object){
        /*
         * called when the fragments are reordered to get the
         * changes.
         */
        int idx = fragments.indexOf((Fragment) object);
        return idx < 0 ? POSITION_NONE : idx;
    }

    @Override
    public long getItemId(int position) {
        /*
         * map to a position independent ID, because this
         * adapter reorders fragments
         */
        return System.identityHashCode(fragments.get(position));
    }
}