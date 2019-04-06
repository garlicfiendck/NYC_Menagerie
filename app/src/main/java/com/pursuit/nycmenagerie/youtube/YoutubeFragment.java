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
import com.pursuit.nycmenagerie.R;

public class YoutubeFragment extends Fragment {
    private FragmentActivity myContext;

    private YouTubePlayer tubePlayer;
    public static final String YOUTUBE_KEY = "Youtube Key";
    public static final String YT_DEVELOPER_KEY = "AIzaSyDnLvtDzL4vCY-hIP8axH2GFv03XU6zLgs";
    public static final int RECOVERY_DIALOG_REQUEST = 1;

    public YoutubeFragment() {
    }

    public static YoutubeFragment newInstance(String videoUrl) {
        YoutubeFragment youtubeFragment = new YoutubeFragment();
        Bundle ytArgs = new Bundle();
        ytArgs.putString(YOUTUBE_KEY, videoUrl);
        youtubeFragment.setArguments(ytArgs);
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
        return inflater.inflate(R.layout.fragment_youtube, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Bundle ytArgs = getArguments();

        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.frg_youtube, youTubePlayerSupportFragment)
                .commit();

        youTubePlayerSupportFragment.initialize(YT_DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                if (!wasRestored) {
                    tubePlayer = youTubePlayer;
//                    tubePlayer.setPlayerStateChangeListener();
//                    tubePlayer.setPlaybackEventListener();
                    tubePlayer.loadVideo(ytArgs.getString(YOUTUBE_KEY));
                    tubePlayer.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });
    }
}
