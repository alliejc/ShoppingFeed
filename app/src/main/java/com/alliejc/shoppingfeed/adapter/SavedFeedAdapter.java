package com.alliejc.shoppingfeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alliejc.shoppingfeed.R;
import com.alliejc.shoppingfeed.savedsearch.SavedSearch;
import com.alliejc.shoppingfeed.viewholder.SavedSearchViewHolder;

import java.util.ArrayList;
import java.util.List;


public class SavedFeedAdapter extends RecyclerView.Adapter<SavedSearchViewHolder> {
    private List<SavedSearch> mSavedSearchList;

    public SavedFeedAdapter() {
        mSavedSearchList = new ArrayList<>();
    }

    @Override
    public SavedSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_saved_search, parent, false);
        return new SavedSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SavedSearchViewHolder holder, int position) {
//        String title;
//        Uri image;
//        String date;
//        holder.onBind(title, image, date);
    }

    @Override
    public int getItemCount() {
        if(mSavedSearchList != null) {
            return mSavedSearchList.size();
        } else {
            return 0;
        }
    }

    public void addArticles(List<SavedSearch> searches){
        mSavedSearchList.addAll(searches);
    }
}
