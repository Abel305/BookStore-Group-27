package com.geek.text.dto;

public class RatingDto {
	private Integer userId; // user id associated with the rating
    private int rating; // the rating value given by the user
    
    public RatingDto() {
    	//Default Constructor
    }
    
    // constructor with userId and rating parameters
	public RatingDto(Integer userId, int rating) { 
		super();
		this.userId = userId;
		this.rating = rating;
	}
	
	//Setters and Getters of the member variables

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

    
}