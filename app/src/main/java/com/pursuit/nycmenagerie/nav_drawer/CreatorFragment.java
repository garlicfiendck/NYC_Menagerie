package com.pursuit.nycmenagerie.nav_drawer;


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
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;
import com.squareup.picasso.Picasso;


public class CreatorFragment extends Fragment {

    private static final String CLICK_TAG = "Click Tag";

    private OnFragmentInteraction listener;

    public CreatorFragment() {}

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
        return inflater.inflate(R.layout.fragment_creator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView photo_creator = view.findViewById(R.id.photo_creator);
        TextView name_creator = view.findViewById(R.id.name_creator);
        TextView bio_creator = view.findViewById(R.id.bio_creator);
        Button btn_linkedin = view.findViewById(R.id.btn_linkedin);
        Button btn_github_repo = view.findViewById(R.id.btn_github_repo);

        Picasso.get().load(R.drawable.v2_img_creator).into(photo_creator);

        name_creator.setText(getString(R.string.name_creator));
        bio_creator.setText(getString(R.string.bio_creator));
        btn_linkedin.setText(getString(R.string.btn_linkedin));
        btn_github_repo.setText(getString(R.string.btn_github_repo));

        btn_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    Log.d(CLICK_TAG, "onClick: button in working order");
                    listener.openLinkedin(getString(R.string.linkedin_creator));
                    Log.d(CLICK_TAG, "onClick: opening link");
                }
            }
        });

        btn_github_repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    Log.d(CLICK_TAG, "onClick: button in working order");
                    listener.openGithubRepo(getString(R.string.github_creator));
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
