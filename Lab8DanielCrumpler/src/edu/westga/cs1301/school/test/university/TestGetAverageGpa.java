package edu.westga.cs1301.school.test.university;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.school.model.ApplicationData;
import edu.westga.cs1301.school.model.University;
import edu.westga.cs1301.school.test.TestingConstants;

/**
 * This class contains a set of tests to confirm correct
 *  functionality for getAverageGpa
 *  
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestGetAverageGpa {

	@Test
	public void testAverageGpaShouldBeDoubleMinimumIfNoApplications() {
		University westGeorgia = new University("West Georgia");
		double result = westGeorgia.getAverageGpa();
		assertEquals(Double.MIN_VALUE, result);
	}

	@Test
	public void testGetAverageGpaWhenThereIsOnlyOneApplication() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		
		double result = westGeorgia.getAverageGpa();
		
		assertEquals(4.0, result, TestingConstants.DELTA);
	}
	
	@Test
	public void testGetAverageGpaWhenThereAreMultipleApplications() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		
		ApplicationData student2 = new ApplicationData(2, 3.0, 50);
		westGeorgia.addApplication(student2);
		
		ApplicationData student3 = new ApplicationData(3, 3.0, 75);
		westGeorgia.addApplication(student3);
		
		double result = westGeorgia.getAverageGpa();
		
		assertEquals(3.33333, result, TestingConstants.DELTA);
	}
}
