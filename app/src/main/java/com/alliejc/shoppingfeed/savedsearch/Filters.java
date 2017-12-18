
package com.alliejc.shoppingfeed.savedsearch;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Filters {

    @SerializedName("strata")
    @Expose
    private List<String> mStrata;

    public List<String> getStrata() {
        return mStrata;
    }

    public void setStrata(List<String> strata) {
        mStrata = strata;
    }

}
