package edu.westga.cs1301.project2.test.octalnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.OctalNumber;

/**
 * Tests to confirm correct functionality of the 
 * 	OctalNumber::incrementDigit2() method
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestIncrementDigit2 {

	@Test
	public void testShouldIncrementDigit2From0() {
		// Arrange: create an OctalNumber with the appropriate middle digit
		OctalNumber theNumber = new OctalNumber(0, 0);
		
		// Act: increment the middle digit
		theNumber.incrementDigit2();
		
		// Assert: that the actual value matches the expected value
		assertEquals(1, theNumber.getDigit2());
	}

	@Test
	public void testShouldIncrementDigit2From4() {
		// Arrange: create an OctalNumber with the appropriate middle digit
		OctalNumber theNumber = new OctalNumber(0, 4);
		
		// Act: increment the middle digit
		theNumber.incrementDigit2();
		
		// Assert: that the actual value matches the expected value
		assertEquals(5, theNumber.getDigit2());
	}

	@Test
	public void testShouldIncrementDigit2From7() {
		// Arrange: create an OctalNumber with the appropriate middle digit
		OctalNumber theNumber = new OctalNumber(0, 7);
		
		// Act: increment the middle digit
		theNumber.incrementDigit2();
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, theNumber.getDigit2());
	}
	
	@Test
	public void testShouldIncrementDigit2SeveralTimes() {
		// Arrange: create an OctalNumber with the appropriate middle digit
		OctalNumber theNumber = new OctalNumber(0, 0);
		
		// Act: increment the middle digit
		for (int counter = 0; counter < 10; counter++) {
			theNumber.incrementDigit2();
		}
		
		// Assert: that the actual value matches the expected value
		assertEquals(2, theNumber.getDigit2());
	}
}