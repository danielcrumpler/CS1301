package edu.westga.cs1301.school.test.university;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.school.model.ApplicationData;
import edu.westga.cs1301.school.model.University;

/**
 * This class contains a set of tests to confirm correct
 *  functionality for getApplicationNumber
 *  
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestHasApplicationNumber {

	@Test
	public void shouldNotAllowNegativeApplicationNumber() {
		University westGeorgia = new University("West Georgia");
		assertThrows(IllegalArgumentException.class, () -> {
			westGeorgia.hasApplicationNumber(-1);
		});
	}

	@Test
	public void shouldNotAllowApplicationNumberOf0() {
		University westGeorgia = new University("West Georgia");
		assertThrows(IllegalArgumentException.class, () -> {
			westGeorgia.hasApplicationNumber(0);
		});
	}
	
	@Test
	public void shouldHaveApplicationNumber1() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		assertEquals(true, westGeorgia.hasApplicationNumber(1));
	}
	
	@Test
	public void shouldNotHaveApplicationNumber10() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		assertEquals(false, westGeorgia.hasApplicationNumber(10));
	}
}
