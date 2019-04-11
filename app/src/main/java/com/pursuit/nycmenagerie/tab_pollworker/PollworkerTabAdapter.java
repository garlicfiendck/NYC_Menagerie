package com.pursuit.nycmenagerie.tab_pollworker;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PollworkerTabAdapter extends FragmentStatePagerAdapter {

    final private List<Fragment> pwTabList = new ArrayList<>();
    final private List<String> pwTitleList = new ArrayList<>();

    public PollworkerTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return pwTabList.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pwTitleList.get(position);
    }

    @Override
    public int getCount() {
        return pwTabList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        pwTabList.add(fragment);
        pwTitleList.add(title);
    }
}
