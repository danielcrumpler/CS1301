package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;

public class TestFindHighestFahrenheitTemperature {

	@Test
	public void testHighTemperatureShouldBeIntegerMinimumValueIfNoMeasurements() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);

		int result = summary.getHighestFahrenheitTemperature();

		assertEquals(Integer.MIN_VALUE, result);
	}

	@Test
	public void testHighTemperatureShouldBeOnlyMeasurement() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 1);
		summary.addHourlyMeasurement(measurement0);

		int result = summary.getHighestFahrenheitTemperature();

		assertEquals(100, result);
	}

	@Test
	public void testHighTemperatureShouldBeFirstMeasurement() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 1);
		summary.addHourlyMeasurement(measurement0);
		HourlyMeasurement measurement1 = new HourlyMeasurement(13, 10, 10);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(14, 20, 1);
		summary.addHourlyMeasurement(measurement2);

		int result = summary.getHighestFahrenheitTemperature();

		assertEquals(100, result);
	}

	@Test
	public void testHighTemperatureShouldBeLastMeasurement() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 20, 1);
		summary.addHourlyMeasurement(measurement0);
		HourlyMeasurement measurement1 = new HourlyMeasurement(13, 10, 10);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(14, 100, 1);
		summary.addHourlyMeasurement(measurement2);

		int result = summary.getHighestFahrenheitTemperature();

		assertEquals(100, result);
	}

	@Test
	public void testHighTemperatureShouldBeMiddleMeasurement() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 10, 1);
		summary.addHourlyMeasurement(measurement0);
		HourlyMeasurement measurement1 = new HourlyMeasurement(13, 100, 10);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(14, 20, 1);
		summary.addHourlyMeasurement(measurement2);

		int result = summary.getHighestFahrenheitTemperature();

		assertEquals(100, result);
	}
}
