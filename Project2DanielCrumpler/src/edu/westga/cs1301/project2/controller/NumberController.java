package edu.westga.cs1301.project2.controller;

import edu.westga.cs1301.project2.model.HexadecimalNumber;
import edu.westga.cs1301.project2.model.OctalNumber;

/**
 * Controller for the number application
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class NumberController {
	private OctalNumber octalNumber;
	private HexadecimalNumber hexadecimalNumber;

	/**
	 * Creates a new NumberController containing an OctalNumber
	 * 
	 * @precondition none
	 * @postcondition getOctalNumber().getDigit1()==0 AND
	 *                getOctalNumber().getDigit2()==0 AND
	 *                getOctalNumber().getDigit3()==0
	 */
	public NumberController() {
		OctalNumber octalNumber = new OctalNumber();
		this.octalNumber = octalNumber;
		HexadecimalNumber hexadecimalNumber = new HexadecimalNumber();
		this.hexadecimalNumber = hexadecimalNumber;
	}

	/**
	 * Gets the OctalNumber object
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the OctalNumber object
	 */
	public OctalNumber getOctalNumber() {
		return this.octalNumber;
	}

	/**
	 * Gets the HexadecimalNumber object
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the HexadecimalNumber object
	 */
	public HexadecimalNumber getHexadecimalNumber() {
		return this.hexadecimalNumber;
	}

	/**
	 * Adds the given number to the left-most digit
	 * 
	 * @precondition number >= 0
	 * @postcondition getOctalNumber.getDigit1() ==
	 *                getOctalNumber.getDigit1()@prev+number % 8
	 * 
	 * @param number number to be added to the leftmost digit
	 */
	public void addToDigit1(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be >= 0.");
		}
		for (int i = 0; i < number; i++) {
			this.octalNumber.incrementDigit1();
		}
	}

	/**
	 * Adds the given number to the middle digit, incrementing the left-most digit
	 * as needed
	 * 
	 * @param number number to be added to the middle digit
	 * @precondition number >= 0
	 * @postcondition getOctalNumber.getDigit2() ==
	 *                getOctalNumber.getDigit2()@prev+number % 8
	 */
	public void addToDigit2(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be >= 0.");
		}
		for (int i = 0; i < number; i++) {
			if (this.octalNumber.getDigit2() + 1 == 8) {
				this.octalNumber.incrementDigit1();
			}
			this.octalNumber.incrementDigit2();
		}
	}

	/**
	 * Adds the given number to the right-most digit, incrementing the middle digit
	 * as needed
	 * 
	 * @param number number to be added to the right-most digit
	 * @precondition number >= 0
	 * @postcondition getOctalNumber.getDigit3() ==
	 *                getOctalNumber.getDigit3()@prev+number % 8
	 */
	public void addToDigit3(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be >= 0.");
		}
		for (int i = 0; i < number; i++) {
			if (this.octalNumber.getDigit3() + 1 == 8) {
				this.octalNumber.incrementDigit2();
				if (this.octalNumber.getDigit2() + 1 == 8) {
					this.octalNumber.incrementDigit1();
				}
			}
			this.octalNumber.incrementDigit3();
		}
	}

	/**
	 * Adds the given number to the left-most digit
	 * 
	 * @precondition number >= 0
	 * @postcondition getHexadecimalNumber.getDigit1() ==
	 *                getOctalNumber.getDigit1()@prev+number % 16
	 * 
	 * @param number number to be added to the leftmost digit
	 */
	public void addToDigit1Hex(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be >= 0.");
		}
		for (int i = 0; i < number; i++) {
			this.hexadecimalNumber.incrementDigit1();
		}
	}

	/**
	 * Adds the given number to the middle digit, incrementing the left-most digit
	 * as needed
	 * 
	 * @param number number to be added to the middle digit
	 * @precondition number >= 0
	 * @postcondition getOctalNumber.getDigit2() ==
	 *                getOctalNumber.getDigit2()@prev+number % 16
	 */
	public void addToDigit2Hex(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be >= 0.");
		}
		for (int i = 0; i < number; i++) {
			if (this.hexadecimalNumber.getDigit2() + 1 == 16) {
				this.hexadecimalNumber.incrementDigit1();
			}
			this.hexadecimalNumber.incrementDigit2();
		}
	}

	/**
	 * Adds the given number to the right-most digit, incrementing the middle digit
	 * as needed
	 * 
	 * @param number number to be added to the right-most digit
	 * @precondition number >= 0
	 * @postcondition getOctalNumber.getDigit3() ==
	 *                getOctalNumber.getDigit3()@prev+number % 16
	 */
	public void addToDigit3Hex(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be >= 0.");
		}
		for (int i = 0; i < number; i++) {
			if (this.hexadecimalNumber.getDigit3() + 1 == 8) {
				this.hexadecimalNumber.incrementDigit2();
				if (this.hexadecimalNumber.getDigit2() + 1 == 8) {
					this.hexadecimalNumber.incrementDigit1();
				}
			}
			this.hexadecimalNumber.incrementDigit3();
		}
	}
}
