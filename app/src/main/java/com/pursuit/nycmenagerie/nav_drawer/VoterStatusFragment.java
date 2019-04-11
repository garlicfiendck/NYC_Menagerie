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
import com.pursuit.nycmenagerie.tab_voter_status.CheckRegFragment;
import com.pursuit.nycmenagerie.tab_voter_status.RegisterFragment;
import com.pursuit.nycmenagerie.tab_voter_status.RegistrationTabAdapter;


public class VoterStatusFragment extends Fragment implements ViewPager.OnPageChangeListener {


    private RegistrationTabAdapter regAdapter;
    private TabLayout regTabLayout;
    private ViewPager regViewPager;

    public VoterStatusFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_voter_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        regViewPager = view.findViewById(R.id.reg_viewPager);
        regTabLayout = view.findViewById(R.id.reg_tabLayout);

        regAdapter = new RegistrationTabAdapter(getChildFragmentManager());

        regAdapter.addFragment(new CheckRegFragment(), "Check Registration");
        regAdapter.addFragment(new RegisterFragment(), "Register");

        regViewPager.setAdapter(regAdapter);

        regTabLayout.setupWithViewPager(regViewPager);

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
