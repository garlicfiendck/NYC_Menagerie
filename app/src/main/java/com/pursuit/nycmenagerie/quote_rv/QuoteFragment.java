package com.pursuit.nycmenagerie.quote_rv;


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

import com.pursuit.nycmenagerie.ApiClient;
import com.pursuit.nycmenagerie.ApiService;
import com.pursuit.nycmenagerie.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class QuoteFragment extends Fragment {

    public static final String QUOTE_KEY = "quote";
    public static final String AUTHOR_KEY = "author";

    private String quote;
    private String author;

    private RecyclerView recyclerView;
    private QuoteAdapter adapter;
    private List<QuoteResponse> quoteList = new ArrayList<>();

    private OnQuoteFragmentInteraction listener;

    public static QuoteFragment newInstance(String quote, String author){
        QuoteFragment quoteFragment = new QuoteFragment();
        Bundle args = new Bundle();
        args.putString(QUOTE_KEY, quote);
        args.putString(AUTHOR_KEY, author);
        quoteFragment.setArguments(args);
        return quoteFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnQuoteFragmentInteraction){
            listener = (OnQuoteFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnQuoteFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            quote = getArguments().getString(QUOTE_KEY);
            author = getArguments().getString(AUTHOR_KEY);
        }
        quoteRetrofitCallback();
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
        adapter = new QuoteAdapter(quoteList, listener);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void quoteRetrofitCallback() {
        ApiClient.getInstance().create(ApiService.class).getQuotes().enqueue(new Callback<Quotes>() {
            @Override
            public void onResponse(Call<Quotes> call, Response<Quotes> response) {
                Log.d(TAG, "onResponse: " + response.body());
                quoteList.addAll(response.body().getCivicQuotes());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Quotes> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());

            }
        });
    }
}
