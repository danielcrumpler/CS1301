package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.carlot.model.Car;
import edu.westga.carlot.model.Carlot;

public class TestSearchByMakeModelAndPrice {

	@Test(expected = IllegalArgumentException.class)
	public void testWhenNotAllowNullMake() {
		Carlot lot = new Carlot();
		lot.searchByMakeModelAndPrice(null, "CRV", 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenNotAllowNullModel() {
		Carlot lot = new Carlot();
		lot.searchByMakeModelAndPrice("Honda", null, 10000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWhenNotAllowNegativePrice() {
		Carlot lot = new Carlot();
		lot.searchByMakeModelAndPrice("Honda", "CRV", -10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenNotAllowZeroPrice() {
		Carlot lot = new Carlot();
		lot.searchByMakeModelAndPrice("Honda", "CRV", 0);
	}
	
	@Test
	public void testWhenGetNullIfNoInventory() {
		Carlot lot = new Carlot();
		Car foundCar = lot.searchByMakeModelAndPrice("Honda", "CRV", 10000);
		assertEquals(null, foundCar);
	}
	
	@Test
	public void testWhenOnlyCarInInventoryShouldMatch() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Honda", "CRV", 2000, 5000, 50, true);
		lot.addCar(car0);
		Car foundCar = lot.searchByMakeModelAndPrice("Honda", "CRV", 10000);
		assertEquals(car0, foundCar);
	}
	
	@Test
	public void testWhenShouldBeFirstCarInInventory() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Honda", "CRV", 2000, 5000, 50, true);
		Car car1 = new Car("Nissan", "Frontier", 2000, 5000, 50, true);
		Car car2 = new Car("Subaru", "Impreza", 2016, 20000, 50, false);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		Car foundCar = lot.searchByMakeModelAndPrice("Honda", "CRV", 10000);
		assertEquals(car0, foundCar);
	}
	
	@Test
	public void testWhenShouldBeLastCarInInventory() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 2016, 20000, 50, false);
		Car car1 = new Car("Nissan", "Frontier", 2000, 5000, 50, true);
		Car car2 = new Car("Honda", "CRV", 2000, 5000, 50, true);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		Car foundCar = lot.searchByMakeModelAndPrice("Honda", "CRV", 10000);
		assertEquals(car2, foundCar);
	}
	
	@Test
	public void testWhenShouldBeMiddleCarInInventory() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 2016, 20000, 50, false);
		Car car1 = new Car("Honda", "CRV", 2000, 5000, 50, true);
		Car car2 = new Car("Nissan", "Frontier", 2000, 5000, 50, true);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		Car foundCar = lot.searchByMakeModelAndPrice("Honda", "CRV", 10000);
		assertEquals(car1, foundCar);
	}
	
	@Test
	public void testWhenShouldNotBeInInventory() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Subaru", "Impreza", 2016, 20000, 50, false);
		Car car1 = new Car("Honda", "CRV", 2000, 5000, 50, true);
		Car car2 = new Car("Nissan", "Frontier", 2000, 5000, 50, true);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		Car foundCar = lot.searchByMakeModelAndPrice("Toyota", "Corrolla", 10000);
		assertEquals(null, foundCar);
	}
}
