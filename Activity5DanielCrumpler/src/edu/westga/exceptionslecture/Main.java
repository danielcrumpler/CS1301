package edu.westga.exceptionslecture;

import edu.westga.exceptionslecture.controllers.DivisionController;

/**
 * Main entry point of this program.
 * @author CS 1301
 * @version Spring 2019
 *
 */
public class Main {
	
	public static void main(String[] args) {
		DivisionController controller = new DivisionController();
		controller.run();
	}

}
