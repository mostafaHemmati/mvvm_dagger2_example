package com.hemmati.mvvmrxjavadagger2example.model.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileModel {
    @SerializedName("profile")
    @Expose
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

}
