package edu.handong.analysis.datamodel;

public class Student {
	
	private String name;

	public static void main(String[] args) {
		Student myStudent = new Student();
		myStudent.getName();
	}
	
	public String getName() {
		return this.name;
	}

	public String setName(String str) {
		this.name = str;
		System.out.println(name);
		return name;
	}

}
