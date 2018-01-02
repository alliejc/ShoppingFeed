package com.alliejc.shoppingfeed.fragment;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alliejc.shoppingfeed.adapter.ArticleFeedAdapter;
import com.alliejc.shoppingfeed.R;
import com.alliejc.shoppingfeed.articles.Datum;

import java.util.ArrayList;
import java.util.List;

//TODO: handle pagination
public class ArticlesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArticleFeedAdapter mAdapter;
    private List<Datum> mDatumList;

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
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new ArticleFeedAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.updateAdapter(mDatumList);
    }
}
