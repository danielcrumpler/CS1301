package edu.westga.cs1301.project2.test.hexadecimalnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.HexadecimalNumber;

/**
 * Tests to confirm correct functionality of the 
 * 	HexadecimalNumber::incrementDigit3() method
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestIncrementDigit3 {

	@Test
	public void testShouldIncrementDigit3From0() {
		// Arrange: create an HexadecimalNumber with the appropriate right-most digit
		HexadecimalNumber theNumber = new HexadecimalNumber(0, 0, 0);
		
		// Act: increment the right-most digit
		theNumber.incrementDigit3();
		
		// Assert: that the actual value matches the expected value
		assertEquals(1, theNumber.getDigit3());
	}

	@Test
	public void testShouldIncrementDigit3From4() {
		// Arrange: create an HexadecimalNumber with the appropriate right-most digit
		HexadecimalNumber theNumber = new HexadecimalNumber(0, 0, 4);
		
		// Act: increment the right-most digit
		theNumber.incrementDigit3();
		
		// Assert: that the actual value matches the expected value
		assertEquals(5, theNumber.getDigit3());
	}

	@Test
	public void testShouldIncrementDigit3From15() {
		// Arrange: create an HexadecimalNumber with the appropriate right-most digit
		HexadecimalNumber theNumber = new HexadecimalNumber(0, 0, 15);
		
		// Act: increment the right-most digit
		theNumber.incrementDigit3();
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, theNumber.getDigit3());
	}
	
	@Test
	public void testShouldIncrementDigit3SeveralTimes() {
		// Arrange: create an HexadecimalNumber with the appropriate right-most digit
		HexadecimalNumber theNumber = new HexadecimalNumber(0, 0, 0);
		
		// Act: increment the right-most digit
		for (int counter = 0; counter < 18; counter++) {
			theNumber.incrementDigit3();
		}
		
		// Assert: that the actual value matches the expected value
		assertEquals(2, theNumber.getDigit3());
	}
}