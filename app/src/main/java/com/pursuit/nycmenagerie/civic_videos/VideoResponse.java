package com.pursuit.nycmenagerie.civic_videos;

public class VideoResponse {
    private String title;
    private String videoUrl;

    public VideoResponse(String title, String videoUrl){
        this.title = title;
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
