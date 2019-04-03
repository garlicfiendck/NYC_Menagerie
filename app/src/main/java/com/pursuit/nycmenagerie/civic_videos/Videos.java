package com.pursuit.nycmenagerie.civic_videos;

import java.util.List;

public class Videos {

    private List<VideoResponse> videos;

    public Videos(List<VideoResponse> videos){
        this.videos = videos;
    }

    public List<VideoResponse> getVideos() {
        return videos;
    }
}
