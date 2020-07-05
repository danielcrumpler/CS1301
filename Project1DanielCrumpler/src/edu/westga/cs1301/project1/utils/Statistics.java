package edu.westga.cs1301.project1.utils;

/**
 * A class that helps with computing basic statistics
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class Statistics {

	/**
	 * Creates a statistics object
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Statistics() {

	}

	/**
	 * Computes and returns the average of two numbers.
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param value1 First value
	 * @param value2 Second value
	 * @return Average of first and second value
	 */
	public double computeAverage(int value1, int value2) {
		return (value1 + value2)/2.0;
	}
	
}
