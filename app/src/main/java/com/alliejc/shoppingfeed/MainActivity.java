package com.alliejc.shoppingfeed;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.alliejc.shoppingfeed.articles.Article;
import com.alliejc.shoppingfeed.articles.Datum;
import com.alliejc.shoppingfeed.fragment.ArticlesFragment;
import com.alliejc.shoppingfeed.fragment.SavedSearchFragment;
import com.alliejc.shoppingfeed.grailed.GrailedService;
import com.alliejc.shoppingfeed.savedsearch.SavedSearch;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private GrailedService mGrailedService;
    private List<Datum> mArticleDatumList;
    private Toolbar mToolbar;
    private List<com.alliejc.shoppingfeed.savedsearch.Datum> mSavedSearchDatumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGrailedService = GrailedService.getGrailedService();
        mArticleDatumList = new ArrayList<>();
        mSavedSearchDatumList = new ArrayList<>();
        setUpToolbar();

        setUpTabs();
        getTabData(mTabLayout.getSelectedTabPosition());
    }

    private void setUpToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.logo_grailed));
            bar.setDisplayHomeAsUpEnabled(false);
            bar.setDisplayShowTitleEnabled(false);
            bar.setElevation(2);
        }
    }

    private void setUpTabs(){
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getTabData(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                getTabData(tab.getPosition());
            }
        });
    }

    private void getTabData(int tabPosition){
        switch (tabPosition){
            case 0:
                getArticles();
                break;
            case 1:
                getSavedSearches();
                break;
        }
    }

    private void startArticlesFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        ArticlesFragment articlesFragment = ArticlesFragment.getInstance(mArticleDatumList);
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_framelayout, articlesFragment)
                .commit();
    }

    private void startSavedFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        SavedSearchFragment searchFragment = SavedSearchFragment.getInstance(mSavedSearchDatumList);
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_framelayout, searchFragment)
                .commit();
    }

    private void getArticles(){
        Call call = mGrailedService.getArticles();
        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(@NonNull Call<Article> call, @NonNull Response<Article> response) {
                if (response.isSuccessful()) {
                    mArticleDatumList.addAll(response.body().getData());
                    startArticlesFragment();
                } else {
                    Toast.makeText(MainActivity.this, "Error on response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                Log.e("on failure", call.toString() + "--" + t.toString() + "--"+ t.getMessage());
            }
        });
    }

    private void getSavedSearches(){
        Call call = mGrailedService.getSavedSearches();
        call.enqueue(new Callback<SavedSearch>() {
            @Override
            public void onResponse(Call<SavedSearch> call, Response<SavedSearch> response) {
                if (response.isSuccessful()) {
                    mSavedSearchDatumList.addAll(response.body().getData());
                    startSavedFragment();

                    } else {
                    Toast.makeText(MainActivity.this, "Error on response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("on failure", call.toString() + "--" + t.toString() + "--"+ t.getMessage());
            }
        });
    }
}
