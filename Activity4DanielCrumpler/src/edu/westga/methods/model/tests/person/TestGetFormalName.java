package edu.westga.methods.model.tests.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.methods.model.Person;

public class TestGetFormalName {

	@Test
	void testShouldGetFormalName() {
		// Arrange: create a Person with a name
		Person anja = new Person("Anja", "Remshagen");
		
		// Act: call getFormalName() to get our actual value
		String actual = anja.getFormalName("Dr.");
		
		// Assert that the formal name matches our expectation
		assertEquals("Dr. Remshagen", actual);
	}

}
