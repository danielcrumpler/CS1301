package edu.westga.cs1301.project2.test.octalnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.OctalNumber;

/**
 * Tests to confirm correct functionality of the OctalNumber class
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestConstructorWith3Parameters {

	@Test
	public void testShouldCreateWithZeroParamConstructor() {
		// Arrange & Act: create the OctalNumber object
		OctalNumber theNumber = new OctalNumber();

		// Assert: that its initial values are correct
		assertEquals(0, theNumber.getDigit1());
		assertEquals(0, theNumber.getDigit2());
		assertEquals(0, theNumber.getDigit3());
	}

	@Test
	public void testShouldNotAllowNegativeDigit1() {
		// Arrange, Act, and Assert: create the OctalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new OctalNumber(-1, 0);
		});
	}

	@Test
	public void testShouldNotAllowDigit1Over7() {
		// Arrange, Act, and Assert: create the OctalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new OctalNumber(8, 0);
		});
	}

	@Test
	public void testShouldNotAllowNegativeDigit2() {
		// Arrange, Act, and Assert: create the OctalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new OctalNumber(0, -1);
		});
	}

	@Test
	public void testShouldNotAllowDigit2Over7() {
		// Arrange, Act, and Assert: create the OctalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new OctalNumber(0, 8);
		});
	}
	
	@Test
	public void testShouldNotAllowNegativeDigit3() {
		// Arrange, Act, and Assert: create the OctalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new OctalNumber(0, 0, -1);
		});
	}

	@Test
	public void testShouldNotAllowDigit3Over7() {
		// Arrange, Act, and Assert: create the OctalNumber object
		// with a bad first digit
		assertThrows(IllegalArgumentException.class, () -> {
			new OctalNumber(0, 0, 8);
		});
	}

	@Test
	public void testShouldCreateValidOctalNumber() {
		// Arrange & Act: create the AlarmClock object
		OctalNumber theNumber = new OctalNumber(2, 3, 5);

		// Assert: that its initial values are correct
		assertEquals(2, theNumber.getDigit1());
		assertEquals(3, theNumber.getDigit2());
		assertEquals(5, theNumber.getDigit3());
	}

}
