package edu.westga.cs1301.activity3.model;

/**
 * Represents a student.
 * 
 * @author CS 1301
 * @version Spring 2019
 */
public class Student {
	private String name;
	private int grade;

	/**
	 * Creates a new default Student (with default values).
	 * 
	 * @precondition none
	 * @postcondition getName().isEmpty() && getName().isEmpty() && getGrade()==0
	 */
	public Student() {
		this.name = "";
		this.grade = 0;
	}

	/**
	 * Creates a new Student with the specified name and grade.
	 * 
	 * @precondition name != none AND !name.isEmpty() AND grade >=0 AND grade <= 100
	 * @postcondition getName() == name AND getGrade() == grade
	 * 
	 * @param name  name of this student
	 * @param grade this student's numeric grade (between 0 and 100)
	 */
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	/**
	 * Returns the Student's grade
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the Student's grade
	 */
	public int getGrade() {
		return this.grade;
	}

	/**
	 * Returns the Student's name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the Student's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a new name for this student.
	 * 
	 * @param name
	 * @precondition name != none AND !name.isEmpty()
	 * @postcondition getName().equals(name)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets a new grade for this student.
	 * 
	 * @param grade
	 * @precondition grade >=0 AND grade <= 100
	 * @postcondition getGrade() == grade
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

}
