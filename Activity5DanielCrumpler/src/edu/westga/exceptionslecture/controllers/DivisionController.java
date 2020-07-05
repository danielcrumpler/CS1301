package edu.westga.exceptionslecture.controllers;

import edu.westga.exceptionslecture.model.DivisionFormatter;

public class DivisionController {

	private DivisionFormatter formatter;
	
	public DivisionController() {
		
		this.formatter = new DivisionFormatter();
		
		/*
		 * Note: Eclipse's console receives buffered stdout and stderr streams, so the following
		 * line is required to ensure stdout messages and stderr messages occur in program order.
		 * Without it, one could print before (or interspersed with) the other, and it would
		 * happen unpredictably.
		 * 
		 * We lose some color-coding on stderr, however :(
		 */
		System.setErr(System.out);
	}
	
	public void run() {
		String firstResult = formatter.divide(5, 2);
		System.out.println("5 / 2 = " + firstResult);
		
		String secondResult = formatter.divide(2, 5);
		System.out.println("2 / 5 = " + secondResult);
		
		String thirdResult = formatter.divide(23, 0);
		System.out.println("23 / 0 = " + thirdResult);
	}
}
