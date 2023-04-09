package com.geek.text.dto;


public class CommentDto {
	private Integer userId; // stores the ID of the user who wrote the comment
    private String comment; // stores the comment text
    
    public CommentDto() {
        // default constructor
    }
    
    public CommentDto(Integer userId, String comment) {
        super();
        this.userId = userId; // sets the user ID
        this.comment = comment; // sets the comment text
    }
    
    //Setters and Getters of the member variables

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
