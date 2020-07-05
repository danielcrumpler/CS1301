package edu.westga.cs1301.weather.test.weatherlocation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;
import edu.westga.cs1301.weather.model.WeatherLocation;

public class TestRemoveRecords {

	@Test
	public void testPreconditionsUnder() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(2, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 3);
		day0.addHourlyMeasurement(measurement0);

		assertThrows(IllegalArgumentException.class, () -> location1.removeRecord(-1, 2018));
	}

	@Test
	public void testPreconditionsOver() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(2, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 3);
		day0.addHourlyMeasurement(measurement0);

		assertThrows(IllegalArgumentException.class, () -> location1.removeRecord(13, 2018));
	}
	
	@Test
	public void testRemoveOneMeasurement() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(2, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 3);
		day0.addHourlyMeasurement(measurement0);

		location1.addDailyRecord(day0);
		assertTrue(location1.hasDailyRecord(2, 2017));

		location1.removeRecord(2, 2017);
		assertFalse(location1.hasDailyRecord(2, 2017));
	}

	@Test
	public void testRemoveMultipleMeasurementsInSameMonth() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day1 = new DailyRecord(2, 1, 2017);
		DailyRecord day2 = new DailyRecord(2, 2, 2017);
		DailyRecord day3 = new DailyRecord(2, 3, 2017);

		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);
		location1.addDailyRecord(day3);
		assertTrue(location1.hasDailyRecord(2, 2017));

		location1.removeRecord(2, 2017);
		assertFalse(location1.hasDailyRecord(2, 2017));
	}

	@Test
	public void testRemoveMultipleMeasurementsSomeInSameMonth() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day1 = new DailyRecord(2, 1, 2017);
		DailyRecord day2 = new DailyRecord(2, 2, 2017);
		DailyRecord day3 = new DailyRecord(3, 3, 2018);

		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);
		location1.addDailyRecord(day3);
		assertTrue(location1.hasDailyRecord(2, 2017));

		location1.removeRecord(2, 2017);
		assertFalse(location1.hasDailyRecord(2, 2017));
		assertTrue(location1.hasDailyRecord(3, 2018));
	}
}