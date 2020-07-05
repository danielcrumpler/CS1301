package edu.westga.cs1301.lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.lab6.model.TimeCalculator;

/**
 * This class contains a variety of tests to confirm correct functionality of
 * the getTimeBreakdown method
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestGetTimeBreakdown {

	@Test
	public void testShouldNotAllowNegativeSeconds() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act & Assert: assert that calling getTimeBreakdown with a
		// negative value throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			theCalculator.getTimeBreakdown(-1);
		});
	}

	@Test
	public void testShouldHaveZeroForHoursMinutesAndSeconds() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		String actualResult = theCalculator.getTimeBreakdown(0);

		// Assert: assert that our expected value is equal to the actual result
		assertEquals("0:0:0", actualResult);
	}

	@Test
	public void testShouldProduce3Hours() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		String actualResult = theCalculator.getTimeBreakdown(10800);

		// Assert: assert that our expected value is equal to the actual result
		assertEquals("3:0:0", actualResult);
	}

	@Test
	public void testShouldProduce2Hours25Minutes() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		String actualResult = theCalculator.getTimeBreakdown(8700);

		// Assert: assert that our expected value is equal to the actual result
		assertEquals("2:25:0", actualResult);
	}

	@Test
	public void testShouldProduce3Hours25MinutesAnd45Seconds() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		String actualResult = theCalculator.getTimeBreakdown(12345);

		// Assert: assert that our expected value is equal to the actual result
		assertEquals("3:25:45", actualResult);
	}
}
