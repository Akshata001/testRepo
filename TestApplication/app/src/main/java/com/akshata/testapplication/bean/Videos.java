package com.akshata.testapplication.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Akshata on 5/5/2017.
 */
public class Videos {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("upload_date")
    @Expose
    private String uploadDate;
    @SerializedName("mobile_url")
    @Expose
    private String mobileUrl;
    @SerializedName("thumbnail_small")
    @Expose
    private String thumbnailSmall;
    @SerializedName("thumbnail_medium")
    @Expose
    private String thumbnailMedium;
    @SerializedName("thumbnail_large")
    @Expose
    private String thumbnailLarge;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_url")
    @Expose
    private String userUrl;
    @SerializedName("user_portrait_small")
    @Expose
    private String userPortraitSmall;
    @SerializedName("user_portrait_medium")
    @Expose
    private String userPortraitMedium;
    @SerializedName("user_portrait_large")
    @Expose
    private String userPortraitLarge;
    @SerializedName("user_portrait_huge")
    @Expose
    private String userPortraitHuge;
    @SerializedName("stats_number_of_likes")
    @Expose
    private Integer statsNumberOfLikes;
    @SerializedName("stats_number_of_plays")
    @Expose
    private Integer statsNumberOfPlays;
    @SerializedName("stats_number_of_comments")
    @Expose
    private Integer statsNumberOfComments;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("embed_privacy")
    @Expose
    private String embedPrivacy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getThumbnailSmall() {
        return thumbnailSmall;
    }

    public void setThumbnailSmall(String thumbnailSmall) {
        this.thumbnailSmall = thumbnailSmall;
    }

    public String getThumbnailMedium() {
        return thumbnailMedium;
    }

    public void setThumbnailMedium(String thumbnailMedium) {
        this.thumbnailMedium = thumbnailMedium;
    }

    public String getThumbnailLarge() {
        return thumbnailLarge;
    }

    public void setThumbnailLarge(String thumbnailLarge) {
        this.thumbnailLarge = thumbnailLarge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserPortraitSmall() {
        return userPortraitSmall;
    }

    public void setUserPortraitSmall(String userPortraitSmall) {
        this.userPortraitSmall = userPortraitSmall;
    }

    public String getUserPortraitMedium() {
        return userPortraitMedium;
    }

    public void setUserPortraitMedium(String userPortraitMedium) {
        this.userPortraitMedium = userPortraitMedium;
    }

    public String getUserPortraitLarge() {
        return userPortraitLarge;
    }

    public void setUserPortraitLarge(String userPortraitLarge) {
        this.userPortraitLarge = userPortraitLarge;
    }

    public String getUserPortraitHuge() {
        return userPortraitHuge;
    }

    public void setUserPortraitHuge(String userPortraitHuge) {
        this.userPortraitHuge = userPortraitHuge;
    }

    public Integer getStatsNumberOfLikes() {
        return statsNumberOfLikes;
    }

    public void setStatsNumberOfLikes(Integer statsNumberOfLikes) {
        this.statsNumberOfLikes = statsNumberOfLikes;
    }

    public Integer getStatsNumberOfPlays() {
        return statsNumberOfPlays;
    }

    public void setStatsNumberOfPlays(Integer statsNumberOfPlays) {
        this.statsNumberOfPlays = statsNumberOfPlays;
    }

    public Integer getStatsNumberOfComments() {
        return statsNumberOfComments;
    }

    public void setStatsNumberOfComments(Integer statsNumberOfComments) {
        this.statsNumberOfComments = statsNumberOfComments;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getEmbedPrivacy() {
        return embedPrivacy;
    }

    public void setEmbedPrivacy(String embedPrivacy) {
        this.embedPrivacy = embedPrivacy;
    }


}
