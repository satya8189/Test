package com.wre.yin.whiterabbiteventapp.beans;

import java.util.Date;


public class NewsFeedBean {

    private Long newsFeedId;
    private String newsTitle;
    private String newsDesc;
    private Date newsDate;
    private Long eventId;
    private String jsonDate;

    public String getJsonDate() {
        return jsonDate;
    }

    public void setJsonDate(String jsonDate) {
        this.jsonDate = jsonDate;
    }

    public Long getNewsFeedId() {
        return newsFeedId;
    }

    public void setNewsFeedId(Long newsFeedId) {
        this.newsFeedId = newsFeedId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
