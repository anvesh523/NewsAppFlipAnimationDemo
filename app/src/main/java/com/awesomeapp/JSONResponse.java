package com.awesomeapp;


public class JSONResponse {

    private NewsData[] articles;
    private String status;
    private String totalResults;

    public NewsData[] getArticles() {
        return articles;
    }

    public void setArticles(NewsData[] articles) {
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
                ", status = " + status +
                ", totalResults = " + totalResults +
                "Articles= " + articles +
                " }";
    }
}
