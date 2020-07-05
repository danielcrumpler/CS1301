package edu.westga.cs1301.project2.view;

import edu.westga.cs1301.project2.model.HexadecimalNumber;
import edu.westga.cs1301.project2.model.OctalNumber;

/**
 * This class can be used to format a number
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class NumberFormatter {
	String digit1 = "";
	String digit2 = "";
	String digit3 = "";

	/**
	 * Creates a new NumberFormatter
	 */
	public NumberFormatter() {

	}

	/**
	 * Displays the octal number such that it includes: * 0o as a prefix * includes
	 * all three digits, including leading 0's
	 * 
	 * @param theOctalNumber the octal number to be formatted
	 * @precondition theOctalNumber != null
	 * @return A formatted octal value
	 */
	public String formatOctalNumber(OctalNumber theOctalNumber) {
		if (theOctalNumber == null) {
			throw new IllegalArgumentException("theOctalNumber cannot be null");
		}
		return "0o" + theOctalNumber.getDigit1() + theOctalNumber.getDigit2() + theOctalNumber.getDigit3();
	}

	/**
	 * Displays the hexadecimal number such that it includes: * 0x as a prefix *
	 * includes all three digits, including leading 0's
	 * 
	 * @param theHexadecimalNumber the octal number to be formatted
	 * @precondition theHexadecimalNumber != null
	 * @return A formatted hexadecimal value
	 */
	public String formatHexadecimalNumber(HexadecimalNumber theHexadecimalNumber) {
		if (theHexadecimalNumber == null) {
			throw new IllegalArgumentException("theHexadecimalNumber cannot be null");
		}
		String A = "A";
		String B = "B";
		String C = "C";
		String D = "D";
		String E = "E";
		String F = "F";
		if (theHexadecimalNumber.getDigit1() == 10) {
			this.digit1 = A;
		} else if (theHexadecimalNumber.getDigit1() == 11) {
			this.digit1 = B;
		} else if (theHexadecimalNumber.getDigit1() == 12) {
			this.digit1 = C;
		} else if (theHexadecimalNumber.getDigit1() == 13) {
			this.digit1 = D;
		} else if (theHexadecimalNumber.getDigit1() == 14) {
			this.digit1 = E;
		} else if (theHexadecimalNumber.getDigit1() == 15) {
			this.digit1 = F;
		} else
			this.digit1 = String.valueOf(theHexadecimalNumber.getDigit1());

		// second digit
		if (theHexadecimalNumber.getDigit2() == 10) {
			this.digit2 = A;
		} else if (theHexadecimalNumber.getDigit2() == 11) {
			this.digit2 = B;
		} else if (theHexadecimalNumber.getDigit2() == 12) {
			this.digit2 = C;
		} else if (theHexadecimalNumber.getDigit2() == 13) {
			this.digit2 = D;
		} else if (theHexadecimalNumber.getDigit2() == 14) {
			this.digit2 = E;
		} else if (theHexadecimalNumber.getDigit2() == 15) {
			this.digit2 = F;
		} else
			this.digit2 = String.valueOf(theHexadecimalNumber.getDigit2());

		if (theHexadecimalNumber.getDigit3() == 10) {
			this.digit3 = A;
		} else if (theHexadecimalNumber.getDigit3() == 11) {
			this.digit3 = B;
		} else if (theHexadecimalNumber.getDigit3() == 12) {
			this.digit3 = C;
		} else if (theHexadecimalNumber.getDigit3() == 13) {
			this.digit3 = D;
		} else if (theHexadecimalNumber.getDigit3() == 14) {
			this.digit3 = E;
		} else if (theHexadecimalNumber.getDigit3() == 15) {
			this.digit3 = F;
		} else
			this.digit3 = String.valueOf(theHexadecimalNumber.getDigit3());
		return "0x" + this.digit1 + this.digit2 + this.digit3;
	}
}
