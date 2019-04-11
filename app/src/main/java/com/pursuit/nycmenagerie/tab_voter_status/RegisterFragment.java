package com.pursuit.nycmenagerie.tab_voter_status;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;

public class RegisterFragment extends Fragment {

    private OnFragmentInteraction listener;

    public RegisterFragment(){}

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView hd_register_to_vote = view.findViewById(R.id.hd_register_to_vote);
        TextView txt_reg_intro = view.findViewById(R.id.txt_reg_intro);
        TextView txt_reg_1 = view.findViewById(R.id.txt_reg_1);
        TextView txt_reg_2 = view.findViewById(R.id.txt_reg_2);
        TextView txt_reg_3 = view.findViewById(R.id.txt_reg_3);

        Button btn_visit_boe_dl_app = view.findViewById(R.id.btn_visit_boe_dl_app);
        Button btn_boe_offices = view.findViewById(R.id.btn_boe_offices);
        Button btn_register_online = view.findViewById(R.id.btn_register_online);

        hd_register_to_vote.setText(getString(R.string.txt_hd_register_to_vote));
        txt_reg_intro.setText(R.string.txt_reg_intro);
        txt_reg_1.setText(R.string.txt_reg_1);
        txt_reg_2.setText(R.string.txt_reg_2);
        txt_reg_3.setText(R.string.txt_reg_3);

        btn_visit_boe_dl_app.setText(getString(R.string.txt_visit_boe_dl_app));
        btn_boe_offices.setText(getString(R.string.txt_boe_offices));
        btn_register_online.setText(R.string.txt_register_online);

        btn_visit_boe_dl_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.regVoteDLApp(getString(R.string.link_regVoteDLApp));
                }
            }
        });

        btn_boe_offices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.regVoteInPerson(getString(R.string.regVoteInPerson));
                }
            }
        });

        btn_register_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.regVoteOnline(getString(R.string.regVoteOnline));
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
