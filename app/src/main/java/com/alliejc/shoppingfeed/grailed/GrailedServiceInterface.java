package com.alliejc.shoppingfeed.grailed;

import com.alliejc.shoppingfeed.articles.Article;
import com.alliejc.shoppingfeed.articles.Datum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GrailedServiceInterface {

    @GET("articles/ios_index")
    Call<Datum> articleList();

    @GET("articles/ios_index")
    Call<List<Article>> articlesNextPage(@Query("page") int page);
}