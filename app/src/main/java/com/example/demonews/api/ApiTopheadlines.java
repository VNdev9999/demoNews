package com.example.demonews.api;

import com.example.demonews.model.Article;
import com.example.demonews.model.TopHeadlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiTopheadlines {

    @GET("v2/top-headlines")
    Call<TopHeadlines> callArticle(@Query("country")String country,
                                   @Query("apiKey")String apiKey);
}
