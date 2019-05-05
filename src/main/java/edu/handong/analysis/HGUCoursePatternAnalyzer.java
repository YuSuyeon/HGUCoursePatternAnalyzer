package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
								"1999-2, JC Nam, Programming Language Theory",
								"1999-1, JC Nam, Data Structures",
								"2001-1, JC Nam, Database Systems",
								"2018-1, SB Lim, Java Programming",
								"2018-2, SB Lim, Programming Language Theory",
								"2019-1, SB Lim, Data Structures",
								"2019-1, SB Lim, Algorithm Analysis",
								"2018-1, SJ Kim, Java Programming",
								"2018-2, SJ Kim, Programming Language Theory",
								"2019-1, SJ Kim, Logic Design",
								"2019-1, SJ Kim, Algorithm Analysis",
							};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);

		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		students = new Student[numOfStudents];
		
		int j =0;
		students[j++] = new Student(lines[0].split(",")[1].trim()); 
		
	    for(int i=0; i<lines.length; i++){
	    	
	    	String studentNames = lines[i].split(",")[1].trim();
	    	Student student = new Student(studentNames);
	    	
	    	if(!studentExist(students, student)) {
	    		students[j++] = new Student(student.getName());
	    	}
	    }
	       
		return students;

	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		for (int i = 0; i < lines.length; i++){
			if(students[i] == null) {
				break;
			}
			if(student.getName().equals(students[i].getName())) {
					return true;
			}	
		}
		
		return false; 
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		courses = new Course[numOfCourses];
		
		int j =0;
		courses[j++] = new Course(lines[0].split(",")[2].trim()); 
		
	    for(int i=0; i<lines.length; i++){
	    	
	    	String courseNames = lines[i].split(",")[2].trim();
	    	Course course = new Course(courseNames);
	    	
	    	if(!courseExist(courses, course)) {
	    		courses[j++] = new Course(course.getCourseName());
	    	}
	    }
	       
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		for (int i = 0; i < lines.length; i++){
			if(courses[i] == null) {
				break;
			}
			
			if(course.getCourseName().equals(courses[i].getCourseName())) {
				return true;
			} 
		}
		
		return false;
	}	

}
