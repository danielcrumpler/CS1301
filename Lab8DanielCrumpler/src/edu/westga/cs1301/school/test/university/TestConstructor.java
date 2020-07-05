package edu.westga.cs1301.school.test.university;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.school.model.University;

/**
 * This class contains a set of tests to confirm correct functionality
 *  of the University constructor
 *  
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestConstructor {

	@Test
	public void shouldNotAllowNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new University(null);
		});
	}

	@Test
	public void shouldNotAllowEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new University("");
		});
	}
	
	@Test
	public void createsValidUniversity() {
		University westGeorgia = new University("West Georgia");
		assertEquals("West Georgia", westGeorgia.getName());
		assertEquals(true, westGeorgia.getApplications().isEmpty());
	}

}
