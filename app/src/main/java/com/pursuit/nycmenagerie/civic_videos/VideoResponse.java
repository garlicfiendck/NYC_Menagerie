package com.pursuit.nycmenagerie.civic_videos;

public class VideoResponse {
    private String title;
    private String imageFile;
    private String videoUrl;


    public VideoResponse(String title, String imageFile, String videoUrl){
        this.title = title;
        this.imageFile = imageFile;
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }
    public String getImageFile(){
        return imageFile;
    }
    public String getVideoUrl() {
        return videoUrl;
    }
}
