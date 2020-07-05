package edu.westga.cs1301.project2.test.numbercontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controller.NumberController;
import edu.westga.cs1301.project2.model.HexadecimalNumber;

/**
 * Tests to confirm correct functionality of adding to the
 * 	hexadecimal number's right-most digit
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestAddToDigit3HexadecimalNumber {

	@Test
	public void testShouldNotAllowAddingNegativeNumber() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act & Assert: call addToDigit3Hex with a negative value
		// and assert it throws an exception
		assertThrows(IllegalArgumentException.class, () -> {
			theController.addToDigit3Hex(-1);
		});
	}
	
	@Test
	public void testShouldAddZeroToDigit3() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3Hex(0);
		
		// Assert: that the number has the expected digit3
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(0, theNumber.getDigit3());
	}
	
	@Test
	public void testShouldAddOneToDigit3() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3Hex(1);
		
		// Assert: that the number has the expected number of hours
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(1, theNumber.getDigit3());
	}

	@Test
	public void testShouldAddFourToDigit3() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3Hex(4);
		
		// Assert: that the number has the expected number of hours
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(4, theNumber.getDigit3());
	}
	
	@Test
	public void testShouldAddTenToDigit3WithRolloverOnDigit2() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3Hex(10);
		
		// Assert: that the number has the expected number of digits
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(10, theNumber.getDigit3());
		assertEquals(1, theNumber.getDigit2());
	}
	
	@Test
	public void testShouldAddTwentyToDigit3WithDigit2Rollover() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3Hex(20);
		
		// Assert: that the number has the expected number of digits
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(4, theNumber.getDigit3());
		assertEquals(1, theNumber.getDigit2());
	}

	@Test
	public void testShouldAddOneHunderToDigit3WithDigit2AndDigit1Rollover() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3Hex(300);
		
		// Assert: that the number has the expected number of digits
		HexadecimalNumber theNumber = theController.getHexadecimalNumber();
		assertEquals(12, theNumber.getDigit3());
		assertEquals(3, theNumber.getDigit2());
		assertEquals(1, theNumber.getDigit1());
	}
}