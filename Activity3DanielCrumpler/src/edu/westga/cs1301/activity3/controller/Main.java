package edu.westga.cs1301.activity3.controller;

/**
 * Entry point for the program.
 * 
 * @author CS 1301
 * @version Spring 2019
 */
public class Main {

	/**
	 * Default entry point for the program. Creates the StudentController object and
	 * calls its organize method.
	 *
	 * @precondition none
	 * @param args command line arguments for the program
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to Activity3.");
		StudentController studentController = new StudentController();
		studentController.organize();
	}

}
