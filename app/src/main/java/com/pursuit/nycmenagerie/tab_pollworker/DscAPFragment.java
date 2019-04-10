package com.pursuit.nycmenagerie.tab_pollworker;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;

public class DscAPFragment extends Fragment {

    private static final String CLICK_TAG = "Click Tag";

    private OnFragmentInteraction listener;


    public DscAPFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteraction){
            listener = (OnFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dsc_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn_ap_online = view.findViewById(R.id.btn_ap_online);
        Button btn_ap_pw_more_info = view.findViewById(R.id.btn_ap_pw_more_info);

        btn_ap_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    Log.d(CLICK_TAG, "onClick: button in working order");
                    listener.openLinkedin(getString(R.string.link_pw_ap_online));
                    Log.d(CLICK_TAG, "onClick: opening link");
                }
            }
        });

        btn_ap_pw_more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    Log.d(CLICK_TAG, "onClick: button in working order");
                    listener.openLinkedin(getString(R.string.link_ap_pw_more_info));
                    Log.d(CLICK_TAG, "onClick: opening link");
                }
            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
