package edu.westga.cs1301.project2.test.hexadecimalnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.HexadecimalNumber;

/**
 * Tests to confirm correct functionality of the HexadecimalNumber class
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestConstructorWith2Parameters {

	@Test
	public void testShouldCreateWithZeroParamConstructor() {
		// Arrange & Act: create the HexadecimalNumber object
		HexadecimalNumber theNumber = new HexadecimalNumber();

		// Assert: that its initial values are correct
		assertEquals(0, theNumber.getDigit1());
		assertEquals(0, theNumber.getDigit2());
	}

	@Test
	public void testShouldNotAllowNegativeDigit1() {
		// Arrange, Act, and Assert: create the HexadecimalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new HexadecimalNumber(-1, 0);
		});
	}

	@Test
	public void testShouldNotAllowDigit1Over15() {
		// Arrange, Act, and Assert: create the HexadecimalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new HexadecimalNumber(16, 0);
		});
	}

	@Test
	public void testShouldNotAllowNegativeDigit2() {
		// Arrange, Act, and Assert: create the HexadecimalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new HexadecimalNumber(0, -1);
		});
	}

	@Test
	public void testShouldNotAllowDigit2Over15() {
		// Arrange, Act, and Assert: create the HexadecimalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new HexadecimalNumber(0, 16);
		});
	}

	@Test
	public void testShouldCreateValidHexadecimalNumber() {
		// Arrange & Act: create the Hexadecimal object
		HexadecimalNumber theNumber = new HexadecimalNumber(2, 3);

		// Assert: that its initial values are correct
		assertEquals(2, theNumber.getDigit1());
		assertEquals(3, theNumber.getDigit2());
	}
}
