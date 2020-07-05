package edu.westga.cs1301.project2.test.hexadecimalnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1301.project2.controller.NumberController;
import edu.westga.cs1301.project2.model.HexadecimalNumber;

/**
 * Tests to confirm correct functionality of the
 * HexadecimalNumber::multiplyHexadecimal() method
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestMultiplication {

	@Test
	public void testShouldMultiplyHexadecimalsToEqualZero() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(0, 0, 0);
		HexadecimalNumber secondNumber = new HexadecimalNumber(0, 0, 0);

		// Act: multiply the hexadecimals
		firstNumber.multiplyHexadecimal(secondNumber);

		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}

	@Test
	public void testShouldAMultiplyHexadecimalsToEqualDigit1() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(2, 0, 0);
		HexadecimalNumber secondNumber = new HexadecimalNumber(3, 0, 0);

		// Act: multiply the hexadecimals
		firstNumber.multiplyHexadecimal(secondNumber);

		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(6, firstNumber.getDigit1());
	}

	@Test
	public void testShouldAMultiplyHexadecimalsToEqualDigit2() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(0, 2, 0);
		HexadecimalNumber secondNumber = new HexadecimalNumber(0, 3, 0);

		// Act: multiply the hexadecimals
		firstNumber.multiplyHexadecimal(secondNumber);

		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(6, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}

	@Test
	public void testShouldMultiplyHexadecimalsToEqualDigit3() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(0, 0, 2);
		HexadecimalNumber secondNumber = new HexadecimalNumber(0, 0, 3);

		// Act: multiply the hexadecimals
		firstNumber.multiplyHexadecimal(secondNumber);

		// Assert: that the actual value matches the expected value
		assertEquals(6, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}

	@Test
	public void testShouldMultiplyHexadecimalsToEqualWithRollovers() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(1, 5, 1);
		HexadecimalNumber secondNumber = new HexadecimalNumber(5, 5, 0);

		// Act: multiply the hexadecimals
		firstNumber.multiplyHexadecimal(secondNumber);

		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(9, firstNumber.getDigit2());
		assertEquals(6, firstNumber.getDigit1());
	}
}
