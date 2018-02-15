package com.awesomeapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.ReactNative.flip.FlipView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsFeedActivity extends AppCompatActivity {

    private static final String API_URL = "https://newsapi.org/v2/";

    protected FlipView flipView;
    Context context;
    ImageButton backButton;
    TextView textTitle;
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

        loadJSON();

        flipView = new FlipView(this);

        notifications();

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
            getSupportActionBar().setDisplayShowTitleEnabled(false); // disable the default title element here (for centered title)
        }

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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    void notifications(){

        RemoteViews expandedView = new RemoteViews(getPackageName(), R.layout.custom_push_exp);
        // RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.custom_push_col);

        expandedView.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
        expandedView.setTextViewText(R.id.title, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));
        expandedView.setTextViewText(R.id.text, "This is a custom layout");

        /*collapsedView.setImageViewResource(R.id.big_icon, R.drawable.arrow_left_black);
        collapsedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));*/


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContent(expandedView);

        Notification notification = mBuilder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notificationManager.notify(1, notification);

    }

    public void setStringFromRN( String jsonValue) {

        JSONResponse response = new Gson().fromJson(jsonValue, JSONResponse.class);

        newsAdapter.setStringFromRN(response.getArticles());
        newsAdapter.notifyDataSetChanged();
    }

    private void loadJSON() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getNews();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(@NonNull Call<JSONResponse> call, @NonNull Response<JSONResponse> response) {

                Log.d("TAG", " NEWS List " + (response.body().getArticles()));
                newsList.addAll((response.body().getArticles()));

                newsAdapter.setStringFromRN(newsList);
                newsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(@NonNull Call<JSONResponse> call, @NonNull Throwable t) {
                Log.d("TAG", " Error - " + t.getMessage());
            }
        });

    }

}