package com.awesomeapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ReactNative.utils.AphidLog;
import com.ReactNative.utils.UI;
// import com.squareup.picasso.Picasso;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Arrays;

public class NewsAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private int repeatCount = 1;

    private ArrayList<NewsData> newsList;

    public NewsAdapter(Context context, ArrayList<NewsData> newsList) {
        this.context = context;
        this.newsList = newsList;
        inflater = LayoutInflater.from(context);
        AphidLog.d("TAG size: %d", newsList.size());
    }

    @Override
    public int getCount() {

        return newsList.size() * repeatCount;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        if (convertView == null) {
            layout = inflater.inflate(R.layout.news_adapter, null);
            AphidLog.d("TAG position: %d", position);
        }

        final NewsData data = newsList.get(position % newsList.size());

        UI.<Toolbar>findViewById(layout, R.id.my_toolbar);
        Toolbar toolBar = layout.findViewById(R.id.my_toolbar);

        ImageButton imageButton = toolBar.findViewById(R.id.cus_back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).finish();
            }
        });

        TextView textView = toolBar.findViewById(R.id.cus_title);
        textView.setText("News Feed");

        UI
                .<TextView>findViewById(layout, R.id.title)
                .setText(AphidLog.format("%d. %s", (position + 1), data.getTitle() == null ? "  " : data.getTitle()));

        UI
                .<ImageView>findViewById(layout, R.id.photo);

        ImageView imageView = layout.findViewById(R.id.photo);
        Ion.with(context)
                .load(data.getUrlToImage())
                .withBitmap()
                .intoImageView(imageView);
        // Picasso.with(context).load(data.getUrlToImage()).into(imageView);


        UI
                .<TextView>findViewById(layout, R.id.description)
                .setText(data.getDescription() == null ? "  " : data.getDescription());

        UI
                .<Button>findViewById(layout, R.id.wikipedia)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, WebActivity.class);
                        intent.putExtra("web", data.getUrl());
                        inflater.getContext().startActivity(intent);
                    }
                });


        return layout;
    }


    public void setNewsData(NewsData[] data) {

        newsList.addAll(Arrays.asList(data));
        notifyDataSetChanged();
    }

    public void resetWithNewsData(NewsData[] data) {

        newsList = new ArrayList<>();
        newsList.addAll(Arrays.asList(data));

        notifyDataSetChanged();
    }

    public void removeData(int index) {
        if (newsList.size() > 1) {
            newsList.remove(index);
        }
    }
}
