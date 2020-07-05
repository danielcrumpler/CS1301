package edu.westga.cs1301.project1.model;

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

	public static final double INITIAL_SPEED = 0.6;
	public static final int INITIAL_SIZE = 50;
	private boolean tailDown;
	private int stepsForward;
	private int size;

	/**
	 * Creates a new Turtle object of size 50 at location 0, 0.
	 * 
	 * @precondition none
	 * @postcondition isTailDown() == false AND getTurtleSize() == size AND
	 *                getLocation() == (25, 25) AND getSpeed() ==
	 *                INITIAL_TURTLE_SPEED
	 * @param size The setSize of the turtle
	 */
	public Turtle(int size) {
		this.size = size;
		this.initializeWithDefaultValues();
	}

	private void initializeWithDefaultValues() {
		this.tailDown = false;
		this.stepsForward = 0;
		this.setSize(size);
		this.setSpeed(INITIAL_SPEED);
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
	 * Moves the turtle forward in its current direction by a distance equal to its
	 * own size. The turtle draws a line if its tail is down, but otherwise just
	 * moves.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param steps number of steps forward
	 */
	public void stepForward(int steps) {
		for (int i = 0; i < steps; i++) {
			this.forward();
			this.stepsForward++;
		}
	}

	/**
	 * Turns the turtle "double" degrees to its left.
	 *
	 * @precondition none
	 * @postcondition none
	 * @param left degrees to the left
	 */
	public void turnLeft(double left) {
		this.left(left);
	}

	/**
	 * Turns the turtle "double" degrees to its right.
	 *
	 * @precondition none
	 * @postcondition none
	 * @param right degrees to the right
	 */
	public void turnRight(double right) {
		this.right(right);
	}

	/**
	 * Drops the turtle's tail to the ground so it will draw a line when it moves.
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
	 * @return true if the tail is lowered
	 */
	public boolean isTailDown() {
		return this.tailDown;
	}

	/**
	 * Gets the number of steps forward the turtle has taken
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return The total number of steps forward the turtle has taken.
	 */
	public int getStepsForward() {
		return this.stepsForward;
	}

	/**
	 * Makes the Turtle draw a rectangle
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param width  Width of the Rectangle in steps.
	 * @param height Height of the Rectangle in steps.
	 */
	public void drawRectangle(int width, int height) {
		this.penDown();
		this.tailDown = true;
		this.drawsRectangle(width, height);
		this.penUp();
		this.tailDown = false;
	}

	private void drawsRectangle(int width, int height) {
		this.drawRectangleWidthandHeightOnce(width, height);
		this.drawRectangleWidthandHeightOnce(width, height);
	}

	private void drawRectangleWidthandHeightOnce(int width, int height) {
		for (int i = 0; i < width; i++) {
			this.forward();
			this.stepsForward++;
		}
		this.right(90.0);
		for (int i = 0; i < height; i++) {
			this.forward();
			this.stepsForward++;
		}
		this.right(90.0);
	}

	/**
	 * Makes the Turtle draw a Equilateral Triangle
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param size size of the equilateral triangle in steps.
	 */
	public void drawEquilateralTriangle(int length) {
		this.penDown();
		this.tailDown = true;
		this.drawsTriangle(length);
		this.penUp();
		this.tailDown = false;
	}

	private void drawsTriangle(int length) {
		this.drawTriangleLengthOnce(length);
		this.drawTriangleLengthOnce(length);
		this.drawTriangleLengthOnce(length);
	}

	private void drawTriangleLengthOnce(int length) {
		for (int i = 0; i < length; i++) {
			this.forward();
			this.stepsForward++;
		}
		this.left(120.0);
	}

	/**
	 * Makes the Turtle draw a Star
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param size size of the star in steps.
	 */
	public void drawStar(int size) {
		this.penDown();
		this.tailDown = true;
		this.drawsStar(size);
		this.penUp();
		this.tailDown = false;
	}

	private void drawsStar(int size) {
		this.drawStarLengthOnce(size);
		this.drawStarLengthOnce(size);
		this.drawStarLengthOnce(size);
		this.drawStarLengthOnce(size);
		this.drawStarLengthOnce(size);
	}

	private void drawStarLengthOnce(int size) {
		for (int i = 0; i < size; i++) {
			this.forward();
			this.stepsForward++;
		}
		this.left(72.0);
		for (int i = 0; i < size; i++) {
			this.forward();
			this.stepsForward++;
		}
		this.right(144.0);
	}
}