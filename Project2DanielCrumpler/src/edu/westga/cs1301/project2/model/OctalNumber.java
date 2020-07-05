package edu.westga.cs1301.project2.model;

/**
 * Models a number in the Octal (base-8) number system.
 *
 * @author CS1301
 * @version Spring 2019
 *
 */
public class OctalNumber {
	private int digit1;
	private int digit2;
	private int digit3;

	/**
	 * Creates an octal number at 0o000
	 * 
	 * @precondition none
	 * @postcondition getDigit1()==0 AND getDigit2()==0 AND getDigit3()==0
	 */
	public OctalNumber() {
		this.digit1 = 0;
		this.digit2 = 0;
		this.digit3 = 0;
	}

	/**
	 * Creates an octal number at 0o first second third
	 * 
	 * @param first  The first digit in the octal number
	 * @param second The second digit in the octal number
	 * @param third  The third digit in the octal number
	 * 
	 * @precondition 0 <= first <= 7 0 <= second <= 7 0 <= third <= 7
	 * 
	 * @postcondition getDigit1()==first AND getDigit2()==second AND
	 *                getDigit3()==third
	 */
	public OctalNumber(int first, int second, int third) {
		if (first < 0 || first > 7) {
			throw new IllegalArgumentException("first number should be between 0 and 7");
		}
		if (second < 0 || second > 7) {
			throw new IllegalArgumentException("second number should be between 0 and 7");
		}
		if (third < 0 || third > 7) {
			throw new IllegalArgumentException("third number should be between 0 and 7");
		}

		this.digit1 = first;
		this.digit2 = second;
		this.digit3 = third;
	}

	public OctalNumber(int first, int second) {
		if (first < 0 || first > 7) {
			throw new IllegalArgumentException("first number should be between 0 and 7");
		}
		if (second < 0 || second > 7) {
			throw new IllegalArgumentException("second number should be between 0 and 7");
		}

		this.digit1 = first;
		this.digit2 = second;
	}

	/**
	 * Returns the value of the first (left-most) digit
	 * 
	 * @precondition none
	 * @return the value of the first (left-most) digit
	 */
	public int getDigit1() {
		return this.digit1;
	}

	/**
	 * Returns the value of the second (middle) digit
	 * 
	 * @precondition none
	 * @return the value of the second (middle) digit
	 */
	public int getDigit2() {
		return this.digit2;
	}

	/**
	 * Returns the value of the third (right-most) digit
	 * 
	 * @precondition none
	 * @return the value of the third (right-most) digit
	 */
	public int getDigit3() {
		return this.digit3;
	}

	/**
	 * Increments digit1 (the left-most digit) by 1
	 * 
	 * @precondition none
	 * @postcondition getDigit1()==getDigit1()@prev+1 % 8
	 */
	public void incrementDigit1() {
		this.digit1 = (this.digit1 + 1) % 8;
	}

	/**
	 * Increments digit2 (the middle digit) by 1
	 * 
	 * @precondition none
	 * @postcondition getDigit2()==getDigit2()@prev+1 % 8
	 */
	public void incrementDigit2() {
		this.digit2 = (this.digit2 + 1) % 8;
	}

	/**
	 * Increments digit3 (the right-most digit) by 1
	 * 
	 * @precondition none
	 * @postcondition getDigit3()==getDigit3()@prev+1 % 8
	 */
	public void incrementDigit3() {
		this.digit3 = (this.digit3 + 1) % 8;
	}

	/**
	 * Adds Two Octals together
	 * 
	 * @precondition none
	 * @postcondition two octals are added together
	 * 
	 * @param otherOctal
	 */
	public void addOctal(OctalNumber otherOctal) {
		this.digit1 += otherOctal.getDigit1();
		this.digit2 += otherOctal.getDigit2();
		if (this.digit2 >= 8) {
			this.digit1 += 1;
			this.digit2 %= 8;
		}
		this.digit3 += otherOctal.getDigit3();
		if (this.digit3 + 1 >= 8) {
			this.digit2 += 1;
			this.digit3 %= 8;
			if (this.digit2 + 1 >= 8) {
				this.digit1 += 1;
				this.digit2 %= 8;
			}
		}
	}

	/**
	 * Multiplies Two Octals together
	 * 
	 * @precondition none
	 * @postcondition two octals are multiplied together
	 * @param otherOctal
	 */
	public void multiplyOctal(OctalNumber otherOctal) {
		this.digit1 *= otherOctal.getDigit1();
		this.digit2 *= otherOctal.getDigit2();
		if (this.digit2 >= 8) {
			this.digit1 += this.digit2 / 8;
			this.digit2 %= 8;
		}
		this.digit3 *= otherOctal.getDigit3();
		if (this.digit3 >= 8) {
			this.digit2 += this.digit3 / 8;
			this.digit3 %= 8;
			if (this.digit2 >= 8) {
				this.digit1 += this.digit2 / 8;
				this.digit2 %= 8;
			}
		}
	}
}