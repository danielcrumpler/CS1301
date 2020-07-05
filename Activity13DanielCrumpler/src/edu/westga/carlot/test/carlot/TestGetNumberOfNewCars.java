package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.carlot.model.Carlot;

public class TestGetNumberOfNewCars {

	@Test
	public void testWhenHaveZeroNewCarsIfInventoryIsEmpty() {
		Carlot lot = new Carlot();
		assertEquals(0, lot.getNumberOfNewCars());
	}
	
	@Test
	public void testWhenHaveOneNewCarInASingleCarLot() {
		Carlot lot = new Carlot();
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, false);
		assertEquals(1, lot.getNumberOfNewCars());
	}
	
	@Test
	public void testWhenHaveZeroNewCarsIfInventoryIsAllUsedCars() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 1999, 20000.00, 50.0, true);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, true);
		lot.addCar("Nissan", "Frontier", 1998, 20000.00, 50.0, true);
		assertEquals(0, lot.getNumberOfNewCars());
	}

	@Test
	public void testWhenCountNewCarsInACarLotWithSomeUsedAndSomeNewCars() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 1999, 20000.00, 50.0, true);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, false);
		lot.addCar("Nissan", "Frontier", 1998, 20000.00, 50.0, true);
		assertEquals(1, lot.getNumberOfNewCars());
	}
	
	@Test
	public void testWhenCountNewCarsInACarLotWithOnlyNewCars() {
		Carlot lot = new Carlot();
		lot.addCar("Subaru", "Impreza", 1999, 20000.00, 50.0, false);
		lot.addCar("Honda", "CRV", 2000, 20000.00, 50.0, false);
		lot.addCar("Nissan", "Frontier", 1998, 20000.00, 50.0, false);
		assertEquals(3, lot.getNumberOfNewCars());
	}
}
