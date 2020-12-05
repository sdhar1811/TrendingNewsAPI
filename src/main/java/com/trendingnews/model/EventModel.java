package com.trendingnews.model;

public class EventModel {
	
	private String category;
	private String content;
	private String date;
	private int numberOfComments;
	private String city;
	private String locationURI;
	private String pressSource;
	private double score;
	
	public EventModel() {
		
	}

	public EventModel(String category, String content, String date, int numberOfComments, String city,
			String locationURI, String pressSource, double score) {
		super();
		this.category = category;
		this.content = content;
		this.date = date;
		this.numberOfComments = numberOfComments;
		this.city = city;
		this.locationURI = locationURI;
		this.pressSource = pressSource;
		this.score = score;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocationURI() {
		return locationURI;
	}

	public void setLocationURI(String locationURI) {
		this.locationURI = locationURI;
	}

	public String getPressSource() {
		return pressSource;
	}

	public void setPressSource(String pressSource) {
		this.pressSource = pressSource;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	

}
