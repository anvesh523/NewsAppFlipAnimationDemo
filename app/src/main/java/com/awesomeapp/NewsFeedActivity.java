package com.awesomeapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ReactNative.flip.FlipView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class NewsFeedActivity extends Activity {

    protected FlipView flipView;
    NewsAdapter newsAdapter;
    private String strJson;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = NewsFeedActivity.this;

        ArrayList<NewsData> newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(context, newsList);


        flipView = new FlipView(this);

        flipView.setAdapter(newsAdapter);
        setContentView(flipView);

        // String jsonString = getIntent().getStringExtra("news");
        // setStringFromRN(jsonString);

        strJson = "[{\"author\":\"Jessica Hamzelou\",\"title\":\"How you speak predicts if psychedelic therapy will help you\",\"description\":\"Psilocybin, a compound in magic mushrooms, may help treat depression in some people. Now speech analysis can indicate who would benefit the most\",\"url\":\"https://www.newscientist.com/article/2161725-how-you-speak-predicts-if-psychedelic-therapy-will-help-you/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/20174932/gettyimages-843363868.jpg\",\"publishedAt\":\"2018-02-20T00:00:00Z\"},{\"author\":\"Richard Kemeny\",\"title\":\"Why big pharma might pay cryptocurrency for your DNA\",\"description\":\"More people are getting their genome sequenced than ever before, so start-ups are offering to help people make money from their genomic data\",\"url\":\"https://www.newscientist.com/article/2161707-why-big-pharma-might-pay-cryptocurrency-for-your-dna/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/20171059/en8wnm-1.jpg\",\"publishedAt\":\"2018-02-20T00:00:00Z\"},{\"author\":\"Debora MacKenzie\",\"title\":\"Flu is evolving in new and unpredictable ways in China’s poultry\",\"description\":\"A woman in China has been infected by a new type of flu. With thousands of people travelling after Chinese new year, the risk of new strains spreading is high\",\"url\":\"https://www.newscientist.com/article/2161541-flu-is-evolving-in-new-and-unpredictable-ways-in-chinas-poultry/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/19120034/gettyimages-630667210.jpg\",\"publishedAt\":\"2018-02-19T00:00:00Z\"},{\"author\":null,\"title\":\"Bunnies draped in fake polar bear fur are both cosy and stealthy\",\"description\":\"A warm fabric made of freeze-dried liquid silk mimics polar bear fur, making rabbits invisible to infrared cameras. It could do the same for humans\",\"url\":\"https://www.newscientist.com/article/2161703-bunnies-draped-in-fake-polar-bear-fur-are-both-cosy-and-stealthy/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/20164251/1-optical-image-1.jpg\",\"publishedAt\":\"2018-02-20T00:00:00Z\"},{\"author\":\"Edd Gent\",\"title\":\"Electronic skin animates heartbeat on the back of your hand\",\"description\":\"A flexible e-skin containing a few hundred micro LEDs can display your vital signs or messages from your doctor\",\"url\":\"https://www.newscientist.com/article/2161447-electronic-skin-animates-heartbeat-on-the-back-of-your-hand/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/16160557/unknown-2.jpg\",\"publishedAt\":\"2018-02-17T00:00:00Z\"},{\"author\":\"Andy Coghlan\",\"title\":\"Cyclone Gita hits New Zealand after hammering Tonga\",\"description\":\"New Zealand has declared a state of emergency as Cyclone Gita struck the city of Christchurch, just days after causing devastation on the island nation of Tonga\",\"url\":\"https://www.newscientist.com/article/2161700-cyclone-gita-hits-new-zealand-after-hammering-tonga/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/20150436/7-nasaseestrop.jpg\",\"publishedAt\":\"2018-02-20T00:00:00Z\"},{\"author\":\"Sarah Derouin\",\"title\":\"Mystery honeycombs in rock may be created by water and salt\",\"description\":\"Many rocks are covered with circular hollows that look like honeycomb, and now we may finally understand how these strange formations come into existence\",\"url\":\"https://www.newscientist.com/article/2161693-mystery-honeycombs-in-rock-may-be-created-by-water-and-salt/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/20144516/cr_4.jpg\",\"publishedAt\":\"2018-02-20T00:00:00Z\"},{\"author\":\"Paul Marks\",\"title\":\"Technology firms must develop new ways to jam Russia’s fake news\",\"description\":\"The FBI has revealed the lengths Russia's fake news operators will go to – now the likes of Facebook and Twitter must come up with a fix, says Paul Marks\",\"url\":\"https://www.newscientist.com/article/2161674-technology-firms-must-develop-new-ways-to-jam-russias-fake-news/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/20140031/ke7xa6.jpg\",\"publishedAt\":\"2018-02-20T00:00:00Z\"},{\"author\":\"Jennifer Ouellette\",\"title\":\"Quantum computer could have predicted Trump’s surprise election\",\"description\":\"Quantum computers can improve election forecasts by taking into account how states affect one another, allowing one to predict Trump's slim 2016 election win\",\"url\":\"https://www.newscientist.com/article/2161464-quantum-computer-could-have-predicted-trumps-surprise-election/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/16172904/gettyimages-621813866.jpg\",\"publishedAt\":\"2018-02-16T00:00:00Z\"},{\"author\":\"Leah Crane\",\"title\":\"Three photons stick together to create a new form of light\",\"description\":\"Photons don’t normally make friends, but now three have been bound together into a brand-new form of light by tricking them into acting like atoms\",\"url\":\"https://www.newscientist.com/article/2161358-three-photons-stick-together-to-create-a-new-form-of-light/\",\"urlToImage\":\"https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/02/15155521/gettyimages-545799439.jpg\",\"publishedAt\":\"2018-02-15T00:00:00Z\"}]";
        setStringFromRN(strJson);

        flipView.setOnViewFlipListener(new FlipView.ViewFlipListener() {
            @Override
            public void onViewFlipped(View view, int position) {
                if ((newsAdapter.getCount() - 3) == position)
                    getMoreCallBack();
            }
        });
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

        NewsData[] response = new Gson().fromJson(jsonValue, NewsData[].class);

        int position = flipView.getSelectedItemPosition();

        newsAdapter.setNewsData(response);
        newsAdapter.notifyDataSetChanged();

        if (position > 0)
            flipView.setSelection(position);

    }

    public void resetData(String jsonValue) {

        NewsData[] response = new Gson().fromJson(jsonValue, NewsData[].class);

        newsAdapter.resetWithNewsData(response);
        newsAdapter.notifyDataSetChanged();

    }

    public void getMoreCallBack() {
        Log.d("TAG", " getMoreCallBack() call :) ");
        setStringFromRN(strJson);
    }

}