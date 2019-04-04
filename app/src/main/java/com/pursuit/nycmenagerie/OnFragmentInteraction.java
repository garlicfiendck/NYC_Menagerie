package com.pursuit.nycmenagerie;

import com.pursuit.nycmenagerie.civic_videos.VideoResponse;

public interface OnFragmentInteraction {

    void toVideoFragment(VideoResponse videoResponse);
    void viewVideoViaWebView();
}
