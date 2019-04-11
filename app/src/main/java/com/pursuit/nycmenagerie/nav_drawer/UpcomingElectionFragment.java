package com.pursuit.nycmenagerie.nav_drawer;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.nycmenagerie.R;
import com.pursuit.nycmenagerie.tab_pollworker.DscAPFragment;
import com.pursuit.nycmenagerie.tab_pollworker.DscINTFragment;
import com.pursuit.nycmenagerie.tab_pollworker.DscPWFragment;
import com.pursuit.nycmenagerie.tab_pollworker.PollworkerTabAdapter;
import com.pursuit.nycmenagerie.tab_upcoming_election.DscUpElectionFragment;
import com.pursuit.nycmenagerie.tab_upcoming_election.SaveTheDateFragment;


public class UpcomingElectionFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private PollworkerTabAdapter elAdapter;
    private TabLayout elTabLayout;
    private ViewPager elViewPager;

    public UpcomingElectionFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upcoming_election, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        elViewPager = view.findViewById(R.id.el_viewPager);
        elTabLayout = view.findViewById(R.id.el_tabLayout);

        elAdapter = new PollworkerTabAdapter(getChildFragmentManager());

        elAdapter.addFragment(new DscUpElectionFragment(), "Upcoming Elections");
        elAdapter.addFragment(new SaveTheDateFragment(), "Save the Date");

        elViewPager.setAdapter(elAdapter);

        elTabLayout.setupWithViewPager(elViewPager);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
