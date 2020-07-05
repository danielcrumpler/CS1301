package edu.westga.methods.model.tests.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.methods.model.Person;

public class TestChangeName {

	@Test
	void testShouldChangeName() {
		// Arrange: create a Person with known first & last name
		Person ada = new Person("Ada", "Lovelace");
		
		// Act: change their name
		ada.changeName("Sally", "Ride");
		
		// Assert: that the first and last names are the new values
		assertEquals("Sally", ada.getFirstName());
		assertEquals("Ride", ada.getLastName());
	}

}
