package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.carlot.model.Carlot;

public class TestDetermineOldestCarYear {

	@Test
	public void testWhenReturnIntMaxWhenNoCars() {
		Carlot lot = new Carlot();
		assertEquals(Integer.MAX_VALUE, lot.determineOldestCarYear());
	}

	@Test
	public void testWhenReturnYearOfOnlyCarInLot() {
		Carlot lot = new Carlot();
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		assertEquals(2000, lot.determineOldestCarYear());
	}
	
	@Test
	public void testWhenLowestYearIsInMiddleOfLot() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 2001, 20000.00, 50.0, true);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		lot.addCar("Nissan", "Frontier", 2002, 20000.00, 50.0, true);
		assertEquals(2000, lot.determineOldestCarYear());
	}
	
	@Test
	public void testWhenHighestYearIsLastInLot() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 2001, 20000.00, 50.0, true);
		lot.addCar("Nissan", "Frontier", 2002, 20000.00, 50.0, true);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		assertEquals(2000, lot.determineOldestCarYear());
	}
}
