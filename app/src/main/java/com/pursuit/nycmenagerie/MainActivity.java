package com.pursuit.nycmenagerie;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.pursuit.nycmenagerie.QuoteFragment.AUTHOR_KEY;
import static com.pursuit.nycmenagerie.QuoteFragment.QUOTE_KEY;

public class MainActivity extends AppCompatActivity implements OnQuoteFragmentInteraction {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intent = getIntent();

        InflateQuoteFragment();

    }

    private void InflateQuoteFragment() {
        QuoteFragment quoteFragment = QuoteFragment.newInstance(intent.getStringExtra(QUOTE_KEY), intent.getStringExtra(AUTHOR_KEY));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, quoteFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toVideoFragment() {
        VideoFragment videoFragment = VideoFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container_main, videoFragment)
                .addToBackStack(null)
                .commit();
    }
}
