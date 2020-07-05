package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;

public class TestFindLowestFahrenheitTemperature {

	@Test
	public void testLowTemperatureShouldBeIntegerMinimumValueIfNoMeasurements() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);

		int result = summary.getLowestFahrenheitTemperature();

		assertEquals(Integer.MAX_VALUE, result);
	}

	@Test
	public void testLowTemperatureShouldBeOnlyMeasurement() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 5, 1);
		summary.addHourlyMeasurement(measurement0);

		int result = summary.getLowestFahrenheitTemperature();

		assertEquals(5, result);
	}

	@Test
	public void testLowTemperatureShouldBeFirstMeasurement() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 5, 1);
		summary.addHourlyMeasurement(measurement0);
		HourlyMeasurement measurement1 = new HourlyMeasurement(13, 10, 10);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(14, 20, 1);
		summary.addHourlyMeasurement(measurement2);

		int result = summary.getLowestFahrenheitTemperature();

		assertEquals(5, result);
	}

	@Test
	public void testLowTemperatureShouldBeLastMeasurement() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 20, 1);
		summary.addHourlyMeasurement(measurement0);
		HourlyMeasurement measurement1 = new HourlyMeasurement(13, 10, 10);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(14, 5, 1);
		summary.addHourlyMeasurement(measurement2);

		int result = summary.getLowestFahrenheitTemperature();

		assertEquals(5, result);
	}

	@Test
	public void testLowTemperatureShouldBeMiddleMeasurement() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 10, 1);
		summary.addHourlyMeasurement(measurement0);
		HourlyMeasurement measurement1 = new HourlyMeasurement(13, 5, 10);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(14, 20, 1);
		summary.addHourlyMeasurement(measurement2);

		int result = summary.getLowestFahrenheitTemperature();

		assertEquals(5, result);
	}
}
