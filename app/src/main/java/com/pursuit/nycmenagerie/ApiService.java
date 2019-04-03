package com.pursuit.nycmenagerie;

import com.pursuit.nycmenagerie.civic_quotes.Quotes;
import com.pursuit.nycmenagerie.civic_videos.Videos;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String QUOTE_ENDPOINT = "garlicfiendck/NYC_Menagerie/master/civicQuotes";
    String VIDEO_ENDPOINT = "garlicfiendck/NYC_Menagerie/master/civicVideos";

    @GET(QUOTE_ENDPOINT)
    Call<Quotes> getQuotes();

    @GET(VIDEO_ENDPOINT)
    Call<Videos> getVideos();

}
