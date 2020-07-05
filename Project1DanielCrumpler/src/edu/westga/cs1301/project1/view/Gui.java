package edu.westga.cs1301.project1.view;

import edu.westga.cs1301.project1.controllers.TurtleController;
import edu.westga.cs1301.project1.controllers.StatisticsController;
import edu.westga.cs1301.project1.model.Turtle;
import acm.program.*;

/**
 * The GUI for the application.
 * 
 * @author CS1301
 * @version Spring 2019
 * 
 */
public class Gui extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = 900;
	public static final int APPLICATION_HEIGHT = 900;
	private static final long serialVersionUID = 1L;

	private TurtleController sketchPad;
	private StatisticsController statsController;
	private Turtle turtle1;
	private Turtle turtle2;

	/**
	 * Constructs and initializes the GUI.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Gui() {
		this.turtle1 = new Turtle(60);
		this.turtle2 = new Turtle(30);
		this.sketchPad = new TurtleController(this.turtle1, this.turtle2);
		this.statsController = new StatisticsController(this.turtle1, this.turtle2);
	}

	/**
	 * Initializes the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void init() {
		this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		super.add(this.turtle1);
		super.add(this.turtle2);
	}

	/**
	 * Part of the execution cycle for the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void run() {
		this.sketchPad.draw();
		this.statsController.displaySummaryStats();
	}

}
