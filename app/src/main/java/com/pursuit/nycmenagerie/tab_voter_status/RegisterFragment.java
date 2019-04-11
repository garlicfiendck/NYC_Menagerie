package com.pursuit.nycmenagerie.tab_voter_status;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;

public class RegisterFragment extends Fragment {

    private OnFragmentInteraction listener;

    public RegisterFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteraction) {
            listener = (OnFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
