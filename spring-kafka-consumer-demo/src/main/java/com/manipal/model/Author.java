package com.manipal.model;

public class Author {
	private String authorName;
	private int noOfbooksWritten;
	private String location;
	
	public Author() {}
	public Author(String authorName, int noOfbooksWritten, String location) {
		super();
		this.authorName = authorName;
		this.noOfbooksWritten = noOfbooksWritten;
		this.location = location;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getNoOfbooksWritten() {
		return noOfbooksWritten;
	}
	public void setNoOfbooksWritten(int noOfbooksWritten) {
		this.noOfbooksWritten = noOfbooksWritten;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", noOfbooksWritten=" + noOfbooksWritten + ", location=" + location
				+ "]";
	}	
	
	
}
