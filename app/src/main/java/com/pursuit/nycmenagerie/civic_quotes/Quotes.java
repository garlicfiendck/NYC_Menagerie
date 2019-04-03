package com.pursuit.nycmenagerie.civic_quotes;

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