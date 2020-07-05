package edu.westga.methods.model.tests.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.methods.model.Person;

public class TestGetFullName {
	
	@Test
	void testShouldGetFullName() {
		// Arrange: create a Person with non-default name values
		Person michelle = new Person("Michelle", "Obama");
		
		// Act: get that Person's full name as our actual value
		String actualFullName = michelle.getFullName();
		
		// Assert that the actual full name matches our expected full name
		assertEquals("Michelle Obama", actualFullName);
	}

}
