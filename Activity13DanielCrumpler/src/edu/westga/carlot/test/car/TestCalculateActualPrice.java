package edu.westga.carlot.test.car;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.carlot.model.Car;

public class TestCalculateActualPrice {
	
	private static final double DELTA = 0.001;

	@Test
	public void testWhenNewCarShouldNotDepreciate() {
		Car usedCar = new Car("Honda", "Civic", 2010, 10000.00, 50.00, false);
		double actualPrice = usedCar.calculateActualPriceFor(2016);
		assertEquals(10000.00, actualPrice, DELTA);
	}
	
	@Test
	public void testWhenCarShouldNotDepreciateInItsModelYear() {
		Car usedCar = new Car("Honda", "Civic", 2016, 10000.00, 50.00, false);
		double actualPrice = usedCar.calculateActualPriceFor(2016);
		assertEquals(10000.00, actualPrice, DELTA);
	}
	
	@Test
	public void testWhenUsedCarShouldDepreciateAfterOneYear() {
		Car usedCar = new Car("Honda", "Civic", 2015, 10000.00, 50.00, true);
		double actualPrice = usedCar.calculateActualPriceFor(2016);
		assertEquals(9000.00, actualPrice, DELTA);
	}
	
	@Test
	public void testWhenUsedCarShouldDepreciateAfterSeveralYears() {
		Car usedCar = new Car("Honda", "Civic", 2010, 10000.00, 50.00, true);
		double actualPrice = usedCar.calculateActualPriceFor(2016);
		assertEquals(5314.41, actualPrice, DELTA);
	}

}
