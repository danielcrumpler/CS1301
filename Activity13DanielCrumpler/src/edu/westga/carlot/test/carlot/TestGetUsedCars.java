package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.westga.carlot.model.Car;
import edu.westga.carlot.model.Carlot;

public class TestGetUsedCars {

	@Test
	public void testWhenReturnEmptyListIfLotIsEmpty() {
		Carlot lot = new Carlot();
		ArrayList<Car> usedCars = lot.getUsedCars();
		assertTrue(usedCars.isEmpty());
	}
	
	@Test
	public void testWhenReturnEmptyIfLotOnlyHasNewCars() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 1999, 20000.00, 50.0, false);
		Car car1 = new Car("Honda", "CRV", 2000, 20000.00, 50.0, false);
		Car car2 = new Car("Nissan", "Frontier", 1998, 20000.00, 50.0, false);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		ArrayList<Car> usedCars = lot.getUsedCars();
		assertTrue(usedCars.isEmpty());
	}
	
	@Test
	public void testWhenGetListOfAllCarsIfLotOnlyHasUsedCars() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 1999, 20000.00, 50.0, true);
		Car car1 = new Car("Honda", "CRV", 2000, 20000.00, 50.0, true);
		Car car2 = new Car("Nissan", "Frontier", 1998, 20000.00, 50.0, true);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		ArrayList<Car> usedCars = lot.getUsedCars();
		assertEquals(3, usedCars.size());
		assertSame(car0, usedCars.get(0));
		assertSame(car1, usedCars.get(1));
		assertSame(car2, usedCars.get(2));
	}
	
	@Test
	public void testWhenExtractOnlyUsedCarsFromLotThatContainsUsedAndNewCars() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 1999, 20000.00, 50.0, true);
		Car car1 = new Car("Honda", "CRV", 2000, 20000.00, 50.0, false);
		Car car2 = new Car("Nissan", "Frontier", 1998, 20000.00, 50.0, true);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		ArrayList<Car> usedCars = lot.getUsedCars();
		assertEquals(2, usedCars.size());
		assertSame(car0, usedCars.get(0));
		assertSame(car2, usedCars.get(1));
	}
}
