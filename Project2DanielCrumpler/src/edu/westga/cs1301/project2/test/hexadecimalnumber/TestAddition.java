package edu.westga.cs1301.project2.test.hexadecimalnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1301.project2.controller.NumberController;
import edu.westga.cs1301.project2.model.HexadecimalNumber;

/**
 * Tests to confirm correct functionality of the 
 * 	HexadecimalNumber::addHexadecimal() method
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestAddition {

	@Test
	public void testShouldAddHexadecimalsToEqualZero() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(0, 0, 0);
		HexadecimalNumber secondNumber = new HexadecimalNumber(0, 0, 0);
		
		// Act: add the hexadecimals
		firstNumber.addHexadecimal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}
	
	@Test
	public void testShouldAddHexadecimalsToEqualDigit1() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(2, 0, 0);
		HexadecimalNumber secondNumber = new HexadecimalNumber(7, 0, 0);
		
		// Act: add the hexadecimals
		firstNumber.addHexadecimal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(9, firstNumber.getDigit1());
	}
	
	@Test
	public void testShouldAddHexadecimalsToEqualDigit2() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(0, 2, 0);
		HexadecimalNumber secondNumber = new HexadecimalNumber(0, 7, 0);
		
		// Act: add the hexadecimals
		firstNumber.addHexadecimal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(0, firstNumber.getDigit3());
		assertEquals(9, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}
	
	@Test
	public void testShouldAddHexadecimalsToEqualDigit3() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(0, 0, 2);
		HexadecimalNumber secondNumber = new HexadecimalNumber(0, 0, 7);
		
		// Act: add the hexadecimals
		firstNumber.addHexadecimal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(9, firstNumber.getDigit3());
		assertEquals(0, firstNumber.getDigit2());
		assertEquals(0, firstNumber.getDigit1());
	}
	
	@Test
	public void testShouldAddHexadecimalsToEqualWithRollovers() {
		// Arrange: create two HexadecimalNumber with the appropriate digits
		HexadecimalNumber firstNumber = new HexadecimalNumber(1, 5, 1);
		HexadecimalNumber secondNumber = new HexadecimalNumber(5, 5, 0);
		
		// Act: add the hexadecimals
		firstNumber.addHexadecimal(secondNumber);
		
		// Assert: that the actual value matches the expected value
		assertEquals(1, firstNumber.getDigit3());
		assertEquals(10, firstNumber.getDigit2());
		assertEquals(6, firstNumber.getDigit1());
	}
}
