package com.pursuit.nycmenagerie.nav_drawer;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;

public class PollingLocationFragment extends Fragment {

    private Button btn_web_pollsite_locator;
    private ImageView sticker_i_voted;
    private OnFragmentInteraction listener;


    public PollingLocationFragment() {
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
        return inflater.inflate(R.layout.fragment_polling_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sticker_i_voted = view.findViewById(R.id.logo_vote_nyc);
        btn_web_pollsite_locator = view.findViewById(R.id.btn_web_pollsite_locator);

        sticker_i_voted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.openNYCBOEPollsiteLocator(getString(R.string.link_pollsite_locator));
                }
            }
        });

        btn_web_pollsite_locator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.openNYCBOEPollsiteLocator(getString(R.string.link_pollsite_locator));
                }
            }
        });
    }
}
