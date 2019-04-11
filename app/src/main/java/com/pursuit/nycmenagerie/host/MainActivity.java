package com.pursuit.nycmenagerie.host;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.pursuit.nycmenagerie.nav_drawer.CreatorFragment;
import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;
import com.pursuit.nycmenagerie.civic_quotes.QuoteFragment;
import com.pursuit.nycmenagerie.civic_videos.VideoFragment;
import com.pursuit.nycmenagerie.civic_videos.VideoResponse;
import com.pursuit.nycmenagerie.nav_drawer.PollingLocationFragment;
import com.pursuit.nycmenagerie.nav_drawer.PollworkerFragment;
import com.pursuit.nycmenagerie.nav_drawer.UpcomingElectionFragment;
import com.pursuit.nycmenagerie.nav_drawer.VoterStatusFragment;
import com.pursuit.nycmenagerie.youtube.YoutubeFragment;

public class MainActivity extends AppCompatActivity implements OnFragmentInteraction, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        onHeaderClick(navigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_main, new UpcomingElectionFragment())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_upcoming_elections);
        }

        inflateQuoteFragment();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_upcoming_elections:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new UpcomingElectionFragment())
                        .commit();
                break;
            case R.id.nav_voter_status:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new VoterStatusFragment())
                        .commit();
                break;
            case R.id.nav_polling_location:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new PollingLocationFragment())
                        .commit();
                break;
            case R.id.nav_pollworker:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new PollworkerFragment())
                        .commit();
                break;

            case R.id.about_me:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new CreatorFragment())
                        .commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void openLinkedin(String website) {
        Uri linkedinUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, linkedinUri);
        startActivity(intent);
    }

    @Override
    public void openGithubRepo(String website) {
        Uri githubUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, githubUri);
        startActivity(intent);
    }

    @Override
    public void openNYCBOEPollsiteLocator(String website) {
        Uri pollsiteLocatorUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, pollsiteLocatorUri);
        startActivity(intent);
    }

    @Override
    public void openPWApplyOnline(String website) {
        Uri pollworkerUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, pollworkerUri);
        startActivity(intent);
    }

    @Override
    public void openPWMoreInfo(String website) {
        Uri pwMoreInforUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, pwMoreInforUri);
        startActivity(intent);
    }

    @Override
    public void openChkReg(String website) {
        Uri chkRegUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, chkRegUri);
        startActivity(intent);
    }

    @Override
    public void callBOEHotline(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void regVoteDLApp(String website) {
        Uri regVoteDLAppUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, regVoteDLAppUri);
        startActivity(intent);
    }

    @Override
    public void regVoteOnline(String website) {
        Uri regVoteOnlineUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, regVoteOnlineUri);
        startActivity(intent);
    }

    @Override
    public void regVoteInPerson(String website) {
        Uri regVoteInPersonUri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, regVoteInPersonUri);
        startActivity(intent);
    }

    private void inflateQuoteFragment() {
        QuoteFragment quoteFragment = QuoteFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, quoteFragment)
                .addToBackStack(null)
                .commit();
    }

    private void onHeaderClick(NavigationView navigationView) {
        View headerView = navigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateQuoteFragment();
            }
        });
    }
}
