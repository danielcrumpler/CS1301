package edu.westga.cs1301.sketch.view;

import java.lang.reflect.Field;

import acm.program.*;
import edu.westga.cs1301.sketch.Main;
import edu.westga.cs1301.sketch.controllers.TurtleController;
import edu.westga.cs1301.sketch.model.Turtle;

/**
 * The GUI for the application.
 * 
 * @author CS 1301
 * @version Spring 2019
 * 
 */
public class Gui extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = 500;
	public static final int APPLICATION_HEIGHT = 500;
	private static final long serialVersionUID = 1L;

	private TurtleController sketchPad;

	/**
	 * Constructs and initializes the GUI.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Gui() {
		this.sketchPad = new TurtleController();
	}

	/**
	 * Initializes the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void init() {
		this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

		Field[] fields = this.sketchPad.getClass().getDeclaredFields();

		for (Field currField : fields) {
			try {
				currField.setAccessible(true);
				Turtle turtle = (Turtle) currField.get(this.sketchPad);
				super.add(turtle);
				currField.setAccessible(false);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Part of the execution cycle for the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void run() {
		this.sketchPad.draw();
	}

}
