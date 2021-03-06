package com.pursuit.nycmenagerie.civic_quotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;
import com.pursuit.nycmenagerie.civic_videos.VideoResponse;


public class QuoteViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG_FINGERPRINT = "Fingerprint";

    private TextView txt_quote;
    private TextView txt_author;
    private ImageView img_fingerprint;

    private OnFragmentInteraction listener;

    public QuoteViewHolder(@NonNull View itemView, OnFragmentInteraction listener) {
        super(itemView);
        this.listener = listener;
        txt_quote = itemView.findViewById(R.id.txt_quote);
        txt_author = itemView.findViewById(R.id.txt_author);
        img_fingerprint = itemView.findViewById(R.id.img_fingerprint);
    }

    public void onBind(QuoteResponse quoteResponse, final VideoResponse videoResponse) {

        txt_quote.setText(quoteResponse.getQuote());
        txt_author.setText(quoteResponse.getAuthor());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG_FINGERPRINT, "onClick: " + listener);
                if (listener != null) {
                    listener.toVideoFragment(videoResponse);
                }
            }
        });
    }

    public void onQuoteBind(QuoteResponse quoteResponse) {

        txt_quote.setText(quoteResponse.getQuote());
        txt_author.setText(quoteResponse.getAuthor());
    }
}
