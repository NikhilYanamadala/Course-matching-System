package edu.umkc.da;

import java.util.Map;

public class Course {
	
	private int courseID;
	private String courseName;
	private Map<Topic,Double> courseTopics;
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Map<Topic,Double> getTopics() {
		return courseTopics;
	}
	public void setTopics(Map<Topic,Double> courseTopics) {
		this.courseTopics = courseTopics;
	}

}
