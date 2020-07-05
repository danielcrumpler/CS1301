package edu.westga.cs1301.project2.test.numbercontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controller.NumberController;

/**
 * Tests to confirm correct functionality of the OctalNumber constructor
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestConstructorHexadecimalNumber {

	@Test
	public void testShouldCreateNumberController() {
		// Arrange & Act: create the controller
		NumberController theController = new NumberController();
		
		// Assert: that it has a non-null object
		assertNotNull(theController.getHexadecimalNumber());
	}

}
