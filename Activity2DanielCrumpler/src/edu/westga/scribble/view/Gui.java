package edu.westga.scribble.view;

import edu.westga.scribble.controllers.Main;
import edu.westga.scribble.controllers.TurtleController;
import edu.westga.scribble.model.Turtle;

import java.lang.reflect.Field;

import acm.program.*;

/**
 * The GUI for the application.
 * 
 * @author CS 1301
 * @version Spring 2019
 * 
 */
public class Gui extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = Main.WINDOW_SIZE;
	public static final int APPLICATION_HEIGHT = Main.WINDOW_SIZE;
	private static final long serialVersionUID = 1L;

	private TurtleController scribblePad;

	/**
	 * Constructs and initializes the GUI.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Gui() {
		this.scribblePad = new TurtleController();
	}

	/**
	 * Initializes the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	@Override
	public void init() {
		this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

		Field[] fields = this.scribblePad.getClass().getDeclaredFields();

		for (Field currField : fields) {
			try {
				currField.setAccessible(true);
				Turtle turtle = (Turtle) currField.get(this.scribblePad);
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
	@Override
	public void run() {
		this.scribblePad.draw();
	}

}
