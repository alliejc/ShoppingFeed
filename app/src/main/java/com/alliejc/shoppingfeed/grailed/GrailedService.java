package com.alliejc.shoppingfeed.grailed;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class GrailedService {

    private static GrailedService mGrailedService;
    private final GrailedServiceInterface mGrailedServiceInterface;

    public static GrailedService getGrailedService() {
        if (mGrailedService != null){
            return mGrailedService;
        } else {
            mGrailedService = new GrailedService();
            return mGrailedService;
        }
    }

    public GrailedService(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.grailed.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mGrailedServiceInterface = retrofit.create(GrailedServiceInterface.class);
    }

    public Call getArticles(){
        return mGrailedServiceInterface.articleList();
    }

    public Call getArticlesNext(int currPage){
            return mGrailedServiceInterface.articlesNextPage(currPage);
    }

    public Call getSavedSearches() {
        return mGrailedServiceInterface.savedSearchList();
    }
}
