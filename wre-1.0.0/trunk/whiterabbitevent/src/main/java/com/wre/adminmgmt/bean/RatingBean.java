package com.wre.adminmgmt.bean;

public class RatingBean {
	
	private Long ratingId;
    private Long sourceId;
    private Long userId;
    private Long eventId;
    private String type;
    private Float rating;
    
    public Long getRatingId() {
		return ratingId;
	}
	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "RatingBean [ratingId=" + ratingId + ", sourceId=" + sourceId
				+ ", userId=" + userId + ", eventId=" + eventId + ", type="
				+ type + ", rating=" + rating + "]";
	}
	    
}
