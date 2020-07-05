package edu.westga.exceptionslecture.tests.model.divisionformatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.exceptionslecture.model.DivisionFormatter;

public class TestDivide {

	@Test
	void testShouldDivideWithQuotientAndRemainder() {
		// Arrange: create a DivisionFormatter object
		DivisionFormatter formatter = new DivisionFormatter();
		
		// Act: perform the formatted divide
		String actual = formatter.divide(5, 2);
		
		// Assert that the actual value meets our expected value
		assertEquals("2 Rem 1", actual);
	}
	
	@Test
	void testShouldDivideResultingInZeroQuotientAndNonzeroRemainder() {
		// Arrange: create a DivisionFormatter object
		DivisionFormatter formatter = new DivisionFormatter();
		
		// Act: perform the formatted divide
		String actual = formatter.divide(3, 5);
		
		// Assert that the actual value meets our expected value
		assertEquals("0 Rem 3", actual);
	}
	
	@Test
	void testShouldDivideResultingInNonzeroQuotientAndZeroRemainder() {
		// Arrange: create a DivisionFormatter object
		DivisionFormatter formatter = new DivisionFormatter();
		
		// Act: perform the formatted divide
		String actual = formatter.divide(6, 2);
		
		// Assert that the actual value meets our expected value
		assertEquals("3 Rem 0", actual);
	}

	@Test
	void testShouldDivideResultingInZeroQuotientAndZeroRemainder() {
		// Arrange: create a DivisionFormatter object
		DivisionFormatter formatter = new DivisionFormatter();
		
		// Act: perform the formatted divide
		String actual = formatter.divide(0, 5);
		
		// Assert that the actual value meets our expected value
		assertEquals("0 Rem 0", actual);
	}
	
	@Test
	void testShouldThrowArithmeticExceptionIfDivisorIsZero() {
		// Arrange: create a DivisionFormatter object
		DivisionFormatter formatter = new DivisionFormatter();
		
		// Act & Assert: perform the formatted divide and assert it throws ArithmeticException
		assertThrows(ArithmeticException.class, () -> {
			formatter.divide(6, 0);
		});
	}
	
	@Test
	void testShouldFailBecauseTheExceptionIsNotHandledProperly() {
		// Arrange: create a DivisionFormatter object
		DivisionFormatter formatter = new DivisionFormatter();
		
		// Act: perform the formatted divide
		String actual = formatter.divide(5, 0);
		
		// Assert that the actual value meets our expected value
		assertEquals("Infinity Rem 0", actual);
	}
}
