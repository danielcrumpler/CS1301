package edu.westga.cs1301.lab2.view;

import java.lang.reflect.Field;

import acm.program.*;
import edu.westga.cs1301.lab2.Main;
import edu.westga.cs1301.lab2.controllers.ScribbleController;
import edu.westga.cs1301.lab2.model.Turtle;

/**
 * The GUI for the application.
 * 
 * @author CS1301
 * @version Spring 2019
 * 
 */
public class Gui extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = 750;
	public static final int APPLICATION_HEIGHT = 750;
	private static final long serialVersionUID = 1L;

	private ScribbleController drawer;

	/**
	 * Constructs and initializes the GUI.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Gui() {
		this.drawer = new ScribbleController();
	}

	/**
	 * Initializes the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void init() {
		this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

		Field[] fields = this.drawer.getClass().getDeclaredFields();

		for (Field currField : fields) {
			try {
				currField.setAccessible(true);
				Turtle turtle = (Turtle) currField.get(this.drawer);
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
		this.drawer.draw();
	}

}
