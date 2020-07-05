package edu.westga.cs1301.project1.controllers;

import java.awt.Color;

import edu.westga.cs1301.project1.model.Turtle;
import edu.westga.cs1301.project1.utils.Statistics;

/**
 * Uses turtle objects to draw on the screen.
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class TurtleController {
	private Turtle bigTurtle;
	private Turtle littleTurtle;

	/**
	 * Creates and initializes a new TurtleController object.
	 * 
	 * @precondition bigTurtle != null AND littleTurtle != null
	 * @postcondition none
	 * 
	 * @param bigTurtle    The bigger of the two turtles.
	 * @param littleTurtle The smaller of the two turtles.
	 * 
	 */
	public TurtleController(Turtle bigTurtle, Turtle littleTurtle) {
		this.bigTurtle = bigTurtle;
		this.littleTurtle = littleTurtle;
	}

	/**
	 * Draws a rectangle pattern on the screen using turtles.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void drawRectanglePattern() {
		this.bigTurtle.setLocation(85, 85);
		this.littleTurtle.setLocation(115, 115);
		this.bigTurtle.drawRectangle(12, 6);
		this.littleTurtle.drawRectangle(22, 10);
		this.bigTurtle.setLocation(85, 445);
		this.littleTurtle.setLocation(115, 475);
		this.bigTurtle.drawRectangle(12, 6);
		this.littleTurtle.drawRectangle(22, 10);

	}

	/**
	 * Draws a figure on the screen using turtles.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void draw() {
		this.littleTurtle.setLocation(100, 100);
		this.littleTurtle.setColor(Color.yellow);
		this.littleTurtle.drawStar(2);
		this.littleTurtle.setLocation(700, 100);
		this.littleTurtle.drawStar(1);
		this.bigTurtle.setLocation(300, 350);
		this.bigTurtle.setColor(Color.red);
		this.bigTurtle.drawEquilateralTriangle(6);
		this.bigTurtle.setLocation(300, 350);
		this.bigTurtle.setColor(Color.black);
		this.bigTurtle.drawRectangle(6, 6);
		this.littleTurtle.setLocation(450, 590);
		this.littleTurtle.setColor(Color.black);
		this.littleTurtle.drawRectangle(2, 4);
		this.littleTurtle.setLocation(360, 410);
		this.littleTurtle.setColor(Color.blue);
		this.drawWindow();
		this.littleTurtle.setLocation(540, 410);
		this.littleTurtle.setColor(Color.green);
		this.drawWindow();
		this.littleTurtle.setLocation(360, 610);
		this.littleTurtle.setColor(Color.cyan);
		this.drawWindow();
		this.littleTurtle.setLocation(540, 610);
		this.littleTurtle.setColor(Color.orange);
		this.drawWindow();
		this.littleTurtle.setColor(Color.black);
		this.bigTurtle.setLocation(50, 50);
		this.littleTurtle.setLocation(100, 50);
	}

	private void drawWindow() {
		this.littleTurtle.drawRectangle(1, 1);
		this.littleTurtle.stepForward(1);
		this.littleTurtle.drawRectangle(1, 1);
		this.littleTurtle.turnRight(90.0);
		this.littleTurtle.stepForward(1);
		this.littleTurtle.turnLeft(90.0);
		this.littleTurtle.drawRectangle(1, 1);
		this.littleTurtle.turnRight(180.0);
		this.littleTurtle.stepForward(1);
		this.littleTurtle.turnLeft(180.0);
		this.littleTurtle.drawRectangle(1, 1);
	}
}