package edu.westga.carlot.test.car;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.carlot.model.Car;
import edu.westga.carlot.test.TestingConstants;

public class TestConstruction {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void testDefaultConstructor() {
		Car aCar = new Car();

		assertNull(aCar.getMake());
		assertNull(aCar.getModel());
		assertEquals(2000, aCar.getYear());
		assertEquals(0, aCar.getMSRP(), TestingConstants.DELTA);
		assertEquals(0, aCar.getMpg(), TestingConstants.DELTA);
	}

	@Test
	public void testMakeIsNull() {
		this.expected.expect(IllegalArgumentException.class);
		new Car(null, "B", 2000, 10, 10, true);
	}

	@Test
	public void testModellIsNull() {
		this.expected.expect(IllegalArgumentException.class);
		new Car("A", null, 2000, 10, 10, true);
	}

	@Test
	public void testYearJustBelow1900() {
		this.expected.expect(IllegalArgumentException.class);
		new Car("A", "B", 1899, 10, 10, true);
	}

	@Test
	public void testYearJustAbove1900() {
		Car aCar = new Car("A", "B", 1901, 10, 10, true);

		assertEquals("A", aCar.getMake());
		assertEquals("B", aCar.getModel());
		assertEquals(1901, aCar.getYear());
		assertEquals(10, aCar.getMSRP(), TestingConstants.DELTA);
		assertEquals(10, aCar.getMpg(), TestingConstants.DELTA);

	}

	@Test
	public void testYearAt1900() {
		this.expected.expect(IllegalArgumentException.class);
		new Car("A", "B", 1900, 10, 10, true);
	}

	@Test
	public void testPriceIsIllegal() {
		this.expected.expect(IllegalArgumentException.class);
		new Car("A", "B", 1901, -0.01, 10, true);

	}

	@Test
	public void testMpgIsIllegal() {
		this.expected.expect(IllegalArgumentException.class);
		new Car("A", "B", 1901, 10, 0, true);

	}

}
