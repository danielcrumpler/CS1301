package edu.westga.cs1301.grade_converter.model;

import java.util.ArrayList;

/**
 * Manages a list of students.
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class Roster {

	private ArrayList<Student> students;

	/**
	 * Creates the Roster
	 * 
	 * @precondition none
	 * @postcondition size() == 0
	 */
	public Roster() {
		this.students = new ArrayList<Student>();
	}

	/**
	 * Creating and adding a student to the roster.
	 * 
	 * @precondition name != null && !name.isEmpty() && 0 <= grade <= 100
	 * @postcondition getSize() == getSize()@prev + 1
	 * 
	 * @param name  The name of the student
	 * @param grade The grade of the student
	 * @return True, if student added, false otherwise
	 */
	public boolean addStudent(String name, int grade) {

		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}

		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}

		if (grade < 0 || grade > 100) {
			throw new IllegalArgumentException("Grade must be between 0 and 100 inclusive.");
		}
		
		for (Student student : this.students) {
			if (student.getName().equals(name)) {
				throw new IllegalArgumentException("Name cannot be duplicate.");
			}
		}
		Student theStudent = new Student(name, grade);
		return this.students.add(theStudent);	
	}

	/**
	 * Checks if student with given name exists in list
	 * 
	 * @precondition name != null and !name.isEmpty()
	 * @postcondition none
	 * @return true if student with given name in list, false otherwise
	 */
	public boolean hasStudentWithName(String name) {

		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}

		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}

		for (Student student : this.students) {
			if (student.getName().equals(name)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Removes all students whose names match the given name
	 * 
	 * @param name the name to remove
	 * @precondition name != null and !name.isEmpty()
	 * @postcondition list contains no student with given name &&
	 */
	public void removeAllStudentsWithName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null."); 
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		
		ArrayList<Student> studentsToRemove = new ArrayList<Student>();
		
		for (Student student : this.students) {
			if (student.getName().equals(name)) {
				studentsToRemove.add(student);
			}
		}
		this.students.removeAll(studentsToRemove);
	}
	
	/**
	 * Removes last student whose name matches the given name
	 * 
	 * @param name the name of the student to remove
	 * @precondition name != null && !name.isEmpty()
	 * @postcondition list does not contain last student with given name
	 */
	public void removeLastStudentWithName(String name) {

		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}

		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}

		if (this.hasStudentWithName(name)) {
			int indexOfStudentToRemove = -1;
			for (int index = this.students.size() - 1; index > 0; index--) {
				if (this.students.get(index).getName().equals(name)) {
					indexOfStudentToRemove = index;
				}
			}
			this.students.remove(indexOfStudentToRemove);
		}
	}

	/**
	 * Removes first student whose name matches the given name
	 * 
	 * @param name the name of the student to remove
	 * @precondition name != null && !name.isEmpty()
	 * @postcondition list does not contain first student with given name &&
	 *                getNumberOfStudents() == getNumberOfStudents()@prev - number
	 *                of students to remove
	 */
	public void removeFirstStudentWithName(String name) {

		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}

		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}

		if (this.hasStudentWithName(name)) {
			int indexOfStudentToRemove = -1;
			for (int index = 0; index < this.students.size(); index++) {
				if (this.students.get(index).getName().equals(name)) {
					indexOfStudentToRemove = index;
					break;
				}
			}
			this.students.remove(indexOfStudentToRemove);
		}

	}

	/**
	 * Gets the list of students in this roster.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the students
	 */
	public ArrayList<Student> getStudents() {
		return this.students;
	}

	/**
	 * Gets the number of students in this roster.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the students
	 */
	public int getNumberOfStudents() {
		return this.students.size();
	}

	/**
	 * Returns the String representation of the Roster object.
	 */
	@Override
	public String toString() {
		String result = "Roster:\n";
		for (Student student : this.students) {
			result += student.getName() + ", " + student.getGrade() + "\n";
		}
		return result;
	}

}
