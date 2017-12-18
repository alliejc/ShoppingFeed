
package com.alliejc.shoppingfeed.savedsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Search {

    @SerializedName("default_name")
    @Expose
    private Object mDefaultName;
    @SerializedName("filters")
    @Expose
    private Filters mFilters;
    @SerializedName("index_name")
    @Expose
    private String mIndexName;
    @SerializedName("query")
    @Expose
    private String mQuery;
    @SerializedName("uuid")
    @Expose
    private String mUuid;

    public Object getDefaultName() {
        return mDefaultName;
    }

    public void setDefaultName(Object defaultName) {
        mDefaultName = defaultName;
    }

    public Filters getFilters() {
        return mFilters;
    }

    public void setFilters(Filters filters) {
        mFilters = filters;
    }

    public String getIndexName() {
        return mIndexName;
    }

    public void setIndexName(String indexName) {
        mIndexName = indexName;
    }

    public String getQuery() {
        return mQuery;
    }

    public void setQuery(String query) {
        mQuery = query;
    }

    public String getUuid() {
        return mUuid;
    }

    public void setUuid(String uuid) {
        mUuid = uuid;
    }

}
