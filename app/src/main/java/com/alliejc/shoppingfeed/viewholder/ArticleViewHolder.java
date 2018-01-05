package com.alliejc.shoppingfeed.viewholder;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alliejc.shoppingfeed.R;
import com.alliejc.shoppingfeed.articles.Datum;
import com.alliejc.shoppingfeed.util.DateHelper;
import com.alliejc.shoppingfeed.util.ImageSizer;
import com.bumptech.glide.Glide;

public class ArticleViewHolder extends RecyclerView.ViewHolder{
    public ImageView mArticleImage;
    public TextView mPublishedDate;
    public TextView mArticleTitle;

    public ArticleViewHolder(View itemView) {
        super(itemView);

        mArticleImage = (ImageView) itemView.findViewById(R.id.article_image);
        mPublishedDate = (TextView) itemView.findViewById(R.id.article_published_date);
        mArticleTitle = (TextView) itemView.findViewById(R.id.article_title);
    }

    public void onBind(Context context, Datum datum){
        String title = datum.getTitle();
        String image = ImageSizer.resizeImage(datum.getHero());
        String date = DateHelper.setDateParsing(datum.getPublishedAt());

        mArticleTitle.setText(title);
        mPublishedDate.setText(date);

        Glide.with(context).load(image).into(mArticleImage);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mArticleImage.setClipToOutline(true);
        }
    }
}
