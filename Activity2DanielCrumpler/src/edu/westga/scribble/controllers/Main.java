package edu.westga.scribble.controllers;

import edu.westga.scribble.view.Gui;

/**
 * Driver for the turtle application.
 * 
 * @author CS 1301
 * @version Spring 2019
 * 
 */
public class Main {

	public static final int WINDOW_SIZE = 500;

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
