package edu.westga.cs1301.lab2.controllers;

import edu.westga.cs1301.lab2.model.Turtle;

/**
 * Uses Turtle objects to draw on the screen.
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class ScribbleController {
	//Small Turtle
	private Turtle turtle1;
	//Big Turtle
	private Turtle turtle2;
	//TODO declare two turtle fields to use for drawing

	/**
	 * Creates and initializes a new TurtleController object.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public ScribbleController() {
		//TODO initialize all fields
		this.turtle1 = new Turtle();
		this.turtle2 = new Turtle();
	}

	/**
	 * Draws a figure on the screen using turtle objects.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void draw() {
		//TODO add code to draw the maze
		//Get to Starting Location for First Letter (C)
		this.turtle1.decreaseTurtleSizeBy10();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		//Drawing the First Letter (C)
		this.turtle1.lowerTail();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.raiseTail();
		//Get to Starting Location for Second Letter (R)
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		//Drawing the Second Letter (R)
		this.turtle1.lowerTail();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.stepForward();
		this.turtle1.turnRight45();
		this.turtle1.increaseTurtleSizeBy10();
		this.turtle1.increaseTurtleSizeBy10();
		this.turtle1.stepForward();
		this.turtle1.decreaseTurtleSizeBy10();
		this.turtle1.decreaseTurtleSizeBy10();
		this.turtle1.raiseTail();
		//Get to Starting Location for Third Letter (U)
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.turnRight45();
		this.turtle1.increaseTurtleSizeBy10();
		this.turtle1.increaseTurtleSizeBy10();
		this.turtle1.stepForward();
		this.turtle1.decreaseTurtleSizeBy10();
		this.turtle1.decreaseTurtleSizeBy10();
		this.turtle1.turnLeft45();
		this.turtle1.stepForward();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		//Drawing the Third Letter (U)
		this.turtle1.lowerTail();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.turnLeft45();
		this.turtle1.turnLeft45();
		this.turtle1.stepForward();
		this.turtle1.stepForward();
		this.turtle1.raiseTail();
		//Get to Starting Location for Surrounding Box
		this.turtle2.increaseTurtleSizeBy10();
		this.turtle2.increaseTurtleSizeBy10();
		this.turtle2.increaseTurtleSizeBy10();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.turnRight45();
		this.turtle2.turnRight45();
		this.turtle2.stepForward();
		this.turtle2.stepForward();		
		this.turtle2.turnLeft45();
		this.turtle2.turnLeft45();
		//Drawing the Surrounding Box
		this.turtle2.lowerTail();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.turnRight45();
		this.turtle2.turnRight45();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.turnRight45();
		this.turtle2.turnRight45();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.turnRight45();
		this.turtle2.turnRight45();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.stepForward();
		this.turtle2.raiseTail(); 
	} 
}
		