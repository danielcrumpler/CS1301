package edu.westga.cs1301.lab4;

import edu.westga.cs1301.lab4.view.Gui;

/**
 * Starts the turtle application.
 * 
 * @author CS1301
 * @version Spring 2019
 * 
 */
public class Main {

	/**
	 * Entry point for the program: creates the GUI object and calls its start
	 * method, which in turn calls its init and run methods.
	 *
	 * @precondition none
	 * @postcondition the GUI has been initialized
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		Gui theGui = new Gui();
		theGui.start(args);
	}

}
