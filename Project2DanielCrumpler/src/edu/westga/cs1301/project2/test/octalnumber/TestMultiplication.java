package edu.westga.cs1301.project2.test.octalnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1301.project2.controller.NumberController;
import edu.westga.cs1301.project2.model.OctalNumber;

/**
 * Tests to confirm correct functionality of the 
 * 	OctalNumber::multiplyOctal() method
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestMultiplication {

	@Test
	public void testShouldMultiplyOctalsToEqualZero() {
		// Arrange: create two OctalNumber with the appropriate digits
		OctalNumber firstNumber = new OctalNumber(0, 0, 0);
		OctalNumber secondNumber = new OctalNumber(0, 0, 0);
		
		// Act: multiply the octals
		firstNumber.multiplyOctal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}
	
	@Test
	public void testShouldAMultiplyOctalsToEqualDigit1() {
		// Arrange: create two OctalNumber with the appropriate digits
		OctalNumber firstNumber = new OctalNumber(2, 0, 0);
		OctalNumber secondNumber = new OctalNumber(3, 0, 0);
		
		// Act: multiply the octals
		firstNumber.multiplyOctal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(6, firstNumber.getDigit1());
	}
	
	@Test
	public void testShouldAMultiplyOctalsToEqualDigit2() {
		// Arrange: create two OctalNumber with the appropriate digits
		OctalNumber firstNumber = new OctalNumber(0, 2, 0);
		OctalNumber secondNumber = new OctalNumber(0, 3, 0);
		
		// Act: multiply the octals
		firstNumber.multiplyOctal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(6, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}
	
	@Test
	public void testShouldMultiplyOctalsToEqualDigit3() {
		// Arrange: create two OctalNumber with the appropriate digits
		OctalNumber firstNumber = new OctalNumber(0, 0, 2);
		OctalNumber secondNumber = new OctalNumber(0, 0, 3);
		
		// Act: multiply the octals
		firstNumber.multiplyOctal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(6, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}
	
	@Test
	public void testShouldMultiplyOctalsToEqualWithRollovers() {
		// Arrange: create two OctalNumber with the appropriate digits
		OctalNumber firstNumber = new OctalNumber(1, 5, 1);
		OctalNumber secondNumber = new OctalNumber(5, 5, 0);
		
		// Act: multiply the octals
		firstNumber.multiplyOctal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(1, firstNumber.getDigit2());
		assertEquals(8, firstNumber.getDigit1());
	}
}
