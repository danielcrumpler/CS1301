package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.carlot.model.Carlot;

public class TestDetermineNewestCarYear {

	@Test
	public void testWhenReturnIntMinWhenNoCars() {
		Carlot lot = new Carlot();
		assertEquals(Integer.MIN_VALUE, lot.determineNewestCarYear());
	}

	@Test
	public void testWhenReturnYearOfOnlyCarInLot() {
		Carlot lot = new Carlot();
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		assertEquals(2000, lot.determineNewestCarYear());
	}
	
	@Test
	public void testWhenHighestYearIsInMiddleOfLot() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 1999, 20000.00, 50.0, true);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		lot.addCar("Nissan", "Frontier", 1998, 20000.00, 50.0, true);
		assertEquals(2000, lot.determineNewestCarYear());
	}
	
	@Test
	public void testWhenHighestYearIsLastInLot() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 1999, 20000.00, 50.0, true);
		lot.addCar("Nissan", "Frontier", 1998, 20000.00, 50.0, true);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		assertEquals(2000, lot.determineNewestCarYear());
	}
}
