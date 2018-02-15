package com.awesomeapp;


import java.util.List;

public class JSONResponse {

    private List<NewsData> articles;
    private String status;
    private String totalResults;

    public List<NewsData> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsData> articles) {
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
