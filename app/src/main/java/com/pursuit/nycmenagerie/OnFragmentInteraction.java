package com.pursuit.nycmenagerie;

import com.pursuit.nycmenagerie.civic_videos.VideoResponse;

public interface OnFragmentInteraction {

    void toVideoFragment(VideoResponse videoResponse);
    void toYoutubeFragment(String videoID);
    void openLinkedin(String website);
    void openGithubRepo(String website);
    void openNYCBOEPollsiteLocator(String website);
    void openPWApplyOnline(String website);
    void openPWMoreInfo(String website);
}
