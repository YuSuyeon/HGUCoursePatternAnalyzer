package edu.handong.analysis.datamodel;

public class Course {
	
	private String courseName;
	
	public static void main(String[] args) {
		Course course = new Course();
		course.getCourseName();
	}

	public String getCourseName() {
		return this.courseName;
	}
	
	public String setCourseName(String str) {
		this.courseName = str;
		return courseName;
}

}
