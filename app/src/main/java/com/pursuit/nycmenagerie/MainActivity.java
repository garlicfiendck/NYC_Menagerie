package com.pursuit.nycmenagerie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pursuit.nycmenagerie.civic_quotes.OnQuoteFragmentInteraction;
import com.pursuit.nycmenagerie.civic_quotes.QuoteFragment;
import com.pursuit.nycmenagerie.civic_videos.VideoFragment;

import static com.pursuit.nycmenagerie.civic_quotes.QuoteFragment.AUTHOR_KEY;
import static com.pursuit.nycmenagerie.civic_quotes.QuoteFragment.QUOTE_KEY;

public class MainActivity extends AppCompatActivity implements OnQuoteFragmentInteraction {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intent = getIntent();

        inflateQuoteFragment();

    }

    @Override
    public void toVideoFragment() {
        VideoFragment videoFragment = VideoFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, videoFragment)
                .addToBackStack(null)
                .commit();
    }
    private void inflateQuoteFragment() {
        QuoteFragment quoteFragment = QuoteFragment.newInstance(intent.getStringExtra(QUOTE_KEY), intent.getStringExtra(AUTHOR_KEY));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, quoteFragment)
                .addToBackStack(null)
                .commit();
    }
}
