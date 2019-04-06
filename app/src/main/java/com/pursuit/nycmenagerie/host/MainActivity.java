package com.pursuit.nycmenagerie.host;

import android.content.res.Configuration;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;
import com.pursuit.nycmenagerie.civic_quotes.QuoteFragment;
import com.pursuit.nycmenagerie.civic_videos.VideoFragment;
import com.pursuit.nycmenagerie.civic_videos.VideoResponse;
import com.pursuit.nycmenagerie.youtube.YoutubeFragment;

public class MainActivity extends  AppCompatActivity implements OnFragmentInteraction {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        inflateQuoteFragment();

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
