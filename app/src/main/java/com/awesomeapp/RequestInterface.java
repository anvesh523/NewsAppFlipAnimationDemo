package com.awesomeapp;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("top-headlines?category=health&country=us&apiKey=c4871b5de02f40a6b3d580183df70d05")
    Call<JSONResponse> getNews();

}
