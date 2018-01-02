package com.alliejc.shoppingfeed;

import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private static final String ARTICLE_FRAGMENT_TAG = "article_fragment_tag";
    private static final String SEARCH_FRAGMENT_TAG = "search_fragment_tag";

    private TabLayout mTabLayout;
    private GrailedService mGrailedService;
    private List<Datum> mArticleDatumList;
    private List<com.alliejc.shoppingfeed.savedsearch.Datum> mSavedSearchDatumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGrailedService = GrailedService.getGrailedService();
        mArticleDatumList = new ArrayList<>();
        mSavedSearchDatumList = new ArrayList<>();
        getArticles();
        getSavedSearches();
        setUpTabs();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(mTabLayout != null) {
            replaceFragment(mTabLayout.getSelectedTabPosition());
            Log.e("tab", String.valueOf(mTabLayout.getSelectedTabPosition()));
        }
    }

    private void setUpTabs(){
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                replaceFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                replaceFragment(tab.getPosition());
            }
        });
    }

    private void replaceFragment(int tabPosition){
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (tabPosition){
            case 0:
                ArticlesFragment articlesFragment = ArticlesFragment.getInstance(mArticleDatumList);
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.main_framelayout, articlesFragment)
                        .commit();
                break;
            case 1:
                SavedSearchFragment searchFragment = SavedSearchFragment.getInstance(mSavedSearchDatumList);
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.main_framelayout, searchFragment)
                        .commit();
                break;
        }
    }

    private void getArticles(){
        Call call = mGrailedService.getArticles();
        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(@NonNull Call<Article> call, @NonNull Response<Article> response) {
                if (response.isSuccessful()) {
                    mArticleDatumList.addAll(response.body().getData());
                } else {
                    Toast.makeText(MainActivity.this, "Error onresponse", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                Log.e("on failure", call.toString() + "--" + t.toString() + "--"+ t.getMessage());
                Toast.makeText(MainActivity.this, "Error on Failure", Toast.LENGTH_SHORT).show();

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
                    Log.e("on response", String.valueOf(mSavedSearchDatumList.size()));
                    } else {
                    Log.e("else", call.toString());
                    Toast.makeText(MainActivity.this, "Error onresponse", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("on failure", call.toString() + "--" + t.toString() + "--"+ t.getMessage());
                Toast.makeText(MainActivity.this, "Error on Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
