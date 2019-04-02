package com.pursuit.nycmenagerie;

import com.pursuit.nycmenagerie.quote_rv.Quotes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String ENDPOINT = "garlicfiendck/NYC_Menagerie/master/civicQuotes";

    @GET(ENDPOINT)
    Call<Quotes> getQuotes();

}
