package edu.westga.cs1301.school.test.university;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.school.model.ApplicationData;
import edu.westga.cs1301.school.model.University;

/**
 * This class contains a set of tests to confirm correct
 *  functionality for addApplication
 *  
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestAddApplication {

	@Test
	public void shouldNotAddNullApplication() {
		University westGeorgia = new University("West Georgia");
		assertThrows(IllegalArgumentException.class, () -> {
			westGeorgia.addApplication(null);
		});
	}

	@Test
	public void testAddOneApplication() {
		University westGeorgia = new University("West Georgia");
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		
		assertEquals(1, westGeorgia.getNumberOfApplications());
		assertEquals(student1, westGeorgia.getApplications().get(0));
	}
	
	@Test
	public void testAddSeveralApplications() {
		University westGeorgia = new University("West Georgia");
		
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		
		ApplicationData student2 = new ApplicationData(2, 2.0, 50);
		westGeorgia.addApplication(student2);
		
		ApplicationData student3 = new ApplicationData(3, 3.0, 75);
		westGeorgia.addApplication(student3);
		
		assertEquals(3, westGeorgia.getNumberOfApplications());
		assertEquals(student1, westGeorgia.getApplications().get(0));
		assertEquals(student2, westGeorgia.getApplications().get(1));
		assertEquals(student3, westGeorgia.getApplications().get(2));
	}
	
	@Test
	public void testDoesNotAddApplicationWithSameNumber() {
		University westGeorgia = new University("West Georgia");
		
		ApplicationData student1 = new ApplicationData(1, 4.0, 100);
		westGeorgia.addApplication(student1);
		
		ApplicationData student2 = new ApplicationData(1, 2.0, 50);
		assertThrows(IllegalArgumentException.class, () -> {
			westGeorgia.addApplication(student2);
		});
	}
}
