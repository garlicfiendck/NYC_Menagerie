package com.pursuit.nycmenagerie.tab_pollworker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.nycmenagerie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DscPWFragment extends Fragment {


    public DscPWFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dsc_pw, container, false);
    }

}
