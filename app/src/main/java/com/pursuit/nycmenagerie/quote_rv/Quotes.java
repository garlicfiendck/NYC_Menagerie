package com.pursuit.nycmenagerie.quote_rv;

import java.util.List;

public class Quotes {

    private List<QuoteResponse> civicQuotes;

    public Quotes(List<QuoteResponse> civicQuotes){
        this.civicQuotes = civicQuotes;
    }

    public List<QuoteResponse> getCivicQuotes() {
        return civicQuotes;
    }
}