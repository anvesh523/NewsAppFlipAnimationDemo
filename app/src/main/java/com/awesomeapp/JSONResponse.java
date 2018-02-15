package com.awesomeapp;


import java.util.ArrayList;

public class JSONResponse {

    private ArrayList<NewsData> articles;
    private String status;
    private String totalResults;

    public ArrayList<NewsData> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsData> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "JSONResponse { " +
                "Articles= " + articles +
                ", status = " + status +
                ", totalResults = " + totalResults +
                " }";
    }
}
