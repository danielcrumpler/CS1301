package edu.westga.cs1301.lab4.model;

import acm.graphics.GTurtle;

/**
 * Turtle represents a graphical turtle that can move around on the screen,
 * turn, and raise or lower its tail. When its tail is lowered, it "scratches" a
 * line on the screen that shows the path it takes.
 * 
 * @author CS 1301
 * @version Fall 2018
 */
public class Turtle extends GTurtle {

	public static final double INITIAL_TURTLE_SPEED = 0.7;
	public static final int INITIAL_SIZE = 50;

	private boolean tailDown;
	private int stepsForward;
	private int turnsMade;

	/**
	 * Creates a new Turtle object of size 50 at location 0, 0.
	 * 
	 * @precondition none
	 * @postcondition isTailDown() == false AND getTurtleSize() ==
	 *                INITIAL_SIZE(50) AND getLocation() == (25, 25) AND
	 *                getSpeed() == INITIAL_TURTLE_SPEED(0.6)
	 * 
	 */
	public Turtle() {
		this.tailDown = false;
		this.stepsForward = 0;
		this.turnsMade = 0;
		this.setSize(INITIAL_SIZE);
		this.setSpeed(INITIAL_TURTLE_SPEED);
		this.setLocation(INITIAL_SIZE / 2, INITIAL_SIZE / 2);
	}

	/**
	 * Increases the size of the turtle by 10.
	 * 
	 * @precondition none
	 * @postcondition getSize() == getSize()@prev + 10
	 */
	public void increaseTurtleSizeBy10() {
		int size = this.getTurtleSize();
		size = size + 10;
		this.setSize(size);
	}

	/**
	 * Decreases the size of the turtle by 10.
	 * 
	 * @precondition none
	 * @postcondition getSize() == getSize()@prev - 10
	 */
	public void decreaseTurtleSizeBy10() {
		int size = this.getTurtleSize();
		size = size - 10;
		this.setSize(size);
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
		this.stepsForward++;
	}

	/**
	 * Turns the turtle 45 degrees to its left.
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public void turnLeft45() {
		this.left(45.0);
		this.turnsMade++;
	}

	/**
	 * Turns the turtle 45 degrees to its right.
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public void turnRight45() {
		this.right(45.0);
		this.turnsMade++;
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
		this.tailDown = true;
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
		this.tailDown = false;
	}

	/**
	 * Returns true if the turtle's tail is lowered to the ground, false if it
	 * isn't.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true iff the tail is lowered
	 */
	public boolean isTailDown() {
		return this.tailDown;
	}
	
	/** Get the number of steps taken by the turtle.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of steps taken by the turtle
	 */
	public int getStepsForward() {
		return this.stepsForward;
	}
	
	/** Get the number of turns made by the turtle.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of turns made by the turtle
	 */
	public int getTurnsMade() {
		return this.turnsMade;
	}
}
