package com.example.parking;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
 int tabcount;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior ,int tabcount) {
        super(fm, behavior);
        this.tabcount = tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new frag1();
            case 1:
                return new frag2();
            case 2:
                return new frag3();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {

        return tabcount;
    }
}
