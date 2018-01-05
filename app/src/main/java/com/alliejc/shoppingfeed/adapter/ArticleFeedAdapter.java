package com.alliejc.shoppingfeed.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alliejc.shoppingfeed.R;
import com.alliejc.shoppingfeed.articles.Datum;
import com.alliejc.shoppingfeed.util.ImageSizer;
import com.alliejc.shoppingfeed.util.DateHelper;
import com.alliejc.shoppingfeed.viewholder.ArticleViewHolder;

import java.util.ArrayList;
import java.util.List;


public class ArticleFeedAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private List<Datum> mDatumList;
    private Context mContext;

    public ArticleFeedAdapter(Context context) {
        this.mContext = context;
        mDatumList = new ArrayList<>();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Datum datum = mDatumList.get(holder.getAdapterPosition());
        holder.onBind(mContext, datum);
    }

    @Override
    public int getItemCount() {
        if(mDatumList != null){
            return mDatumList.size();
        } else {
            return 0;
        }
    }

    public void updateAdapter(List<Datum> list){
        if(mDatumList != null) {
            mDatumList.clear();
            mDatumList.addAll(list);
            notifyDataSetChanged();
        }
    }
}
