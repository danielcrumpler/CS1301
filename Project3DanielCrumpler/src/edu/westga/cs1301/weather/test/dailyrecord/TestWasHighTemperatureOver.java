package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;

public class TestWasHighTemperatureOver {

	@Test
	public void testGetTemperatureWhenNoHourlyMeasurements() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		boolean result = summary.wasHighTemperatureOver(0);
		assertFalse(result);
	}

	@Test
	public void testOneParameterOneDegreeBelowMinimum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(12, -151, 1));
	}

	@Test
	public void testOneParameterAtMinimum() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, -150, 1);
		summary.addHourlyMeasurement(measurement1);
		int result = measurement1.getFahrenheitTemperature();
		assertEquals(-150, result);
	}

	@Test
	public void testOneParameterOneDegreeAboveMinimum() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, -149, 1);
		summary.addHourlyMeasurement(measurement1);
		int result = measurement1.getFahrenheitTemperature();
		assertEquals(-149, result);
	}

	@Test
	public void testOneParameterOneDegreeBelowMaximum() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 149, 1);
		summary.addHourlyMeasurement(measurement1);
		int result = measurement1.getFahrenheitTemperature();
		assertEquals(149, result);
	}

	@Test
	public void testOneParameterAtMaximum() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 150, 1);
		summary.addHourlyMeasurement(measurement1);
		int result = measurement1.getFahrenheitTemperature();
		assertEquals(150, result);
	}

	@Test
	public void testOneParametertOneDegreeAboveMaximum() {
		assertThrows(IllegalArgumentException.class, () -> new HourlyMeasurement(12, 151, 1));
	}

	@Test
	public void testSingleMeasurementOneDegreeBelowParameter() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 69, 1);
		summary.addHourlyMeasurement(measurement1);
		boolean result = summary.wasHighTemperatureOver(70);
		assertFalse(result);
	}

	@Test
	public void testSingleMeasurementAtParameter() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 70, 1);
		summary.addHourlyMeasurement(measurement1);
		boolean result = summary.wasHighTemperatureOver(70);
		assertFalse(result);
	}

	@Test
	public void testSingleMeasurementOneDegreeAboveParameter() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 71, 1);
		summary.addHourlyMeasurement(measurement1);
		boolean result = summary.wasHighTemperatureOver(70);
		assertTrue(result);
	}

	@Test
	public void testSeveralMeasurementAllBelowParameter() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(10, 67, 1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(11, 68, 1);
		HourlyMeasurement measurement3 = new HourlyMeasurement(12, 69, 1);
		summary.addHourlyMeasurement(measurement1);
		summary.addHourlyMeasurement(measurement2);
		summary.addHourlyMeasurement(measurement3);
		boolean result = summary.wasHighTemperatureOver(70);
		assertFalse(result);
	}

	@Test
	public void testSeveralMeasurementAllAboveParameter() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(10, 71, 1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(11, 72, 1);
		HourlyMeasurement measurement3 = new HourlyMeasurement(12, 73, 1);
		summary.addHourlyMeasurement(measurement1);
		summary.addHourlyMeasurement(measurement2);
		summary.addHourlyMeasurement(measurement3);
		boolean result = summary.wasHighTemperatureOver(70);
		assertTrue(result);
	}

	@Test
	public void testSeveralMeasurementSomeButNotAllAboveParameter() {
		DailyRecord summary = new DailyRecord(9, 1, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(9, 68, 1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(10, 69, 1);
		HourlyMeasurement measurement3 = new HourlyMeasurement(11, 72, 1);
		HourlyMeasurement measurement4 = new HourlyMeasurement(12, 73, 1);
		summary.addHourlyMeasurement(measurement1);
		summary.addHourlyMeasurement(measurement2);
		summary.addHourlyMeasurement(measurement3);
		summary.addHourlyMeasurement(measurement4);
		boolean result = summary.wasHighTemperatureOver(70);
		assertTrue(result);
	}
}
