package edu.westga.cs1301.weather.test.hourlymeasurement;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import edu.westga.cs1301.weather.model.HourlyMeasurement;

public class TestConstructor {

	@Test
	public void testNotAllowHourOneLessThanMinimum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(-1, 90, 5));
	}

	@Test
	public void testNotAllowHourWellBelowMinimum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(-10, 90, 5));
	}

	@Test
	public void testAllowHourAtMinimum() {
		HourlyMeasurement measurement = new HourlyMeasurement(0, 90, 5);

		int result = measurement.getHourOfDay();

		assertEquals(0, result);
	}

	@Test
	public void testNotAllowHourOneGreaterThanMaximum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(24, 90, 5));
	}

	@Test
	public void testNotAllowHourWellAboveMaximum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(50, 90, 5));
	}

	@Test
	public void testAllowHourAtMaximum() {
		HourlyMeasurement measurement = new HourlyMeasurement(23, 90, 5);

		int result = measurement.getHourOfDay();

		assertEquals(23, result);
	}

	@Test
	public void testNotAllowTempOneLessThanMinimum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(12, -151, 5));
	}

	@Test
	public void testNotAllowTempWellBelowMinimum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(12, -200, 5));
	}

	@Test
	public void testAllowTempAtMinimum() {
		HourlyMeasurement measurement = new HourlyMeasurement(12, -150, 5);

		assertEquals(-150, measurement.getFahrenheitTemperature());
	}

	@Test
	public void testNotAllowTempOneGreaterThanMaximum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(12, 151, 5));
	}

	@Test
	public void testNotAllowTempWellAboveMaximum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(12, -200, 5));
	}

	@Test
	public void testAllowTempAtMaximum() {
		HourlyMeasurement measurement = new HourlyMeasurement(12, 150, 5);
		assertEquals(150, measurement.getFahrenheitTemperature());
	}

	@Test
	public void testAllowValidNegativeTemp() {
		HourlyMeasurement measurement = new HourlyMeasurement(12, -100, 5);
		assertEquals(-100, measurement.getFahrenheitTemperature());
	}

	@Test
	public void testNotAllowInchesOfRainOneLessThanMinimum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(12, 90, -1));
	}

	@Test
	public void testNotAllowInchesOfRainWellBelowMinimum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(12, 90, -10));
	}

	@Test
	public void testAllowInchesOfRainAtMinimum() {
		HourlyMeasurement measurement = new HourlyMeasurement(12, 90, 0);
		assertEquals(0, measurement.getInchesOfRain());
	}

	@Test
	public void testCreateValidHourlyMeasurement() {
		HourlyMeasurement measurement = new HourlyMeasurement(12, 90, 5);
		assertEquals(12, measurement.getHourOfDay());
		assertEquals(90, measurement.getFahrenheitTemperature());
		assertEquals(5, measurement.getInchesOfRain());
	}
}
