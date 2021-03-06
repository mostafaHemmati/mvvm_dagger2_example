package com.hemmati.mvvmrxjavadagger2example.model.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("pic_s")
    @Expose
    private String picS;
    @SerializedName("pic_m")
    @Expose
    private String picM;
    @SerializedName("pic_b")
    @Expose
    private String picB;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("userid")
    @Expose
    private Integer userid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("video_cnt")
    @Expose
    private String videoCnt;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("follower_cnt")
    @Expose
    private String followerCnt;
    @SerializedName("followed_cnt")
    @Expose
    private String followedCnt;
    @SerializedName("descr")
    @Expose
    private String descr;
    @SerializedName("official")
    @Expose
    private String official;
    @SerializedName("cloob")
    @Expose
    private String cloob;
    @SerializedName("lenzor")
    @Expose
    private String lenzor;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("follow_link")
    @Expose
    private Object followLink;
    @SerializedName("follow_status")
    @Expose
    private Object followStatus;
    @SerializedName("cover_src")
    @Expose
    private String coverSrc;
    @SerializedName("has_live")
    @Expose
    private String hasLive;
    @SerializedName("profile_videos")
    @Expose
    private String profileVideos;

    public String getPicS() {
        return picS;
    }

    public String getPicM() {
        return picM;
    }

    public String getPicB() {
        return picB;
    }

    public String getUsername() {
        return username;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getVideoCnt() {
        return videoCnt;
    }

    public String getUrl() {
        return url;
    }

    public String getFollowerCnt() {
        return followerCnt;
    }

    public String getFollowedCnt() {
        return followedCnt;
    }

    public String getDescr() {
        return descr;
    }

    public String getOfficial() {
        return official;
    }

    public String getCloob() {
        return cloob;
    }

    public String getLenzor() {
        return lenzor;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public Object getFollowLink() {
        return followLink;
    }

    public Object getFollowStatus() {
        return followStatus;
    }

    public String getCoverSrc() {
        return coverSrc;
    }

    public String getHasLive() {
        return hasLive;
    }

    public String getProfileVideos() {
        return profileVideos;
    }
}
