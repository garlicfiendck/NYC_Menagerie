package com.pursuit.nycmenagerie;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pursuit.nycmenagerie.quote_rv.OnQuoteFragmentInteraction;
import com.pursuit.nycmenagerie.quote_rv.QuoteFragment;

import static com.pursuit.nycmenagerie.quote_rv.QuoteFragment.AUTHOR_KEY;
import static com.pursuit.nycmenagerie.quote_rv.QuoteFragment.QUOTE_KEY;

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
