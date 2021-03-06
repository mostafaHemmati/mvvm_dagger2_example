package com.hemmati.mvvmrxjavadagger2example.model.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MostViewedVideosListModel {

    @SerializedName("mostviewedvideos")
    @Expose
    private List<MostViewedVideo> mostViewedVideos = null;
    @SerializedName("ui")
    @Expose
    private UiModel ui;

    public List<MostViewedVideo> getMostViewedVideos() {
        return mostViewedVideos;
    }


    public UiModel getUi() {
        return ui;
    }

}