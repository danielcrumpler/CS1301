package edu.westga.methods.model.tests.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.methods.model.Person;

public class TestFindBirthYear {

	@Test
	void testShouldBeCurrentYearIfJustBorn() {
		// Arrange: create a Person (who by default is 0 years old)
		Person baby = new Person("New", "Born");
		
		// Act: get the year in which they were born
		int actualBirthYear = baby.findBirthYear(2018);
		
		// Assert that actualBirthYear is equal to the expected birth year
		assertEquals(2018, actualBirthYear);
	}

	@Test
	void testShouldCalculateBirthYearForPersonOfACertainAge() {
		// Arrange: create a Person and age them some
		Person dude = new Person("Jeff", "Bridges");
		dude.growOlderBy(10);
		
		// Act: get the year in which they were born
		int actualBirthYear = dude.findBirthYear(2018);
		
		// Assert that actualBirthYear is equal to the expected birth year
		assertEquals(2008, actualBirthYear);
	}
}
