package com.pursuit.nycmenagerie.host;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;
import com.pursuit.nycmenagerie.civic_quotes.QuoteFragment;
import com.pursuit.nycmenagerie.civic_videos.VideoFragment;
import com.pursuit.nycmenagerie.civic_videos.VideoResponse;
import com.pursuit.nycmenagerie.youtube.YoutubeFragment;

public class MainActivity extends AppCompatActivity implements OnFragmentInteraction {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inflateQuoteFragment();
//        toVideoFragment(videoResponse);

    }
    private void inflateQuoteFragment() {
        QuoteFragment quoteFragment = QuoteFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, quoteFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toVideoFragment(VideoResponse videoResponse) {
        VideoFragment videoFragment = VideoFragment.newInstance(videoResponse.getTitle(), videoResponse.getImageFile(), videoResponse.getVideoUrl());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, videoFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toYoutubeFragment(String videoID) {
        YoutubeFragment youtubeFragment = YoutubeFragment.newInstance(videoID);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, youtubeFragment)
                .addToBackStack(null)
                .commit();
    }

}
