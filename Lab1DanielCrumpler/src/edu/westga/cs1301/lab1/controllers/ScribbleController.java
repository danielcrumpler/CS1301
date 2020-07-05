package edu.westga.cs1301.lab1.controllers;

import edu.westga.cs1301.lab1.model.Turtle;

/**
 * Uses Turtle objects to draw on the screen.
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class ScribbleController {
	private Turtle turtle1;

	/**
	 * Creates and initializes a new ScribbleController object.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public ScribbleController() {
		this.turtle1 = new Turtle();
	}

	/**
	 * Draws a figure on the screen using turtle objects.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void draw() {
		// TODO Add the code here to have turtle1 draw the required shapes
		//Set Location for Square
		this.turtle1.setLocation(175, 225);
		//Drawing the Square
		this.turtle1.lowerTail();
		this.turtle1.stepForwardTwo();
		this.turtle1.turnRight90();
		this.turtle1.stepForwardTwo();
		this.turtle1.turnRight90();
		this.turtle1.stepForwardTwo();
		this.turtle1.turnRight90();
		this.turtle1.stepForwardTwo();
		this.turtle1.raiseTail();
		//Set Location for Diamond
		this.turtle1.setLocation(375, 250);
		//Drawing the Diamond
		this.turtle1.lowerTail();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft90();
		this.turtle1.stepForwardTwo();
		this.turtle1.turnLeft90();
		this.turtle1.stepForwardTwo();
		this.turtle1.turnLeft90();
		this.turtle1.stepForwardTwo();
		this.turtle1.turnLeft90();
		this.turtle1.stepForwardTwo();
		this.turtle1.raiseTail();
	}

}