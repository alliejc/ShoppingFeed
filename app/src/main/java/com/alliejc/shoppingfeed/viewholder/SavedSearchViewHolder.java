package com.alliejc.shoppingfeed.viewholder;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alliejc.shoppingfeed.R;
import com.bumptech.glide.Glide;

import java.net.URI;


public class SavedSearchViewHolder extends RecyclerView.ViewHolder {
    public ImageView mSavedImage;
    public TextView mSavedTitle;

    public SavedSearchViewHolder(View itemView) {
        super(itemView);

        mSavedImage = (ImageView) itemView.findViewById(R.id.saved_image);
        mSavedTitle = (TextView) itemView.findViewById(R.id.saved_title);
    }

    public void onBind(Context context, String title, String image){
        mSavedTitle.setText(title);
        Glide.with(context).load(image).into(mSavedImage);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSavedImage.setClipToOutline(true);
        }
    }
}
