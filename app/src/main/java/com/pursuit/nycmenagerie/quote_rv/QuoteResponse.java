package com.pursuit.nycmenagerie.quote_rv;

public class QuoteResponse {

    private String quote;
    private String author;

    public QuoteResponse(String quote, String author){
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

}
