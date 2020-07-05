package edu.westga.cs1301.project2.test.numberformatteroctal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.OctalNumber;
import edu.westga.cs1301.project2.view.NumberFormatter;

/**
 * Tests to confirm correct functionality of the 
 * 	NumberFormatter::formatOctalNumber method
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestGetFormattedOctalNumber {

	@Test
	public void testThrowsExceptionForNullParameter() {
		// Arrange: create a NumberFormatter object
		NumberFormatter theFormatter = new NumberFormatter();
		
		// Arrange, Act & Assert: assert that calling formatOctalNumber and passing it
		//		null throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			String result = theFormatter.formatOctalNumber(null);
		});
	}
		
	@Test
	public void testLowestOctalValue() {
		// Arrange: create a NumberFormatter object
		NumberFormatter theFormatter = new NumberFormatter();
		OctalNumber theNumber = new OctalNumber();
		
		// Arrange: call formatOctalNumber
		String actual = theFormatter.formatOctalNumber(theNumber);
		
		// Assert: that the number has been properly formatted
		assertEquals("0o000", actual);
	}

	@Test
	public void testHighestOctalValue() {
		// Arrange: create a NumberFormatter object
		NumberFormatter theFormatter = new NumberFormatter();
		OctalNumber theNumber = new OctalNumber(7, 7, 7);
		
		// Arrange: call formatOctalNumber
		String actual = theFormatter.formatOctalNumber(theNumber);
		
		// Assert: that the number has been properly formatted
		assertEquals("0o777", actual);
	}

	@Test
	public void testMiddleOctalValue() {
		// Arrange: create a NumberFormatter object
		NumberFormatter theFormatter = new NumberFormatter();
		OctalNumber theNumber = new OctalNumber(3, 4, 5);
		
		// Arrange: call formatOctalNumber
		String actual = theFormatter.formatOctalNumber(theNumber);
		
		// Assert: that the number has been properly formatted
		assertEquals("0o345", actual);
	}
}