package com.alliejc.shoppingfeed;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alliejc.shoppingfeed.articles.Article;
import com.alliejc.shoppingfeed.viewholder.ArticleViewHolder;

import java.util.ArrayList;
import java.util.List;


public class ArticleFeedAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private List<Article> mArticleList;

    public ArticleFeedAdapter() {
        mArticleList = new ArrayList<>();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        String title = mArticleList.get(position).getData().get(position).getTitle();
        String image = mArticleList.get(position).getData().get(position).getUrl();
        String date = mArticleList.get(position).getData().get(position).getPublishedAt();
        Log.e("date", date);
        Log.e("title", title);
        holder.onBind(title, image, date);
    }

    @Override
    public int getItemCount() {
        if(mArticleList != null){
            return mArticleList.size();
        } else {
            return 0;
        }
    }

    public void addArticles(List<Article> articles){
        mArticleList.addAll(articles);
        notifyDataSetChanged();
    }
}
