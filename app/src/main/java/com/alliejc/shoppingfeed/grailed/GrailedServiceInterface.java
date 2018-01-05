package com.alliejc.shoppingfeed.grailed;

import com.alliejc.shoppingfeed.articles.Article;
import com.alliejc.shoppingfeed.articles.Datum;
import com.alliejc.shoppingfeed.articles.Metadata;
import com.alliejc.shoppingfeed.savedsearch.SavedSearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface GrailedServiceInterface {

    @GET("articles/ios_index")
    Call<Article> articleList();

    @GET("articles/ios_index")
    Call<Article> articlesNextPage(@Query("page") int page);

    @GET("merchandise/marquee")
    Call<SavedSearch> savedSearchList();
}
