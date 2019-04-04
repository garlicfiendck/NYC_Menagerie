package com.pursuit.nycmenagerie.civic_videos;


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

import com.bumptech.glide.Glide;
import com.pursuit.nycmenagerie.ApiClient;
import com.pursuit.nycmenagerie.ApiService;
import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VideoFragment extends Fragment {

    public static final String TITLE_KEY = "Title";
    public static final String VIDEO_KEY = "Video";
    private static final String CLICK_TAG = "Click Tag";

    private String title;
    private String videoUrl;

    private TextView txt_title_video;
    private ImageView img_thumbnail_video;
    private Button btn_play_video;

    private OnFragmentInteraction listener;

    public VideoFragment() {}

    public static VideoFragment newInstance(String title, String videoUrl){
        VideoFragment videoFragment = new VideoFragment();
        Bundle videoArgs = new Bundle();
        videoArgs.putString(TITLE_KEY, title);
        videoArgs.putString(VIDEO_KEY, videoUrl);
        videoFragment.setArguments(videoArgs);
        return videoFragment;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            title = getArguments().getString(TITLE_KEY);
            videoUrl = getArguments().getString(VIDEO_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_title_video = view.findViewById(R.id.txt_title_video);
        img_thumbnail_video = view.findViewById(R.id.img_thumbnail_video);
        btn_play_video = view.findViewById(R.id.btn_play_video);

        txt_title_video.setText(title);
        Picasso.get().load(videoUrl).into(img_thumbnail_video);

        btn_play_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(CLICK_TAG, "onClick: button in working order");
                if(listener != null){
                    listener.viewVideoViaWebView();
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
