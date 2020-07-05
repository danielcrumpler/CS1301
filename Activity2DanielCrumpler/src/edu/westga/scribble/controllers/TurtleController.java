package edu.westga.scribble.controllers;

import edu.westga.scribble.model.Turtle;

/**
 * Uses ScribbleTurtle objects to draw on the screen.
 * 
 * @author CS 1301
 * @version Spring 2019
 */
public class TurtleController {
	private Turtle turtle1;

	/**
	 * Creates and initializes a new ScribbleController object.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public TurtleController() {
		this.turtle1 = new Turtle();
	}

	/**
	 * Draws a figure on the screen using turtle1.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void draw() {
		this.moveTurtle1ToStartOfPlus();
		this.drawPlus();
		this.moveTurtle1ToStartOfRectangle();
		this.drawRectangle();
		this.turtle1.stepForward();
	}

	private void drawRectangle() {
		this.turtle1.lowerTail();
		this.takeFiveSteps();
		this.turtle1.turnRight90();
		this.takeThreeSteps();
		this.turtle1.turnRight90();
		this.takeFiveSteps();
		this.turtle1.turnRight90();
		this.takeThreeSteps();
		this.turtle1.raiseTail();
	}

	private void takeThreeSteps() {
		this.takeTwoSteps();
		this.turtle1.stepForward();
	}

	private void takeFiveSteps() {
		this.takeThreeSteps();
		this.takeTwoSteps();
	}

	private void moveTurtle1ToStartOfRectangle() {
		this.turtle1.turnRight90();
		this.takeThreeSteps();
		this.turtle1.turnLeft90();
	}

	private void drawPlus() {
		this.turtle1.lowerTail();
		this.takeTwoSteps();
		this.turtle1.turnLeft90();
		this.turtle1.stepForward();
		this.turtle1.turnRight90();
		this.turtle1.stepForward();
		this.turtle1.turnRight90();
		this.turtle1.stepForward();
		this.turtle1.turnLeft90();
		this.takeTwoSteps();
		this.turtle1.turnRight90();
		this.turtle1.stepForward();
		this.turtle1.turnRight90();
		this.takeTwoSteps();
		this.turtle1.turnLeft90();
		this.turtle1.stepForward();
		this.turtle1.turnRight90();
		this.turtle1.stepForward();
		this.turtle1.turnRight90();
		this.turtle1.stepForward();
		this.turtle1.turnLeft90();
		this.takeTwoSteps();
		this.turtle1.turnRight90();
		this.turtle1.stepForward();
		this.turtle1.turnRight90();
		this.turtle1.raiseTail();
	}

	private void moveTurtle1ToStartOfPlus() {
		this.takeTwoSteps();
		this.turtle1.turnRight90();
		this.takeTwoSteps();
		this.turtle1.turnLeft90();
	}

	private void takeTwoSteps() {
		this.turtle1.stepForward();
		this.turtle1.stepForward();
	}
}