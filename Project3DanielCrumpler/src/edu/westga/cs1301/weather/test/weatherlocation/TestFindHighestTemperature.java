package edu.westga.cs1301.weather.test.weatherlocation;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;
import edu.westga.cs1301.weather.model.WeatherLocation;

public class TestFindHighestTemperature {

	@Test
	public void testHighTemperatureShouldBeIntegerMinimumValueIfNoMeasurements() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");

		int result = location1.getHighestFahrenheitTemperature();

		assertEquals(Integer.MIN_VALUE, result);
	}

	@Test
	public void testHighTemperatureShouldBeOnlyMeasurement() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 1);
		day0.addHourlyMeasurement(measurement0);
		location1.addDailyRecord(day0);

		int result = location1.getHighestFahrenheitTemperature();

		assertEquals(100, result);
	}

	@Test
	public void testHighTemperatureShouldBeFirstMeasurement() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 1);
		DailyRecord day1 = new DailyRecord(1, 2, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 50, 1);
		DailyRecord day2 = new DailyRecord(1, 3, 2017);
		HourlyMeasurement measurement2 = new HourlyMeasurement(12, 51, 1);
		day0.addHourlyMeasurement(measurement0);
		day1.addHourlyMeasurement(measurement1);
		day2.addHourlyMeasurement(measurement2);
		location1.addDailyRecord(day0);
		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);

		int result = location1.getHighestFahrenheitTemperature();

		assertEquals(100, result);
	}

	@Test
	public void testHighTemperatureShouldBeLastMeasurement() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 51, 1);
		DailyRecord day1 = new DailyRecord(1, 2, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 50, 1);
		DailyRecord day2 = new DailyRecord(1, 3, 2017);
		HourlyMeasurement measurement2 = new HourlyMeasurement(12, 100, 1);
		day0.addHourlyMeasurement(measurement0);
		day1.addHourlyMeasurement(measurement1);
		day2.addHourlyMeasurement(measurement2);
		location1.addDailyRecord(day0);
		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);

		int result = location1.getHighestFahrenheitTemperature();

		assertEquals(100, result);
	}

	@Test
	public void testHighTemperatureShouldBeMiddleMeasurement() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 60, 1);
		DailyRecord day1 = new DailyRecord(1, 2, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 100, 1);
		DailyRecord day2 = new DailyRecord(1, 3, 2017);
		HourlyMeasurement measurement2 = new HourlyMeasurement(12, 51, 1);
		day0.addHourlyMeasurement(measurement0);
		day1.addHourlyMeasurement(measurement1);
		day2.addHourlyMeasurement(measurement2);
		location1.addDailyRecord(day0);
		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);

		int result = location1.getHighestFahrenheitTemperature();

		assertEquals(100, result);
	}
}