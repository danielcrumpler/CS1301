package edu.westga.cs1301.project2.test.numbercontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controller.NumberController;
import edu.westga.cs1301.project2.model.OctalNumber;

/**
 * Tests to confirm correct functionality of adding to the
 * 	octal number's right-most digit
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestAddToDigit3OctalNumber {

	@Test
	public void testShouldNotAllowAddingNegativeNumber() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act & Assert: call addToDigit3 with a negative value
		// and assert it throws an exception
		assertThrows(IllegalArgumentException.class, () -> {
			theController.addToDigit3(-1);
		});
	}
	
	@Test
	public void testShouldAddZeroToDigit3() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3(0);
		
		// Assert: that the number has the expected digit3
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(0, theNumber.getDigit3());
	}
	
	@Test
	public void testShouldAddOneToDigit3() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3(1);
		
		// Assert: that the number has the expected number of hours
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(1, theNumber.getDigit3());
	}

	@Test
	public void testShouldAddFourToDigit3() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3(4);
		
		// Assert: that the number has the expected number of hours
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(4, theNumber.getDigit3());
	}
	
	@Test
	public void testShouldAddTenToDigit3WithRolloverOnDigit2() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3(10);
		
		// Assert: that the number has the expected number of digits
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(2, theNumber.getDigit3());
		assertEquals(1, theNumber.getDigit2());
	}
	
	@Test
	public void testShouldAddTwentyToDigit3WithDigit2Rollover() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3(20);
		
		// Assert: that the number has the expected number of digits
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(4, theNumber.getDigit3());
		assertEquals(2, theNumber.getDigit2());
	}

	@Test
	public void testShouldAddOneHunderToDigit3WithDigit2AndDigit1Rollover() {
		// Arrange: create a controller
		NumberController theController = new NumberController();
		
		// Act: call the method with an appropriate parameter
		theController.addToDigit3(100);
		
		// Assert: that the number has the expected number of digits
		OctalNumber theNumber = theController.getOctalNumber();
		assertEquals(4, theNumber.getDigit3());
		assertEquals(4, theNumber.getDigit2());
		assertEquals(1, theNumber.getDigit1());
	}
}