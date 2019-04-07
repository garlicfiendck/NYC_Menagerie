package com.pursuit.nycmenagerie.civic_quotes;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.nycmenagerie.network.ApiClient;
import com.pursuit.nycmenagerie.network.ApiService;
import com.pursuit.nycmenagerie.OnFragmentInteraction;
import com.pursuit.nycmenagerie.R;
import com.pursuit.nycmenagerie.civic_videos.VideoResponse;
import com.pursuit.nycmenagerie.civic_videos.Videos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteFragment extends Fragment {

//    public static final String QUOTE_KEY = "Quote";
//    public static final String AUTHOR_KEY = "Author";
    private static final String QUOTE_TAG = "Quote Tag";
    private static final String VIDEO_TAG = "Video Tag";
//    private static final String IMAGE_TAG = "Image Tag";

//    private String quote;
//    private String author;

    private RecyclerView recyclerView;
    private QuoteAdapter adapter;
//    private static long currentVisiblePosition;

    private List<QuoteResponse> quoteList = new ArrayList<>();
    private List<VideoResponse> videoList = new ArrayList<>();

    private OnFragmentInteraction listener;

    public static QuoteFragment newInstance() {
        QuoteFragment quoteFragment = new QuoteFragment();
//        Bundle quoteArgs = new Bundle();
//        quoteArgs.putString(QUOTE_KEY, quote);
//        quoteArgs.putString(AUTHOR_KEY, author);
//        quoteFragment.setArguments(quoteArgs);
        return quoteFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteraction) {
            listener = (OnFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            quote = getArguments().getString(QUOTE_KEY);
//            author = getArguments().getString(AUTHOR_KEY);
//        }
        quoteCallback();
        videoCallback();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quote, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview_quote);
        adapter = new QuoteAdapter(quoteList, videoList, listener);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        } else {
//            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        }

    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        currentVisiblePosition = 0;
//        currentVisiblePosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        recyclerView.getLayoutManager().scrollToPosition((int) currentVisiblePosition);
//        currentVisiblePosition = 0;
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void quoteCallback() {
        ApiClient.getInstance()
                .create(ApiService.class)
                .getQuotes()
                .enqueue(new Callback<Quotes>() {
            @Override
            public void onResponse(Call<Quotes> call, Response<Quotes> response) {
                Log.d(QUOTE_TAG, "onResponse: " + response.body());
                quoteList.addAll(response.body().getCivicQuotes());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Quotes> call, Throwable t) {
                Log.e(QUOTE_TAG, "onFailure: " + t.toString());

            }
        });
    }

    private void videoCallback() {
        ApiClient.getInstance()
                .create(ApiService.class)
                .getVideos()
                .enqueue(new Callback<Videos>() {
                    @Override
                    public void onResponse(Call<Videos> call, Response<Videos> response) {
                        Log.d(VIDEO_TAG, "onResponse: " + response.body().toString());
                        videoList.addAll(response.body().getVideos());
                        Log.d(VIDEO_TAG, "videos added to list");
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Videos> call, Throwable t) {
                        Log.e(VIDEO_TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

}
