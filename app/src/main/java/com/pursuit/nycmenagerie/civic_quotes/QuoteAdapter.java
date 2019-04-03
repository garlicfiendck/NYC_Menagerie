package com.pursuit.nycmenagerie.civic_quotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.nycmenagerie.R;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteViewHolder> {

    private List<QuoteResponse> quoteList;
    private OnQuoteFragmentInteraction listener;

    public QuoteAdapter(List<QuoteResponse> quoteList, OnQuoteFragmentInteraction listener){
        this.quoteList = quoteList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_quote, viewGroup, false);
        return new QuoteViewHolder(childView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder quoteViewHolder, int i) {
        quoteViewHolder.onBind(quoteList.get(i));
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }
}
