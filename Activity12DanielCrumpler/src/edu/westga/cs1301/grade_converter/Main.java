package edu.westga.cs1301.grade_converter;

import edu.westga.cs1301.grade_converter.model.Roster;

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
	 * @param args
	 *            command line arguments for the program
	 */
	public static void main(String[] args) {
		
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		roster.addStudent("Ron", 78);
		roster.addStudent("Tom", 82);
		roster.addStudent("Jim", 71);
		roster.addStudent("Jon", 55);
		System.out.println(roster);
		
		
		//roster.removeAllStudentsWithName("Jim");
		//roster.removeLastStudentWithName("Ana");
		//roster.removeFirstStudentWithName("Jim");
		
		System.out.println(roster);
	}

}
