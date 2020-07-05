package edu.westga.cs1301.grade_converter.model;

/**
 * Defines a student
 * 
 * @author CS 1301
 * @version Spring 2019
 */
public class Student {
	private String name;
	private int grade;

	/**
	 * Creates a new Student with the specified name and grade.
	 * 
	 * @precondition name != none AND !name.isEmpty() AND 
	 * 				 grade >=0 AND grade <= 100
	 * @postcondition getName() == name AND getGrade() == grade
	 * 
	 * @param name
	 *            name of the student
	 * @param grade
	 *            the students numeric grade (between 0 and 100)
	 */
	public Student(String name, int grade) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null.");
		}
		
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty.");
		}
		
		if (grade < 0 || grade > 100) {
			throw new IllegalArgumentException("grade out of range of 0 to 100, inclusive.");
		}
		
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
}
