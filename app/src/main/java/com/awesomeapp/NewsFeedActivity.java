package com.awesomeapp;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

import com.ReactNative.flip.FlipView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class NewsFeedActivity extends Activity {

    protected FlipView flipView;
    Context context;
    private ArrayList<NewsData> newsList;
    NotificationManager notificationManager;

    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = NewsFeedActivity.this;

        newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(context, newsList);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        flipView = new FlipView(this);

        flipView.setAdapter(newsAdapter);
        setContentView(flipView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        flipView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        flipView.onPause();
    }
    
    public void setStringFromRN(String jsonValue) {

        JSONResponse response = new Gson().fromJson(jsonValue, JSONResponse.class);

        newsAdapter.setNewsData(response.getArticles());
        newsAdapter.notifyDataSetChanged();
    }

}