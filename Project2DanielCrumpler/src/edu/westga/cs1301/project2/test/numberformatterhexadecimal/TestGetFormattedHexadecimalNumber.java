package edu.westga.cs1301.project2.test.numberformatterhexadecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.HexadecimalNumber;
import edu.westga.cs1301.project2.view.NumberFormatter;

/**
 * Tests to confirm correct functionality of the
 * NumberFormatter::formatHexadecimalNumber method
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestGetFormattedHexadecimalNumber {

	@Test
	public void testThrowsExceptionForNullParameter() {
		// Arrange: create a NumberFormatter object
		NumberFormatter theFormatter = new NumberFormatter();

		// Arrange, Act & Assert: assert that calling formatHexadecimalNumber and
		// passing it
		// null throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			String result = theFormatter.formatHexadecimalNumber(null);
		});
	}

	@Test
	public void testLowestHexadecimalValue() {
		// Arrange: create a NumberFormatter object
		NumberFormatter theFormatter = new NumberFormatter();
		HexadecimalNumber theNumber = new HexadecimalNumber();

		// Arrange: call formatHexadecimalNumber
		String actual = theFormatter.formatHexadecimalNumber(theNumber);

		// Assert: that the number has been properly formatted
		assertEquals("0x000", actual);
	}

	@Test
	public void testHighestHexadecimalValue() {
		// Arrange: create a NumberFormatter object
		NumberFormatter theFormatter = new NumberFormatter();
		HexadecimalNumber theNumber = new HexadecimalNumber(15, 15, 15);

		// Arrange: call formatHexadecimalNumber
		String actual = theFormatter.formatHexadecimalNumber(theNumber);

		// Assert: that the number has been properly formatted
		assertEquals("0xFFF", actual);
	}

	@Test
	public void testMiddleHexadecimalValue() {
		// Arrange: create a NumberFormatter object
		NumberFormatter theFormatter = new NumberFormatter();
		HexadecimalNumber theNumber = new HexadecimalNumber(5, 10, 15);

		// Arrange: call formatHexadecimalNumber
		String actual = theFormatter.formatHexadecimalNumber(theNumber);

		// Assert: that the number has been properly formatted
		assertEquals("0x5AF", actual);
	}
}