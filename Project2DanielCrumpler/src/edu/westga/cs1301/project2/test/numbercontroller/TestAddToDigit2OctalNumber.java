package edu.westga.cs1301.project2.test.numbercontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controller.NumberController;
import edu.westga.cs1301.project2.model.OctalNumber;

/**
 * Tests to confirm correct functionality of adding to the
 * 	octal number's middle digit
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestAddToDigit2OctalNumber {

	@Test
	public void testShouldNotAllowAddingNegativeNumber() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
	
		// Act & Assert: call addToDigit2 with a negative value
		// and assert it throws an exception
		assertThrows(IllegalArgumentException.class, () -> {
			theController.addToDigit2(-1);
		});
	}
	
	@Test
	public void testShouldAddZeroToDigit2() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit2(0);
		
		// Assert: that the number has the expected digit2
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(0, theNumber.getDigit2());
	}
	
	@Test
	public void testShouldAddOneToDigit2() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit2(1);
		
		// Assert: that the number has the expected digit2
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(1, theNumber.getDigit2());
	}

	@Test
	public void testShouldAddFourToDigit2() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit2(4);
		
		// Assert: that the number has the expected digit2
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(4, theNumber.getDigit2());
	}
	
	@Test
	public void testShouldAddTenToDigit2WithRollover() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit2(10);
		
		// Assert: that the number has the expected digits 1 and 2
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(2, theNumber.getDigit2());
		assertEquals(1, theNumber.getDigit1());
	}
	
	@Test
	public void testShouldAddTwentyToDigit2WithDigit1Rollover() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit2(20);
		
		// Assert: that the number has the expected digits 1 and 2
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(4, theNumber.getDigit2());
		assertEquals(2, theNumber.getDigit1());
	}
}