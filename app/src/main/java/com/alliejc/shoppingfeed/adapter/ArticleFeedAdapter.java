package com.alliejc.shoppingfeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alliejc.shoppingfeed.R;
import com.alliejc.shoppingfeed.articles.Article;
import com.alliejc.shoppingfeed.articles.Datum;
import com.alliejc.shoppingfeed.viewholder.ArticleViewHolder;

import java.util.ArrayList;
import java.util.List;


public class ArticleFeedAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private Article mArticle;

    public ArticleFeedAdapter()
    {

    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
//        Datum datum = new Datum();
//        datum = mArticleList.get(position).getData().get(position);
        String title = mArticle.getData().get(position).getTitle();
        String image = mArticle.getData().get(position).getUrl();
        String date = mArticle.getData().get(position).getPublishedAt();

        holder.onBind(title, image, date);
    }

    @Override
    public int getItemCount() {
        if(mArticle.getData() != null){
            return mArticle.getData().size();
        } else {
            return 0;
        }
    }

    public void addArticle(Article article){
        mArticle = article;
        notifyDataSetChanged();
    }
}
