
package com.alliejc.shoppingfeed.articles;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Pagination {

    @SerializedName("current_page")
    private String mCurrentPage;
    @SerializedName("next_page")
    private String mNextPage;
    @SerializedName("previous_page")
    private String mPreviousPage;

    public String getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(String currentPage) {
        mCurrentPage = currentPage;
    }

    public String getNextPage() {
        return mNextPage;
    }

    public void setNextPage(String nextPage) {
        mNextPage = nextPage;
    }

    public String getPreviousPage() {
        return mPreviousPage;
    }

    public void setPreviousPage(String previousPage) {
        mPreviousPage = previousPage;
    }

}
