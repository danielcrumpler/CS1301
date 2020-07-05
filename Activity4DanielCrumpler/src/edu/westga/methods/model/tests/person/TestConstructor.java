package edu.westga.methods.model.tests.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.methods.model.Person;

public class TestConstructor {
	
	@Test
	void testShouldCreateValidPersonWithNonDefaultValues() {
		// Arrange & Act: instantiate a Person object with desired values
		Person zoe = new Person("Zoe", "Washburne");
		
		// Assert that the names we gave in the constructor are the ones in our object
		assertEquals("Zoe", zoe.getFirstName());
		assertEquals("Washburne", zoe.getLastName());
		
		// Assert that the age is the expected default of 0
		assertEquals(0, zoe.getAge());
	}

}
