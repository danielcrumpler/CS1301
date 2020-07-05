package edu.westga.methods.model.tests.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.methods.model.Person;

public class TestGrowOlderBy {

	@Test
	void testShouldNotGetOlderIfYearsIsZero() {
		// Arrange: start with known object state
		Person trevor = new Person("Trevor", "Belmont");

		// Act: call growOlderBy() with a parameter specific to our test case
		trevor.growOlderBy(0);

		// Assert our expectation: that the age is still zero
		assertEquals(0, trevor.getAge());
	}

	@Test
	void testShouldGrowOneYearOlder() {
		// Arrange: start with known object state
		Person trevor = new Person("Trevor", "Belmont");

		// Act: call growOlderBy() with a parameter specific to our test case
		trevor.growOlderBy(1);

		// Assert our expectation: that the age has increased by 1
		assertEquals(1, trevor.getAge());
	}

	@Test
	void testShouldGrowSeveralYearsOlder() {
		// Arrange: start with known object state
		Person trevor = new Person("Trevor", "Belmont");

		// Act: call growOlderBy() with a parameter specific to our test case
		trevor.growOlderBy(5);

		// Assert our expectation: that the age has increased by 5
		assertEquals(5, trevor.getAge());
	}

	@Test
	void testSuccessiveCallsToGrowOlderShouldAccumulate() {
		// Arrange: start with known object state
		Person trevor = new Person("Trevor", "Belmont");

		// Act: call growOlderBy() a couple of times, with different values
		trevor.growOlderBy(5);
		trevor.growOlderBy(3);

		// Assert our expectation: that the age has increased by 8
		assertEquals(8, trevor.getAge()) ;
	}
}
