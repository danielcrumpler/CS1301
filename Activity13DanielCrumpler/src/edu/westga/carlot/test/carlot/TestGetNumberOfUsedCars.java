package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.carlot.model.Carlot;

public class TestGetNumberOfUsedCars {

	@Test
	public void testWhenHaveZeroUsedCarsIfInventoryIsEmpty() {
		Carlot lot = new Carlot();
		assertEquals(0, lot.getNumberOfUsedCars());
	}
	
	@Test
	public void testWhenHaveOneUsedCarInASingleCarLot() {
		Carlot lot = new Carlot();
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		assertEquals(1, lot.getNumberOfUsedCars());
	}
	
	@Test
	public void testWhenHaveZeroUsedCarsIfInventoryIsAllNewCars() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 1999, 20000.00, 50.0, false);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, false);
		lot.addCar("Nissan", "Frontier", 1998, 20000.00, 50.0, false);
		assertEquals(0, lot.getNumberOfUsedCars());
	}

	@Test
	public void testWhenCountUsedCarsInACarLotWithSomeUsedAndSomeNewCars() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 1999, 20000.00, 50.0, false);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		lot.addCar("Nissan", "Frontier", 1998, 20000.00, 50.0, false);
		assertEquals(1, lot.getNumberOfUsedCars());
	}
	
	@Test
	public void testWhenCountUsedCarsInACarLotWithOnlyUsedCars() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 1999, 20000.00, 50.0, true);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		lot.addCar("Nissan", "Frontier", 1998, 20000.00, 50.0, true);
		assertEquals(3, lot.getNumberOfUsedCars());
	}
}
