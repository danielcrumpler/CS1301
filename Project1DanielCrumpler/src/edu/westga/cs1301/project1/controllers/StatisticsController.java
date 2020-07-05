package edu.westga.cs1301.project1.controllers;

import edu.westga.cs1301.project1.model.Turtle;
import edu.westga.cs1301.project1.utils.Statistics;

/**
 * Computes and displays basic statistics about the turtles
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class StatisticsController {

	private Turtle turtle1;
	private Turtle turtle2;

	/**
	 * Creates a statistics controller
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public StatisticsController() {
		this.turtle1 = null;
		this.turtle2 = null;
	}

	/**
	 * Creates a statistics controller that will use the two specified turtles.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public StatisticsController(Turtle turtle1, Turtle turtle2) {
		this.turtle1 = turtle1;
		this.turtle2 = turtle2;
	}

	/**
	 * Displays summary stats about the turtles used to draw.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void displaySummaryStats() {
		System.out.println("Turtles stats ");
		System.out.println();
		System.out.println("Steps taken by:");
		int stepsByTurtle1 = this.turtle1.getStepsForward();
		int stepsByTurtle2 = this.turtle2.getStepsForward();
		System.out.println("First turtle: " + stepsByTurtle1);
		System.out.println("Second turtle: " + stepsByTurtle2);
		Statistics stats = new Statistics();
		double average = stats.computeAverage(stepsByTurtle1, stepsByTurtle2);
		System.out.println("Average steps taken by both turtles: " + average);
		System.out.println();
		System.out.println("Distance traveled by:");
		int sizeOfTurtle1 = this.turtle1.getTurtleSize();
		int sizeOfTurtle2 = this.turtle2.getTurtleSize();
		System.out.println("First turtle: " + stepsByTurtle1 * sizeOfTurtle1);
		System.out.println("Second turtle: " + stepsByTurtle2 * sizeOfTurtle2);
	}

}
