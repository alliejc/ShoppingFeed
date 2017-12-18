package com.alliejc.shoppingfeed;

import com.alliejc.shoppingfeed.articles.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by acaldwell on 12/17/17.
 */

public interface GrailedServiceInterface {

//    //the logged in user information
//    @GET("v1/me")
//    Observable<SpotifyUser> getCurrentUser(@Header("Authorization") String bearerToken);
//
//    //logged in users saved tracks
//    @GET("v1/me/tracks")
//    Observable<UserTracks> getUserTracks(@Header("Authorization") String bearerToken, @Query("offset") int offset, @Query("limit") int limit);

    @GET("articles/ios_index")
    Call<List<Article>> articleList();

    @GET("articles/ios_index")
    Call<List<Article>> articlesNextPage(@Query("page") int page);

}
