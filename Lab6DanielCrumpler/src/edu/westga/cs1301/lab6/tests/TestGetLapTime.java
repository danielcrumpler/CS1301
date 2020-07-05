package edu.westga.cs1301.lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.lab6.model.TimeCalculator;

/**
 * This class contains a variety of tests to confirm correct functionality of
 * the getLapTime method
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestGetLapTime {

	@Test
	public void testShouldNotAllowNegativeFirstLapTime() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act & Assert: assert that calling getLapTime with a
		// negative initial lap time throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			theCalculator.getLapTime(-1, .10, 1);
		});
	}

	@Test
	public void testShouldNotAllowLapZero() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act & Assert: assert that calling getLapTime with a
		// zero lap number throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			theCalculator.getLapTime(1, .1, 0);
		});
	}

	@Test
	public void testShouldNotAllowNegativeLap() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act & Assert: assert that calling getLapTime with a
		// negative lap number throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			theCalculator.getLapTime(1, .1, -1);
		});
	}

	@Test
	public void testShouldNotAllowLapSix() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act & Assert: assert that calling getLapTime with a
		// lap number of 6 throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			theCalculator.getLapTime(1, .1, 6);
		});
	}

	@Test
	public void testShouldHaveSecondLapOf11Seconds() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		double actualResult = theCalculator.getLapTime(10, .1, 2);

		// Assert: assert that our expected value is equal to the actual result
		assertEquals(11.0, actualResult, 0.001);
	}

	@Test
	public void testShouldHaveThirdLapOf12Point1Seconds() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		double actualResult = theCalculator.getLapTime(10, .1, 3);

		// Assert: assert that our expected value is equal to the actual result
		assertEquals(12.1, actualResult, 0.001);
	}

	@Test
	public void testShouldHaveFourthLapOf13Point31Seconds() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		double actualResult = theCalculator.getLapTime(10, .1, 4);

		// Assert: assert that our expected value is equal to the actual result
		assertEquals(13.31, actualResult, 0.001);
	}

	@Test
	public void testShouldHaveFifthLapOf14Point641Seconds() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();

		// Act: call our method with proper parameter value for our test
		double actualResult = theCalculator.getLapTime(10, .1, 5);

		// Assert: assert that our expected value is equal to the actual result
		assertEquals(14.641, actualResult, 0.001);
	}
}
