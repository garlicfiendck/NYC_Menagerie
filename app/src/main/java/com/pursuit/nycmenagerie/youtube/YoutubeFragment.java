package com.pursuit.nycmenagerie.youtube;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.pursuit.nycmenagerie.BuildConfig;
import com.pursuit.nycmenagerie.R;

public class YoutubeFragment extends Fragment {
    private FragmentActivity myContext;

    private YouTubePlayer tubePlayer;
    private static final String YOUTUBE_KEY = "Youtube Key";
    private static final String YT_DEVELOPER_KEY = BuildConfig.ApiKey;

    public YoutubeFragment() {
    }

    public static YoutubeFragment newInstance(String videoUrl) {
        YoutubeFragment youtubeFragment = new YoutubeFragment();
        Bundle ytArgs = new Bundle();
        ytArgs.putString(YOUTUBE_KEY, videoUrl);
        youtubeFragment.setArguments(ytArgs);
        youtubeFragment.setRetainInstance(true);
        return youtubeFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentActivity) {
            myContext = (FragmentActivity) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_youtube, container, false);

        final Bundle ytArgs = getArguments();

        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.frame_frg_youtube, youTubePlayerSupportFragment)
                .commit();

        youTubePlayerSupportFragment.initialize(YT_DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                if (!wasRestored) {
                    tubePlayer = youTubePlayer;
                    tubePlayer.loadVideo(ytArgs.getString(YOUTUBE_KEY));
                    tubePlayer.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
               //youtube error
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}




