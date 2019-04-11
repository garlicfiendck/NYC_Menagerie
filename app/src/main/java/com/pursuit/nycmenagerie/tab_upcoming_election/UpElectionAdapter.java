package com.pursuit.nycmenagerie.tab_upcoming_election;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class UpElectionAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> elTabList = new ArrayList<>();
    private final List<String> elTitleList = new ArrayList<>();

    public UpElectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return elTabList.get(i);
    }

    @Override
    public int getCount() {
        return elTabList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return elTitleList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        elTabList.add(fragment);
        elTitleList.add(title);
    }
}
