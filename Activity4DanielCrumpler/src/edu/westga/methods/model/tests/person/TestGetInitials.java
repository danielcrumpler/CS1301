package edu.westga.methods.model.tests.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.methods.model.Person;

public class TestGetInitials {

	@Test
	void testShouldGetInitials() {
		// Arrange: create a Person with a first & last name
		Person lando = new Person("Lando", "Calrissian");
		
		// Act: execute the getInitials() method and save it's return value
		String actualInitials = lando.getInitials();
		
		// Assert: that the actual initials equal our expected initials "L.C."
		assertEquals("L.C.", actualInitials);
	}

}
