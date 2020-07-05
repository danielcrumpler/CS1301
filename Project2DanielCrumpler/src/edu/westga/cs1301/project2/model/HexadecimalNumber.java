package edu.westga.cs1301.project2.model;

/**
 * Models a number in the Hexadecimal (base-16) number system.
 *
 * @author CS1301
 * @version Spring 2019
 *
 */
public class HexadecimalNumber {
	private int digit1;
	private int digit2;
	private int digit3;

	/**
	 * Creates an hexadecimal number at 0x000
	 * 
	 * @precondition none
	 * @postcondition getDigit1()==0 AND getDigit2()==0 AND getDigit3()==0
	 */
	public HexadecimalNumber() {
		this.digit1 = 0;
		this.digit2 = 0;
		this.digit3 = 0;
	}

	/**
	 * Creates an hexadecimal number at 0x first second third
	 * 
	 * @param first  The first digit in the hexadecimal number
	 * @param second The second digit in the hexadecimal number
	 * @param third  The third digit in the hexadecimal number
	 * 
	 * @precondition 0 <= first <= 15 0 <= second <= 15 0 <= third <= 15
	 * 
	 * @postcondition getDigit1()==first AND getDigit2()==second AND
	 *                getDigit3()==third
	 */
	public HexadecimalNumber(int first, int second) {
		if (first < 0 || first > 15) {
			throw new IllegalArgumentException("first number should be between 0 and 15");
		}
		if (second < 0 || second > 15) {
			throw new IllegalArgumentException("second number should be between 0 and 15");
		}
		this.digit1 = first;
		this.digit2 = second;
	}

	public HexadecimalNumber(int first, int second, int third) {
		if (first < 0 || first > 15) {
			throw new IllegalArgumentException("first number should be between 0 and 15");
		}
		if (second < 0 || second > 15) {
			throw new IllegalArgumentException("second number should be between 0 and 15");
		}
		if (third < 0 || third > 15) {
			throw new IllegalArgumentException("third number should be between 0 and 15");
		}
		this.digit1 = first;
		this.digit2 = second;
		this.digit3 = third;
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
	 * Sets the value of the first (left-most) digit
	 * 
	 * @precondition none
	 * @postcondition sets digit3 to number
	 * 
	 * @param number digit1 for hexadecimal
	 */
	public void setDigit1(int number) {
		this.digit1 = number;
	}

	/**
	 * Sets the value of the second (middle) digit
	 * 
	 * @precondition none
	 * @postcondition sets digit3 to number
	 * 
	 * @param number digit2 for hexadecimal
	 */
	public void setDigit2(int number) {
		this.digit2 = number;
	}

	/**
	 * Sets the value of the third (right-most) digit
	 * 
	 * @precondition none
	 * @postcondition sets digit3 to number
	 * 
	 * @param number digit3 for hexadecimal
	 */
	public void setDigit3(int number) {
		this.digit3 = number;
	}

	/**
	 * Increments digit1 (the left-most digit) by 1
	 * 
	 * @precondition none
	 * @postcondition getDigit1()==getDigit1()@prev+1 % 16
	 */
	public void incrementDigit1() {
		this.digit1 = (this.digit1 + 1) % 16;
	}

	/**
	 * Increments digit2 (the middle digit) by 1
	 * 
	 * @precondition none
	 * @postcondition getDigit2()==getDigit2()@prev+1 % 16
	 */
	public void incrementDigit2() {
		this.digit2 = (this.digit2 + 1) % 16;
	}

	/**
	 * Increments digit3 (the right-most digit) by 1
	 * 
	 * @precondition none
	 * @postcondition getDigit3()==getDigit3()@prev+1 % 16
	 */
	public void incrementDigit3() {
		this.digit3 = (this.digit3 + 1) % 16;
	}

	/**
	 * Adds Two Hexadecimals together
	 * 
	 * @precondition none
	 * @postcondition two hexadecimals are added together
	 * @param otherHexadecimal
	 */
	public void addHexadecimal(HexadecimalNumber otherHexadecimal) {
		this.digit1 += otherHexadecimal.getDigit1();
		this.digit2 += otherHexadecimal.getDigit2();
		if (this.digit2 >= 16) {
			this.digit1 += 1;
			this.digit2 %= 16;
		}
		this.digit3 += otherHexadecimal.getDigit3();
		if (this.digit3 + 1 >= 16) {
			this.digit2 += 1;
			this.digit3 %= 16;
			if (this.digit2 + 1 >= 16) {
				this.digit1 += 1;
				this.digit2 %= 16;
			}
		}
	}

	/**
	 * Multiplies Two Hexadecimals together
	 * 
	 * @precondition none
	 * @postcondition two hexadecimals are multiplied together
	 * @param otherHexadecimal
	 */
	public void multiplyHexadecimal(HexadecimalNumber otherHexadecimal) {
		this.digit1 *= otherHexadecimal.getDigit1();
		this.digit2 *= otherHexadecimal.getDigit2();
		if (this.digit2 >= 16) {
			this.digit1 += this.digit2 / 16;
			this.digit2 %= 16;
		}
		this.digit3 *= otherHexadecimal.getDigit3();
		if (this.digit3 >= 16) {
			this.digit2 += this.digit3 / 16;
			this.digit3 %= 16;
			if (this.digit2 >= 16) {
				this.digit1 += this.digit2 / 16;
				this.digit2 %= 16;
			}
		}
	}
}
