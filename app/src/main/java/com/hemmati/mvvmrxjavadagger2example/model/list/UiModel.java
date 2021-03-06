package com.hemmati.mvvmrxjavadagger2example.model.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UiModel {
    @SerializedName("pagingForward")
    @Expose
    private String pagingForward;
    @SerializedName("pagingBack")
    @Expose
    private String pagingBack;

}
