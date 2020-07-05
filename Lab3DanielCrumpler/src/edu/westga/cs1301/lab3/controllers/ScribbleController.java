package edu.westga.cs1301.lab3.controllers;

import edu.westga.cs1301.lab3.model.Turtle;

/**
 * Uses Turtle objects to draw on the screen.
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class ScribbleController {
	private Turtle letterTurtle;
	private Turtle boxTurtle;

	/**
	 * Creates and initializes a new TurtleController object.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public ScribbleController() {
		this.letterTurtle = new Turtle();
		this.letterTurtle.decreaseTurtleSizeBy10();

		this.boxTurtle = new Turtle();
		this.boxTurtle.increaseTurtleSizeBy10();
		this.boxTurtle.increaseTurtleSizeBy10();
		this.boxTurtle.increaseTurtleSizeBy10();
	}

	/**
	 * Draws a figure on the screen using turtle objects.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void draw() {
		this.moveToW();

		this.drawW();

		this.moveToO();

		this.drawO();

		this.moveToL();

		this.drawL();

		this.moveToBox();

		this.drawBox();
	}

	private void moveToL() {
		this.turnLTLeft180();
		this.stepLTForwardTwo();
		this.spaceDiagonalOneMove();
	}

	private void spaceDiagonalOneMove() {
		this.letterTurtle.stepForward();
		this.turnLTLeft90();
		this.letterTurtle.stepForward();
	}

	private void moveToW() {
		this.stepLTForwardFive();
		this.turnLTRight90();
		this.stepLTForwardFive();
	}

	private void drawW() {
		this.letterTurtle.lowerTail();
		this.stepLTForwardTwo();
		this.turnLTLeft90();
		this.letterTurtle.stepForward();
		this.turnLTLeft90();
		this.letterTurtle.stepForward();
		this.turnLTLeft180();
		this.letterTurtle.stepForward();
		this.turnLTLeft90();
		this.letterTurtle.stepForward();
		this.turnLTLeft90();
		this.stepLTForwardTwo();
		this.letterTurtle.raiseTail();
	}

	private void moveToO() {
		this.turnLTLeft180();
		this.stepLTForwardTwo();
		this.letterTurtle.stepForward();
		this.turnLTLeft90();
		this.stepLTForwardTwo();
		this.letterTurtle.stepForward();
		this.turnLTLeft180();
	}

	private void drawO() {
		this.letterTurtle.lowerTail();
		this.stepLTForwardTwo();
		this.turnLTLeft90();
		this.stepLTForwardTwo();
		this.turnLTLeft90();
		this.stepLTForwardTwo();
		this.turnLTLeft90();
		this.stepLTForwardTwo();
		this.letterTurtle.raiseTail();
	}

	private void drawL() {
		this.letterTurtle.lowerTail();
		this.turnLTRight90();
		this.stepLTForwardTwo();
		this.turnLTLeft90();
		this.stepLTForwardTwo();
		this.letterTurtle.raiseTail();
	}

	private void moveToBox() {
		this.stepBTForwardTwo();
		this.turnBTRight90();
		this.stepBTForwardTwo();
		this.turnBTLeft90();
	}

	private void drawBox() {
		this.boxTurtle.lowerTail();
		this.stepBTForwardFive();
		this.turnBTRight90();
		this.stepBTForwardFive();
		this.turnBTRight90();
		this.stepBTForwardFive();
		this.turnBTRight90();
		this.stepBTForwardFive();
		this.boxTurtle.raiseTail();
	}

	private void stepBTForwardFive() {
		this.stepBTForwardTwo();
		this.stepBTForwardTwo();
		this.boxTurtle.stepForward();
	}

	private void turnBTLeft90() {
		this.boxTurtle.turnLeft45();
		this.boxTurtle.turnLeft45();
	}

	private void turnBTRight90() {
		this.boxTurtle.turnRight45();
		this.boxTurtle.turnRight45();
	}

	private void stepBTForwardTwo() {
		this.boxTurtle.stepForward();
		this.boxTurtle.stepForward();
	}

	private void turnLTLeft180() {
		this.turnLTLeft90();
		this.turnLTLeft90();
	}

	private void stepLTForwardFive() {
		this.stepLTForwardTwo();
		this.stepLTForwardTwo();
		this.letterTurtle.stepForward();
	}

	private void stepLTForwardTwo() {
		this.letterTurtle.stepForward();
		this.letterTurtle.stepForward();
	}

	private void turnLTLeft90() {
		this.letterTurtle.turnLeft45();
		this.letterTurtle.turnLeft45();
	}

	private void turnLTRight90() {
		this.letterTurtle.turnRight45();
		this.letterTurtle.turnRight45();
	}
}