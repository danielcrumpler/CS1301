package edu.westga.cs1301.school.test.university;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.school.model.ApplicationData;
import edu.westga.cs1301.school.model.University;

/**
 * This class contains a set of tests to confirm correct
 *  functionality for findHighestTestScore
 *  
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestFindHighestTestScore {

	@Test
	public void testHighestTestScoreShouldBeIntegerMinimumIfNoApplications() {
		University westGeorgia = new University("West Georgia");
		int result = westGeorgia.findHighestTestScore();
		assertEquals(Integer.MIN_VALUE, result);
	}

	@Test
	public void testHighestTestScoreShouldBeOnlyApplication() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		
		int result = westGeorgia.findHighestTestScore();
		
		assertEquals(100, result);
	}
	
	@Test
	public void testHighestTestScoreShouldBeFirstApplication() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		
		ApplicationData student2 = new ApplicationData(2, 2.0, 50);
		westGeorgia.addApplication(student2);
		
		ApplicationData student3 = new ApplicationData(3, 3.0, 75);
		westGeorgia.addApplication(student3);
		
		int result = westGeorgia.findHighestTestScore();
		
		assertEquals(100, result);
	}
	
	@Test
	public void testHighestTestScoreShouldBeSecondApplication() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 50);
		westGeorgia.addApplication(student1);
		
		ApplicationData student2 = new ApplicationData(2, 2.0, 100);
		westGeorgia.addApplication(student2);
		
		ApplicationData student3 = new ApplicationData(3, 3.0, 75);
		westGeorgia.addApplication(student3);
		
		int result = westGeorgia.findHighestTestScore();
		
		assertEquals(100, result);
	}
	
	@Test
	public void testHighestTestScoreShouldBeLastApplication() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 75);
		westGeorgia.addApplication(student1);
		
		ApplicationData student2 = new ApplicationData(2, 2.0, 50);
		westGeorgia.addApplication(student2);
		
		ApplicationData student3 = new ApplicationData(3, 3.0, 100);
		westGeorgia.addApplication(student3);
		
		int result = westGeorgia.findHighestTestScore();
		
		assertEquals(100, result);
	}
	
	@Test
	public void testHighestTestScoreWhenTwoApplicationsHaveHighest() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 50);
		westGeorgia.addApplication(student1);
		
		ApplicationData student2 = new ApplicationData(2, 2.0, 100);
		westGeorgia.addApplication(student2);
		
		ApplicationData student3 = new ApplicationData(3, 3.0, 100);
		westGeorgia.addApplication(student3);
		
		int result = westGeorgia.findHighestTestScore();
		
		assertEquals(100, result);
	}
	
	@Test
	public void testHighestTestScoreWhenAllApplicationsHaveHighest() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		
		ApplicationData student2 = new ApplicationData(2, 2.0, 100);
		westGeorgia.addApplication(student2);
		
		ApplicationData student3 = new ApplicationData(3, 3.0, 100);
		westGeorgia.addApplication(student3);
		
		int result = westGeorgia.findHighestTestScore();
		
		assertEquals(100, result);
	}
}
