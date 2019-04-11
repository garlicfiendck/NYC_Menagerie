package com.pursuit.nycmenagerie.tab_upcoming_election;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.nycmenagerie.R;

public class DscUpElectionFragment extends Fragment {


    public DscUpElectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dsc_up_election, container, false);
    }

}
