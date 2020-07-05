package edu.westga.cs1301.lab1.model;

import acm.graphics.GTurtle;

/**
 * Turtle represents a graphical turtle that can move around on the screen,
 * turn, and raise or lower its tail. When its tail is lowered, it "scratches" a
 * line on the screen that shows the path it takes.
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class Turtle extends GTurtle {

	public static final double INITIAL_TURTLE_SPEED = 0.8;
	public static final int INITIAL_SIZE = 50;

	/**
	 * Creates a new Turtle object of size 50 at location 25, 25.
	 * 
	 * @precondition none
	 * @postcondition isTailDown() == false AND getTurtleSize() ==
	 *                INITIAL_SIZE(50) AND getLocation() == (25, 25) AND
	 *                getSpeed() == INITIAL_TURTLE_SPEED(0.6)
	 * 
	 */
	public Turtle() {
		this.setSize(INITIAL_SIZE);
		this.setSpeed(INITIAL_TURTLE_SPEED);
		this.setLocation(INITIAL_SIZE / 2, INITIAL_SIZE / 2);
	}

	/**
	 * Moves the turtle forward in its current direction by a distance equal to
	 * its own size. The turtle draws a line if its tail is down, but otherwise
	 * just moves.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void stepForward() {
		this.forward();
	}

	/**
	 * Moves the turtle forward twice.
	 * Not sure if I am allowed to add my own behaviors for this project.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void stepForwardTwo() {
		this.forward();
		this.forward();
	}
	
	/**
	 * Moves the turtle forward three times.
	 * Not sure if I am allowed to add my own behaviors for this project.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void stepForwardThree() {
		this.forward();
		this.forward();
		this.forward();
	}
	
	/**
	 * Moves the turtle forward four times.
	 * Not sure if I am allowed to add my own behaviors for this project.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void stepForwardFour() {
		this.forward();
		this.forward();
		this.forward();
		this.forward();
	}	
	
	/**
	 * Moves the turtle forward five times.
	 * Not sure if I am allowed to add my own behaviors for this project.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void stepForwardFive() {
		this.forward();
		this.forward();
		this.forward();
		this.forward();
		this.forward();
	}	
	
	/**
	 * Turns the turtle 45 degrees to its left.
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public void turnLeft45() {
		this.left(45.0);
	}

	/**
	 * Turns the turtle 45 degrees to its right.
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public void turnRight45() {
		this.right(45.0);
	}

	/**
	 * Turns the turtle 90 degrees to its left. 
	 * Not sure if I am allowed to add my own behaviors for this project.
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public void turnLeft90() {
		this.left(90.0);
	}

	/**
	 * Turns the turtle 90 degrees to its right.
	 * Not sure if I am allowed to add my own behaviors for this project.
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public void turnRight90() {
		this.right(90.0);
	}
	
	/**
	 * Drops the turtle's tail to the ground so it will draw a line when it
	 * moves.
	 * 
	 * @precondition none
	 * @postcondition isTailDown() == true
	 */
	public void lowerTail() {
		this.penDown();
	}

	/**
	 * Lifts the turtle's tail from the ground so it won't draw a line when it
	 * moves.
	 * 
	 * @precondition none
	 * @postcondition isTailDown() == false.
	 */
	public void raiseTail() {
		this.penUp();
	}
}
