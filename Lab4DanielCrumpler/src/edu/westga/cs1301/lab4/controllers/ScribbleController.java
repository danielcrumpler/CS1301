package edu.westga.cs1301.lab4.controllers;

import edu.westga.cs1301.lab4.model.Turtle;

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
		this.drawInitialBox();
		this.printStepStatistics();
	}

	private void moveToW() {
		this.letterTurtle.setLocation(225, 225);
	}

	private void drawW() {
		this.turnLTRight90();	
		this.letterTurtle.lowerTail();
		this.stepLTTwoForward();
		this.turnLTLeft90();
		this.letterTurtle.stepForward();
		this.turnLTLeft90();
		this.stepLTTwoForward();
		this.turnLTLeft180();
		this.stepLTTwoForward();
		this.turnLTLeft90();
		this.letterTurtle.stepForward();
		this.turnLTLeft90();
		this.stepLTTwoForward();
		this.letterTurtle.raiseTail();
	}

	private void moveToO() {
		this.letterTurtle.setLocation(345, 345);
	}

	private void drawO() {
		this.turnLTLeft180();
		this.letterTurtle.lowerTail();
		this.stepLTTwoForward();
		this.turnLTLeft90();
		this.stepLTTwoForward();
		this.turnLTLeft90();
		this.stepLTTwoForward();
		this.turnLTLeft90();
		this.stepLTTwoForward();
		this.letterTurtle.raiseTail();
	}

	private void moveToL() {
		this.letterTurtle.setLocation(465, 465);
	}

	private void drawL() {
		this.turnLTLeft90();	
		this.letterTurtle.lowerTail();
		this.stepLTTwoForward();
		this.turnLTLeft90();
		this.stepLTTwoForward();
		this.letterTurtle.raiseTail();
	}

	private void moveToBox() {
		this.boxTurtle.setLocation(185, 185);
	}

	private void drawInitialBox() {
		this.boxTurtle.lowerTail();
		this.stepBTFiveForward();
		this.turnBTRight90();
		this.stepBTFiveForward();
		this.turnBTRight90();
		this.stepBTFiveForward();
		this.turnBTRight90();
		this.stepBTFiveForward();
		this.boxTurtle.raiseTail();
	}

	private void turnBTRight90() {
		this.boxTurtle.turnRight45();
		this.boxTurtle.turnRight45();
	}

	private void stepBTFiveForward() {
		this.boxTurtle.stepForward();
		this.boxTurtle.stepForward();
		this.boxTurtle.stepForward();
		this.boxTurtle.stepForward();
		this.boxTurtle.stepForward();
	}

	private void turnLTRight90() {
		this.letterTurtle.turnRight45();
		this.letterTurtle.turnRight45();
	}
	
	private void turnLTLeft90() {
		this.letterTurtle.turnLeft45();
		this.letterTurtle.turnLeft45();
	}
	
	private void stepLTTwoForward() {
		this.letterTurtle.stepForward();
		this.letterTurtle.stepForward();
	}
	
	private void turnLTLeft180() {
		this.turnLTLeft90();
		this.turnLTLeft90();
	}
	
	/**
	 * Prints statistics for the number of steps taken by the turtle objects.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public void printStepStatistics() {
		int letterTurtleSteps = this.letterTurtle.getStepsForward();
		System.out.println("The letterTurtle took " + letterTurtleSteps + " steps.");
		int letterTurtleTurns = this.letterTurtle.getTurnsMade();
		System.out.println("The letterTurtle took " + letterTurtleTurns + " turns.");
		int boxTurtleSteps = this.boxTurtle.getStepsForward();
		System.out.println("The boxTurtle took " + boxTurtleSteps + " steps.");
		int boxTurtleTurns = this.boxTurtle.getTurnsMade();
		System.out.println("The boxTurtle took " + boxTurtleTurns + " turns.");
		int averageSteps = ((letterTurtleSteps + boxTurtleSteps) / 2);
		System.out.println("On average, the turtles made " + averageSteps + " steps.");
		int averageTurns = ((letterTurtleTurns + boxTurtleTurns) / 2);
		System.out.println("On average, the turtles made " + averageTurns + " turns.");
	}
}