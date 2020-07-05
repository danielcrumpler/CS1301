package edu.westga.cs1301.grade_converter.controller;

import edu.westga.cs1301.grade_converter.model.*;

/**
 * Entry point for the program.
 * 
 * @author CS 1301
 * @version Spring 2019
 */
public class Main {

	/**
	 * Default entry point for the program.
	 * 
	 * @param args command line arguments for the program
	 */
	public static void main(String[] args) {

		Roster roster = new Roster();
		System.out.println("The size of the list right after creation: " + roster.getNumberofStudents());

		Student Travis = new Student("Travis", 99);
		roster.addStudent(Travis);
		System.out.println("The size of the list after adding one student : " + roster.getNumberofStudents());
		
		Student Travis2 = new Student("Travis", 100);
		roster.addStudent(Travis2);
	}

}
