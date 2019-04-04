package com.pursuit.nycmenagerie.webview_videos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.nycmenagerie.R;

public class VideoWebviewFragment extends Fragment {


    public VideoWebviewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video_webview, container, false);
    }

}
