package com.alliejc.shoppingfeed.fragment;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alliejc.shoppingfeed.adapter.ArticleFeedAdapter;
import com.alliejc.shoppingfeed.R;
import com.alliejc.shoppingfeed.articles.Article;
import com.alliejc.shoppingfeed.articles.Datum;
import com.alliejc.shoppingfeed.grailed.GrailedService;
import com.alliejc.shoppingfeed.util.EndlessScrollListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO: handle pagination
public class ArticlesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArticleFeedAdapter mAdapter;
    private List<Datum> mDatumList;
    private EndlessScrollListener scrollListener;
    private GrailedService mGrailedService;

    public ArticlesFragment() {
    }

    public static ArticlesFragment getInstance(List<Datum> datumList){
        ArticlesFragment articlesFragment = new ArticlesFragment();
        articlesFragment.mDatumList = datumList;
        return articlesFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        mRecyclerView = view.findViewById(R.id.feed);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRecyclerView();
    }

    private void setRecyclerView() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new ArticleFeedAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.updateAdapter(mDatumList);

        scrollListener = new EndlessScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.e("page", String.valueOf(page));
                Log.e("totalItemsCount", String.valueOf(totalItemsCount));
                mGrailedService = GrailedService.getGrailedService();
                getArticles(page);
            }
        };

        mRecyclerView.addOnScrollListener(scrollListener);
    }

    private void getArticles(int page){
        Call call = mGrailedService.getArticlesNext(page);
        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(@NonNull Call<Article> call, @NonNull Response<Article> response) {
                if (response.isSuccessful()) {
                    mDatumList.addAll(response.body().getData());
                    mAdapter.updateAdapter(mDatumList);
                } else {
                    Toast.makeText(getContext(), "Error onresponse", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                Log.e("on failure", call.toString() + "--" + t.toString() + "--"+ t.getMessage());
                Toast.makeText(getContext(), "Error on Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
