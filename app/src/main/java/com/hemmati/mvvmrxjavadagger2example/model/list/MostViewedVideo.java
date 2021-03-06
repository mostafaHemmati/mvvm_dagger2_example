package com.hemmati.mvvmrxjavadagger2example.model.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MostViewedVideo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("visit_cnt")
    @Expose
    private Integer visitCnt;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("isHidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("process")
    @Expose
    private String process;
    @SerializedName("big_poster")
    @Expose
    private String bigPoster;
    @SerializedName("small_poster")
    @Expose
    private String smallPoster;
    @SerializedName("profilePhoto")
    @Expose
    private String profilePhoto;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("sdate")
    @Expose
    private String sdate;
    @SerializedName("create_date")
    @Expose
    private String createDate;
    @SerializedName("sdate_timediff")
    @Expose
    private Integer sdateTimediff;
    @SerializedName("frame")
    @Expose
    private String frame;
    @SerializedName("official")
    @Expose
    private String official;
    @SerializedName("autoplay")
    @Expose
    private Boolean autoplay;
    @SerializedName("video_date_status")
    @Expose
    private String videoDateStatus;
    @SerializedName("360d")
    @Expose
    private Boolean _360d;
    @SerializedName("deleteurl")
    @Expose
    private String deleteurl;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getUserid() {
        return userid;
    }

    public Integer getVisitCnt() {
        return visitCnt;
    }

    public String getUid() {
        return uid;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public String getProcess() {
        return process;
    }

    public String getBigPoster() {
        return bigPoster;
    }

    public String getSmallPoster() {
        return smallPoster;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getSdate() {
        return sdate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Integer getSdateTimediff() {
        return sdateTimediff;
    }

    public String getFrame() {
        return frame;
    }

    public String getOfficial() {
        return official;
    }

    public Boolean getAutoplay() {
        return autoplay;
    }

    public String getVideoDateStatus() {
        return videoDateStatus;
    }

    public Boolean get_360d() {
        return _360d;
    }

    public String getDeleteurl() {
        return deleteurl;
    }
}
