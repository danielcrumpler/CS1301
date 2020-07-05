package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.carlot.model.Car;
import edu.westga.carlot.model.Carlot;

public class TestCalculateTaxWriteOffFor {

	private static final double DELTA = 0.001;

	@Test
	public void testWhenWriteOffShouldBeZeroIfLotIsEmpty() {
		Carlot lot = new Carlot();
		assertEquals(0.0, lot.calculateTaxWriteOffFor(2016), DELTA);
	}

	@Test
	public void testWhenWriteOffForLotWithOnlyNewCarsShouldBeZero() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Honda", "Civic", 2015, 10000, 50.0, false);
		Car car1 = new Car("Honda", "Civic", 2016, 20000, 50.0, false);
		Car car2 = new Car("Honda", "Civic", 2014, 30000, 50.0, false);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		assertEquals(0.0, lot.calculateTaxWriteOffFor(2016), DELTA);
	}
	
	@Test
	public void testWhenWriteOffForLotWithOneUsedCarShouldBeThatCarsWriteOff() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Honda", "Civic", 2015, 10000, 50.0, true);
		lot.addCar(car0);
		assertEquals(1000.0, lot.calculateTaxWriteOffFor(2016), DELTA);
	}
	
	@Test
	public void testWhenCalculateWriteOffForLotWithOnlyUsedCars() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Honda", "Civic", 2015, 10000, 50.0, true);
		Car car1 = new Car("Honda", "Civic", 2016, 20000, 50.0, true);
		Car car2 = new Car("Honda", "Civic", 2014, 30000, 50.0, true);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		assertEquals(6700.00, lot.calculateTaxWriteOffFor(2016), DELTA);
	}
	
	@Test
	public void testWhenCalculateWriteOffForLotWithSomeUsedAndSomeNewCars() {
		Carlot lot = new Carlot();
		Car car0 = new Car("Honda", "Civic", 2015, 10000, 50.0, true);
		Car car1 = new Car("Honda", "Civic", 2016, 20000, 50.0, false);
		Car car2 = new Car("Honda", "Civic", 2014, 30000, 50.0, true);
		Car car3 = new Car("Honda", "Civic", 2010, 30000, 50.0, false);
		lot.addCar(car0);
		lot.addCar(car1);
		lot.addCar(car2);
		lot.addCar(car3);
		assertEquals(6700.00, lot.calculateTaxWriteOffFor(2016), DELTA);
	}
}
