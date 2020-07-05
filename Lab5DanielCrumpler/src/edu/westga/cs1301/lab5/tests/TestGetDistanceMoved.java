package edu.westga.cs1301.lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1301.lab5.model.TimeCalculator;

/**
 * This class contains a variety of tests to confirm correct functionality
 *  of the getDistance method
 *  
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestGetDistanceMoved {

	@Test
	public void testDistanceWithNoWind() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();
		
		// Act: call our method with proper parameter value for our test
		double actualResult = theCalculator.getDistanceMoved(1000, 5, 0);
		
		// Assert: assert that our expected value is equal to the actual result
		assertEquals(5000.0, actualResult);
	}

	@Test
	public void testDistanceWithTailWind() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();
		
		// Act: call our method with proper parameter value for our test
		double actualResult = theCalculator.getDistanceMoved(1000, 10, 1);
		
		// Assert: assert that our expected value is equal to the actual result
		assertEquals(11000.0, actualResult);
	}
	
	@Test
	public void testDistanceWithHeadWind() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();
		
		// Act: call our method with proper parameter value for our test
		double actualResult = theCalculator.getDistanceMoved(1000, 10, -1);
		
		// Assert: assert that our expected value is equal to the actual result
		assertEquals(9000.0, actualResult);
	}
	
	@Test
	public void testDistanceWithMajorHeadWind() {
		// Arrange: create a TimeCalculator object
		TimeCalculator theCalculator = new TimeCalculator();
		
		// Act: call our method with proper parameter value for our test
		double actualResult = theCalculator.getDistanceMoved(1000, 10, -10);
		
		// Assert: assert that our expected value is equal to the actual result
		assertEquals(0.0, actualResult);
	}
}
