package com.alliejc.shoppingfeed;

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
    private Article mArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGrailedService = GrailedService.getGrailedService();
        getArticles();
        setUpTabs();
    }

    private void setUpTabs(){
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                if (tab.getPosition() == 0) {
                    ArticlesFragment articlesFragment = ArticlesFragment.getInstance(mArticle);
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.main_framelayout, articlesFragment)
                            .addToBackStack(ARTICLE_FRAGMENT_TAG)
                            .commit();

                } else if (tab.getPosition() == 1) {
                    SavedSearchFragment searchFragment = SavedSearchFragment.getInstance();
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.main_framelayout, searchFragment)
                            .addToBackStack(SEARCH_FRAGMENT_TAG)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
//        if (getFragmentManager().getBackStackEntryCount() > 0) {
//            getFragmentManager().popBackStackImmediate();
//        }
    }

    private void getArticles(){
//        mArticleList = new ArrayList<>();
        Call call = mGrailedService.getArticles();

        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(@NonNull Call<Article> call, @NonNull Response<Article> response) {
                if (response.isSuccessful()) {
                    Log.e("successful", response.toString());
                    mArticle.setData(response.body().getData());
                    mArticle.setMetadata(response.body().getMetadata());

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
}
