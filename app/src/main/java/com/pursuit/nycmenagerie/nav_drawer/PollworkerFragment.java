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

import com.chabbal.slidingdotsplash.SlidingSplashView;
import com.pursuit.nycmenagerie.R;
import com.pursuit.nycmenagerie.tab_pollworker.DscAPFragment;
import com.pursuit.nycmenagerie.tab_pollworker.DscINTFragment;
import com.pursuit.nycmenagerie.tab_pollworker.DscPWFragment;
import com.pursuit.nycmenagerie.tab_pollworker.PollworkerTabAdapter;


public class PollworkerFragment extends Fragment implements ViewPager.OnPageChangeListener{

    private PollworkerTabAdapter pwAdapter;
    private TabLayout pwTabLayout;
    private ViewPager pwViewPager;

    public PollworkerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pollworker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pwViewPager = view.findViewById(R.id.pw_viewPager);
        pwTabLayout = view.findViewById(R.id.pw_tabLayout);

        pwAdapter = new PollworkerTabAdapter(getChildFragmentManager());

        pwAdapter.addFragment(new DscPWFragment(), "Pollworker");
        pwAdapter.addFragment(new DscINTFragment(), "Interpreter");
        pwAdapter.addFragment(new DscAPFragment(), "Apply");

        pwViewPager.setAdapter(pwAdapter);

        pwTabLayout.setupWithViewPager(pwViewPager);
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

