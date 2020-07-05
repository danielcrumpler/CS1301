package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.westga.carlot.model.Car;
import edu.westga.carlot.model.Carlot;

public class TestGetNewCars {

	@Test
	public void testWhenReturnEmptyListIfLotIsEmpty() {
		Carlot lot = new Carlot();
		ArrayList<Car> newCars = lot.getNewCars();
		assertTrue(newCars.isEmpty());
	}
	
	@Test
	public void testWhenReturnEmptyIfLotOnlyHasUsedCars() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 1999, 20000.00, 50.0, true);
		Car car1 = new Car("Honda", "CRV", 2000, 20000.00, 50.0, true);
		Car car2 = new Car("Nissan", "Frontier", 1998, 20000.00, 50.0, true);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		ArrayList<Car> newCars = lot.getNewCars();
		assertTrue(newCars.isEmpty());
	}
	
	@Test
	public void testWhenGetListOfAllCarsIfLotOnlyHasNewCars() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 1999, 20000.00, 50.0, false);
		Car car1 = new Car("Honda", "CRV", 2000, 20000.00, 50.0, false);
		Car car2 = new Car("Nissan", "Frontier", 1998, 20000.00, 50.0, false);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		ArrayList<Car> newCars = lot.getNewCars();
		assertEquals(3, newCars.size());
		assertSame(car0, newCars.get(0));
		assertSame(car1, newCars.get(1));
		assertSame(car2, newCars.get(2));
	}
	
	@Test
	public void testWhenExtractOnlyNewCarsFromLotThatContainsUsedAndNewCars() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 1999, 20000.00, 50.0, false);
		Car car1 = new Car("Honda", "CRV", 2000, 20000.00, 50.0, true);
		Car car2 = new Car("Nissan", "Frontier", 1998, 20000.00, 50.0, false);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		ArrayList<Car> newCars = lot.getNewCars();
		assertEquals(2, newCars.size());
		assertSame(car0, newCars.get(0));
		assertSame(car2, newCars.get(1));
	}
}
