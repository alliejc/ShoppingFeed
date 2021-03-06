package com.alliejc.shoppingfeed.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alliejc.shoppingfeed.R;
import com.alliejc.shoppingfeed.adapter.SavedFeedAdapter;
import com.alliejc.shoppingfeed.savedsearch.Datum;

import java.util.List;


public class SavedSearchFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SavedFeedAdapter mAdapter;
    private List<Datum> mDatumList;

    public SavedSearchFragment() {
    }

    public static SavedSearchFragment getInstance(List<Datum> datumList){
        SavedSearchFragment savedSearchFragment = new SavedSearchFragment();
        savedSearchFragment.mDatumList = datumList;
        return savedSearchFragment;
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

        mAdapter = new SavedFeedAdapter(getContext());

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.updateAdapter(mDatumList);
    }

}
