package edu.westga.cs1301.lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1301.lab5.model.TimeCalculator;

/**
 * This class contains a variety of tests to confirm correct functionality
 *  of the getBiathlonAverage method
 *  
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestGetBiathlonAverage {

	@Test
	void testAverageWith2SkiersAndNoPenalties() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();
		
		// Act: call our method with proper parameter value for our test
		String actualResult = theCalculator.getBiathlonAverage(10000, 0, 2);
		
		// Assert: assert that our expected value is equal to the actual result
		assertEquals("1:23:20", actualResult);
	}

	@Test
	void testAverageWith2SkiersAnd4Penalties() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();
		
		// Act: call our method with proper parameter value for our test
		String actualResult = theCalculator.getBiathlonAverage(5000, 4, 2);
		
		// Assert: assert that our expected value is equal to the actual result
		assertEquals("0:42:10", actualResult);
	}
	

	@Test
	void testAverageWith4SkiersAnd3Penalties() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();
		
		// Act: call our method with proper parameter value for our test
		String actualResult = theCalculator.getBiathlonAverage(15000, 3, 4);
		
		// Assert: assert that our expected value is equal to the actual result
		assertEquals("1:2:41", actualResult);
	}
}
