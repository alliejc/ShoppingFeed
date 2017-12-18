
package com.alliejc.shoppingfeed.articles;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Datum {

    @SerializedName("author")
    private String mAuthor;
    @SerializedName("content_type")
    private String mContentType;
    @SerializedName("franchise")
    private String mFranchise;
    @SerializedName("hero")
    private String mHero;
    @SerializedName("id")
    private Long mId;
    @SerializedName("listings")
    private List<Object> mListings;
    @SerializedName("position")
    private String mPosition;
    @SerializedName("published")
    private Boolean mPublished;
    @SerializedName("published_at")
    private String mPublishedAt;
    @SerializedName("slug")
    private String mSlug;
    @SerializedName("tag_list")
    private List<String> mTagList;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getContentType() {
        return mContentType;
    }

    public void setContentType(String contentType) {
        mContentType = contentType;
    }

    public String getFranchise() {
        return mFranchise;
    }

    public void setFranchise(String franchise) {
        mFranchise = franchise;
    }

    public String getHero() {
        return mHero;
    }

    public void setHero(String hero) {
        mHero = hero;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Object> getListings() {
        return mListings;
    }

    public void setListings(List<Object> listings) {
        mListings = listings;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
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

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public List<String> getTagList() {
        return mTagList;
    }

    public void setTagList(List<String> tagList) {
        mTagList = tagList;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
