
package com.alliejc.shoppingfeed.savedsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Datum {

    @SerializedName("article")
    @Expose
    private Object mArticle;
    @SerializedName("id")
    @Expose
    private Long mId;
    @SerializedName("image_url")
    @Expose
    private String mImageUrl;
    @SerializedName("item_type")
    @Expose
    private String mItemType;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("published")
    @Expose
    private Boolean mPublished;
    @SerializedName("published_at")
    @Expose
    private String mPublishedAt;
    @SerializedName("search")
    @Expose
    private Search mSearch;

    public Object getArticle() {
        return mArticle;
    }

    public void setArticle(Object article) {
        mArticle = article;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getItemType() {
        return mItemType;
    }

    public void setItemType(String itemType) {
        mItemType = itemType;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Boolean getPublished() {
        return mPublished;
    }

    public void setPublished(Boolean published) {
        mPublished = published;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        mPublishedAt = publishedAt;
    }

    public Search getSearch() {
        return mSearch;
    }

    public void setSearch(Search search) {
        mSearch = search;
    }

}
