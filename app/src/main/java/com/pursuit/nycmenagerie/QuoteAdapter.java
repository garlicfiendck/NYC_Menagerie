package com.pursuit.nycmenagerie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteViewHolder> {

    private List<QuoteResponse> quoteList;

    public QuoteAdapter(List<QuoteResponse> quoteList){
        this.quoteList = quoteList;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_quote, viewGroup, false);
        return new QuoteViewHolder(childView);
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
