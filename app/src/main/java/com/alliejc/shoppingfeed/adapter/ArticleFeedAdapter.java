package com.alliejc.shoppingfeed.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alliejc.shoppingfeed.R;
import com.alliejc.shoppingfeed.articles.Article;
import com.alliejc.shoppingfeed.articles.Datum;
import com.alliejc.shoppingfeed.util.ImageSizer;
import com.alliejc.shoppingfeed.viewholder.ArticleViewHolder;

import java.util.ArrayList;
import java.util.List;


public class ArticleFeedAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private Article mArticle;
    private List<Datum> mDataumList;
    private Context mContext;

    public ArticleFeedAdapter(Context context) {
        this.mContext = context;
        mDataumList = new ArrayList<>();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Datum datum = mDataumList.get(holder.getAdapterPosition());
        String title = datum.getTitle();
        String image = ImageSizer.resizeImage(datum.getHero());
        String date = datum.getPublishedAt();

        holder.onBind(mContext, title, image, date);
    }

    @Override
    public int getItemCount() {
        if(mDataumList != null){
            return mDataumList.size();
        } else {
            return 0;
        }
    }


    public void addArticle(Article article){
        mArticle = article;
        notifyDataSetChanged();
    }

    public void updateAdapter(List<Datum> list){
        mDataumList.addAll(list);
        notifyDataSetChanged();
    }
}
