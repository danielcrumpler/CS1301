package edu.westga.cs1301.project2.test.hexadecimalnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.HexadecimalNumber;

/**
 * Tests to confirm correct functionality of the 
 * 	HexadecimalNumber::incrementDigit1() method
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestIncrementDigit1 {

	@Test
	public void testShouldIncrementDigit1From0() {
		// Arrange: create an HexadecimalNumber with the appropriate left-most digit
		HexadecimalNumber theNumber = new HexadecimalNumber(0, 0);
		
		// Act: increment the left-most digit
		theNumber.incrementDigit1();
		
		// Assert: that the actual value matches the expected value
		assertEquals(1, theNumber.getDigit1());
	}

	@Test
	public void testShouldIncrementDigit1From4() {
		// Arrange: create an HexadecimalNumber with the appropriate left-most digit
		HexadecimalNumber theNumber = new HexadecimalNumber(4, 0);
		
		// Act: increment the left-most digit
		theNumber.incrementDigit1();
		
		// Assert: that the actual value matches the expected value
		assertEquals(5, theNumber.getDigit1());
	}

	@Test
	public void testShouldIncrementDigit1From15() {
		// Arrange: create an HexadecimalNumber with the appropriate left-most digit
		HexadecimalNumber theNumber = new HexadecimalNumber(15, 0);
		
		// Act: increment the left-most digit
		theNumber.incrementDigit1();
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, theNumber.getDigit1());
	}
	
	@Test
	public void testShouldIncrementDigit1SeveralTimes() {
		// Arrange: create an HexadecimalNumber with the appropriate left-most digit
		HexadecimalNumber theNumber = new HexadecimalNumber(0, 0);
		
		// Act: increment the left-most digit
		for (int counter = 0; counter < 16; counter++) {
			theNumber.incrementDigit1();
		}
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, theNumber.getDigit1());
	}
}
