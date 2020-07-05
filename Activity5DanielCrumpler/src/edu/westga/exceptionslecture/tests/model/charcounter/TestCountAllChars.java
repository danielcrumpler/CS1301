package edu.westga.exceptionslecture.tests.model.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.exceptionslecture.model.CharCounter;


public class TestCountAllChars {

	@Test
	void testShouldCountWhenAllAreNonEmpty() {
		// Arrange: create our object
		CharCounter counter = new CharCounter();
		
		// Act: count the characters
		int actualCount = counter.countAllChars("abc", "hello", "goodbye");
		
		// Assert: that our actual count matches our expected count
		assertEquals(15, actualCount);
	}
	
	@Test
	void testShouldCountWhenAllAreEmpty() {
		// Arrange: create our object
		CharCounter counter = new CharCounter();
		
		// Act: count the characters
		int actualCount = counter.countAllChars("", "", "");
		
		// Assert: that our actual count matches our expected count
		assertEquals(0, actualCount);
	}

	@Test
	void testShouldCountWhenSomeAreNonEmpty() {
		// Arrange: create our object
		CharCounter counter = new CharCounter();
		
		// Act: count the characters
		int actualCount = counter.countAllChars("abc", "", "goodbye");
		
		// Assert: that our actual count matches our expected count
		assertEquals(10, actualCount);
	}
	
	@Test
	void testShouldThrowNullPointerExceptionIfOneIsNull() {
		// Arrange: create our object
		CharCounter counter = new CharCounter();
		
		// Act and Assert: call the method with a null param, and assert that it throws
		// NullPointerException
		assertThrows(NullPointerException.class, () -> {
			counter.countAllChars("abc", null, "goodbye");
		});
	}
	
	@Test
	void testThatShouldFailBecauseNullPointerExceptionNotHandledProperly() {
		// Arrange: create our object
		CharCounter counter = new CharCounter();
		
		// Act: count the characters
		int actualCount = counter.countAllChars("abc", null, "goodbye");
		
		// Assert: that our actual count matches our expected count
		assertEquals(10, actualCount);
	}
}
