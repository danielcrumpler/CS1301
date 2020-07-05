package edu.westga.cs1301.lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.lab6.model.TimeCalculator;

/**
 * This class contains a variety of tests to confirm correct functionality of
 * the createTimeTable method
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestCreateTimeTable {

	@Test
	public void testShouldNotAllowNegativeFirstLapTime() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act & Assert: assert that calling createTimeTable with a
		// negative initial lap time throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			theCalculator.createTimeTable(-1, .10);
		});
	}

	@Test
	public void testShouldNotAllowZeroFirstLapTime() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act & Assert: assert that calling createTimeTable with a
		// zero first lap time throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			theCalculator.createTimeTable(0, .1);
		});
	}

	@Test
	public void testShouldCreateTimeTableWith50PercentSlowRate() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		String expected = "Lap Number, Lap Time\n" + "1, 100.0\n" + "2, 150.0\n" + "3, 225.0\n" + "4, 337.5\n"
				+ "5, 506.25\n";

		// Assert: assert that our expected value is equal to the actual result
		assertEquals(expected, theCalculator.createTimeTable(100, .5));
	}

	@Test
	public void testShouldCreateTimeTableWithZeroSlowRate() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		String expected = "Lap Number, Lap Time\n" + "1, 100.0\n" + "2, 100.0\n" + "3, 100.0\n" + "4, 100.0\n"
				+ "5, 100.0\n";

		// Assert: assert that our expected value is equal to the actual result
		assertEquals(expected, theCalculator.createTimeTable(100, 0));
	}
}
