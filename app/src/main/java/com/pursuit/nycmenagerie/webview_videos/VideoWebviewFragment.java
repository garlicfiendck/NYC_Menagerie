package com.pursuit.nycmenagerie.webview_videos;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.pursuit.nycmenagerie.R;

public class VideoWebviewFragment extends Fragment {

    private WebView webView;

    public static final String YOUTUBE_KEY = "Youtube Key";

    public VideoWebviewFragment() {}

    public static VideoWebviewFragment newInstance(String videoUrl){
        VideoWebviewFragment videoWebviewFragment = new VideoWebviewFragment();
        Bundle urlArgs = new Bundle();
        urlArgs.putString(YOUTUBE_KEY, videoUrl);
        videoWebviewFragment.setArguments(urlArgs);
        return videoWebviewFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video_webview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView = view.findViewById(R.id.webv_video);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
