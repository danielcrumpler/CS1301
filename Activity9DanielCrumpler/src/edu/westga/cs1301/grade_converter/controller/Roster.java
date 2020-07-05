package edu.westga.cs1301.grade_converter.controller;

import java.util.ArrayList;
import edu.westga.cs1301.grade_converter.model.Student;

/**
 * Keeps track of a list of students.
 * 
 * @author CS 1301
 * @version Spring 2019
 *
 */
public class Roster {

	private ArrayList<Student> students;

	/**
	 * Creates a roster of students and instantiates the list.
	 * 
	 * @precondition none
	 * @postcondition getNumberofStudents == 0
	 */
	public Roster() {
		this.students = new ArrayList<Student>();
	}

	/**
	 * Gets the list of students from this roster.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the list of students from this roster.
	 */
	public ArrayList<Student> getStudents() {
		return this.students;
	}

	/**
	 * Adds a student to the list
	 * 
	 * @precondition newStudent != null && another student with the smae name cannot
	 *               exist
	 * @postcondition getNumberofStudents()@prev + 1
	 * @param newStudent the student to be added
	 */
	public void addStudent(Student newStudent) {
		if (newStudent == null) {
			throw new IllegalArgumentException("Cannot add a null object.");
		}
		if (this.containsStudent(newStudent)) {
			throw new IllegalArgumentException("Cannot add another student with the same name.");
		}
		this.students.add(newStudent);
	}

	private boolean containsStudent(Student newStudent) {
		for (Student currentStudent : this.students) {
			if (newStudent.getName() == currentStudent.getName()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the size of the list.
	 * 
	 * @preconditon none
	 * @postcondition none
	 * @return the number of students in the list
	 */
	public int getNumberofStudents() {
		return this.students.size();
	}
}
