package edu.westga.cs1301.project2.test.numbercontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controller.NumberController;
import edu.westga.cs1301.project2.model.HexadecimalNumber;

/**
 * Tests to confirm correct functionality of adding to the hexadecimal number's
 * left-most digit
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestAddToDigit1HexadecimalNumber {

	@Test
	public void testShouldNotAllowAddingNegativeNumber() {
		// Arrange: create a controller
		NumberController theController = new NumberController();

		// Act & Assert: call addHours with a negative value
		// and assert it throws an exception
		assertThrows(IllegalArgumentException.class, () -> {
			theController.addToDigit1Hex(-1);
		});
	}

	@Test
	public void testShouldAddZeroToDigit1() {
		// Arrange: create a controller
		NumberController theController = new NumberController();

		// Act: call the method with an appropriate parameter
		theController.addToDigit1Hex(0);

		// Assert: that the number has the expected digit1
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(0, theNumber.getDigit1());
	}

	@Test
	public void testShouldAddOneToDigit1() {
		// Arrange: create a controller
		NumberController theController = new NumberController();

		// Act: call the method with an appropriate parameter
		theController.addToDigit1Hex(1);

		// Assert: that the number has the expected digit1
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(1, theNumber.getDigit1());
	}

	@Test
	public void testShouldAddFourToDigit1() {
		// Arrange: create a controller
		NumberController theController = new NumberController();

		// Act: call the method with an appropriate parameter
		theController.addToDigit1Hex(4);

		// Assert: that the number has the expected digit1
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(4, theNumber.getDigit1());
	}

	@Test
	public void testShouldAddTwentyToDigit1WithRollover() {
		// Arrange: create a controller
		NumberController theController = new NumberController();

		// Act: call the method with an appropriate parameter
		theController.addToDigit1Hex(20);

		// Assert: that the number has the expected digit1
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(4, theNumber.getDigit1());
	}
}
