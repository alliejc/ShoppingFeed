package com.alliejc.shoppingfeed.viewholder;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alliejc.shoppingfeed.R;

import java.net.URI;


public class SavedSearchViewHolder extends RecyclerView.ViewHolder {
    public ImageView mSavedImage;
    public TextView mSavedTitle;

    public SavedSearchViewHolder(View itemView) {
        super(itemView);

        mSavedImage = (ImageView) itemView.findViewById(R.id.saved_image);
        mSavedTitle = (TextView) itemView.findViewById(R.id.saved_title);
    }

    public void onBind(String title, Uri image){
        mSavedTitle.setText(title);
        mSavedImage.setImageURI(image);
    }
}
