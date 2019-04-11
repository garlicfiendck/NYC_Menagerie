package com.pursuit.nycmenagerie.tab_voter_status;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RegistrationTabAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> regTabList = new ArrayList<>();
    private final List<String> regTitleList = new ArrayList<>();

    public RegistrationTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return regTabList.get(i);
    }

    @Override
    public int getCount() {
        return regTabList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return regTitleList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        regTabList.add(fragment);
        regTitleList.add(title);
    }
}
