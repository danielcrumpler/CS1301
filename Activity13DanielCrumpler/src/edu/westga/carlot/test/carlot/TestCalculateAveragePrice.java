package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.carlot.model.Carlot;

public class TestCalculateAveragePrice {

	
	private static final double DELTA = 0.000001;

	@Test
	public void testWhenAveragePriceShouldBeZeroIfNoCarsInLot() {
		Carlot lot = new Carlot();
		assertEquals(0, lot.calculateAveragePrice(), DELTA);
	}

	@Test
	public void testWhenAveragePriceShouldSameAsPriceOfOnlyCarInLot() {
		Carlot lot = new Carlot();
		lot.addCar("Honda", "CRV", 2000, 10000.00, 50.0, true);
		assertEquals(10000.00, lot.calculateAveragePrice(), DELTA);
	}
	
	@Test
	public void testWhenFindProperAveragePriceAcrossManyCars() {
		Carlot lot = new Carlot();
		lot.addCar("Honda", "CRV", 2000, 10000.00, 50.0, true);
		lot.addCar("Subaru", "Impreza", 2001, 10200.00, 50.0, true);
		lot.addCar("Nissan", "Frontier", 2002, 10800.00, 50.0, true);
		assertEquals(10333.333333, lot.calculateAveragePrice(), DELTA);
	}
}
