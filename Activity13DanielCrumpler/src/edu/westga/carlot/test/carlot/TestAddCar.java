package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.carlot.model.Carlot;

public class TestAddCar {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void testMakeIsNull() {
		this.expected.expect(IllegalArgumentException.class);
		Carlot theLot = new Carlot();
		theLot.addCar(null, "B", 2000, 10, 10, true);
	}

	@Test
	public void testModelIsNull() {
		this.expected.expect(IllegalArgumentException.class);
		Carlot theLot = new Carlot();
		theLot.addCar("A", null, 2000, 10, 10, true);
	}

	@Test
	public void testYearJustBelow1900() {
		this.expected.expect(IllegalArgumentException.class);
		Carlot theLot = new Carlot();
		theLot.addCar("A", "B", 1899, 10, 10, true);
	}

	@Test
	public void testYearJustAbove1900() {
		Carlot theLot = new Carlot();
		theLot.addCar("A", "B", 1901, 10, 10, true);

		assertEquals(1, theLot.size());
	}

	@Test
	public void testYearAt1900() {
		this.expected.expect(IllegalArgumentException.class);
		Carlot theLot = new Carlot();
		theLot.addCar("A", "B", 1900, 10, 10, true);
	}

	@Test
	public void testPriceIsIllegal() {
		this.expected.expect(IllegalArgumentException.class);
		Carlot theLot = new Carlot();
		theLot.addCar("A", "B", 1901, -0.01, 10, true);

	}

	@Test
	public void testMpgIsIllegal() {
		this.expected.expect(IllegalArgumentException.class);
		Carlot theLot = new Carlot();
		theLot.addCar("A", "B", 1901, 10, 0, true);

	}

	@Test
	public void testWhenAddAddFirstCar() {
		Carlot theLot = new Carlot();
		theLot.addCar("A", "B", 2000, 10, 10, true);

		assertEquals(1, theLot.size());
	}

	@Test
	public void testWhenAddAddSecondFirstCar() {
		Carlot theLot = new Carlot();
		theLot.addCar("A", "B", 2000, 10, 10, true);
		theLot.addCar("B", "A", 2001, 11, 11, true);

		assertEquals(2, theLot.size());
	}

}
