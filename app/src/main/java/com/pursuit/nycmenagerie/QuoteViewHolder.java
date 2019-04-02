package com.pursuit.nycmenagerie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class QuoteViewHolder extends RecyclerView.ViewHolder {

    private TextView txt_quote;
    private TextView txt_author;
    private ImageView img_fingerprint;

    private OnQuoteFragmentInteraction listener;

    public QuoteViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_quote = itemView.findViewById(R.id.txt_quote);
        txt_author = itemView.findViewById(R.id.txt_author);
        img_fingerprint = itemView.findViewById(R.id.img_fingerprint);
    }

    public void onBind(QuoteResponse quoteResponse) {

        txt_quote.setText(quoteResponse.getQuote());
        txt_author.setText(quoteResponse.getAuthor());

        img_fingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.toVideoFragment();
                }
            }
        });

    }
}
