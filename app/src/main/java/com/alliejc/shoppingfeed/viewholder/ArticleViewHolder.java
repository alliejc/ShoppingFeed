package com.alliejc.shoppingfeed.viewholder;

import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alliejc.shoppingfeed.R;


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

    public void onBind(String title, String image, String date){
        mArticleTitle.setText(title);
        mArticleImage.setImageURI(Uri.parse(image));
        mPublishedDate.setText(date);
    }
}
