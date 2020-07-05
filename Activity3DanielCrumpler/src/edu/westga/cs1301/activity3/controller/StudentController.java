package edu.westga.cs1301.activity3.controller;

import edu.westga.cs1301.activity3.model.Student;

/**
 * Manages two students.
 * 
 * @author CS 1301
 * @version Spring 2019
 *
 */
public class StudentController {

	private Student student1;
	private Student student2;

	/**
	 * Creates and initializes a new StudentController object.
	 * 
	 * @precondition none
	 * @postcondition student1 and student2 have been instantiated to default values
	 */
	public StudentController() {

		this.student1 = new Student();
		this.student2 = new Student();
	}

	/**
	 * Applies different operations on the students.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void organize() {
		
		this.student1.setName("Ricky");
		String nameofStudentOne = this.student1.getName();
		System.out.println("The name is: " + nameofStudentOne);
		
		this.student2.setName("Bobby");
		String nameofStudentTwo = this.student2.getName();
		System.out.println("The name is: " + nameofStudentTwo);
		
		this.student1.setGrade(100);
		this.student2.setGrade(80);
		
		double average = 0.0;
		average = (100 + 80) / 2;
		System.out.print("On average, the students grades were " + average);
		

	}
}
