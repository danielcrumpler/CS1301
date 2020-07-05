package edu.westga.exceptionslecture.model;

public class DivisionFormatter {

	public DivisionFormatter() {

	}

	/**
	 * Divides one number by another and returns a formatted string showing the
	 * quotient and remainder.
	 * 
	 * E.g., divide(5,2) will return "2 Rem 1"
	 * 
	 * @param dividend
	 * @param divisor
	 * @return a nicely-formatted division result, including the remainder
	 */
	public String divide(int dividend, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException ("Can't divide by zero.");
		}	
		int quotient = dividend / divisor;
		int remainder = dividend % divisor;
		return quotient + " Rem " + remainder;	
		}
}
