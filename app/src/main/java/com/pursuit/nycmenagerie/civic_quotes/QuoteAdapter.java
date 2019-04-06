package com.pursuit.nycmenagerie.civic_quotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;
import com.pursuit.nycmenagerie.civic_videos.VideoResponse;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteViewHolder> {

    private static final String ADAPTER_TAG = "Adapter Tag";

    private List<QuoteResponse> quoteList;
    private List<VideoResponse> videoList;

    private OnFragmentInteraction listener;

    public QuoteAdapter(List<QuoteResponse> quoteList, List<VideoResponse> videoList, OnFragmentInteraction listener){
        this.quoteList = quoteList;
        this.videoList = videoList;
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
        if(!videoList.isEmpty()){
            quoteViewHolder.onBind(quoteList.get(i), videoList.get(i));
            Log.d(ADAPTER_TAG, "onBindViewHolder: getting two lists");
        } else {
            quoteViewHolder.onQuoteBind(quoteList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return quoteList.size();

    }
}
