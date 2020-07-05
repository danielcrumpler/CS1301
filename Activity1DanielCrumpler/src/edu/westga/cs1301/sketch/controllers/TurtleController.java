package edu.westga.cs1301.sketch.controllers;

import edu.westga.cs1301.sketch.model.Turtle;

/**
 * Uses turtle objects to draw on the screen.
 * 
 * @author CS 1301
 * @version Spring 2019
 */
public class TurtleController {
	private Turtle bigTurtle;

	/**
	 * Creates and initializes a new TurtleController object.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public TurtleController() {
		this.bigTurtle = new Turtle();
	}

	/**
	 * Draws a figure on the screen using the big turtle.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void draw() {
		// TODO Add the code here to have the bigTurtle draw the required shapes
		// Set Location for Rectangle
		this.bigTurtle.setLocation(125, 125);
		// Drawing Rectangle
		this.bigTurtle.lowerTail();
		this.bigTurtle.stepForwardFive();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardThree();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardFive();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardThree();
		this.bigTurtle.turnRight90();
		this.bigTurtle.raiseTail();
		// Set Location for Oblong Shape
		this.bigTurtle.setLocation(125, 375);
		// Drawing Oblong Shape
		this.bigTurtle.lowerTail();
		this.bigTurtle.stepForwardTwo();
		this.bigTurtle.turnLeft90();
		this.bigTurtle.stepForwardOne();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardOne();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardOne();
		this.bigTurtle.turnLeft90();
		this.bigTurtle.stepForwardTwo();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardOne();
		this.bigTurtle.turnRight90();
		this.bigTurtle.lowerTail();
		this.bigTurtle.stepForwardTwo();
		this.bigTurtle.turnLeft90();
		this.bigTurtle.stepForwardOne();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardOne();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardOne();
		this.bigTurtle.turnLeft90();
		this.bigTurtle.stepForwardTwo();
		this.bigTurtle.turnRight90();
		this.bigTurtle.stepForwardOne();
		this.bigTurtle.raiseTail();
	}

}
