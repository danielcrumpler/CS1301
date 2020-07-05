package edu.westga.cs1301.weather.test.weatherlocation;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;
import edu.westga.cs1301.weather.model.WeatherLocation;

public class TestCountDangerouslyHotDays {

	@Test
	public void testWithNoMeasurements() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");

		int result = location1.countDangerouslyHotDays();

		assertEquals(0, result);
	}

	@Test
	public void testSingleMeasurementOneBelowDangerouslyHot() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 109, 1);
		day0.addHourlyMeasurement(measurement0);
		location1.addDailyRecord(day0);

		int result = location1.countDangerouslyHotDays();

		assertEquals(0, result);
	}

	@Test
	public void testSingleMeasurementAtDangerouslyHot() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 110, 1);
		day0.addHourlyMeasurement(measurement0);
		location1.addDailyRecord(day0);

		int result = location1.countDangerouslyHotDays();

		assertEquals(1, result);
	}

	@Test
	public void testSingleMeasurementOneAboveDangerouslyHot() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 111, 1);
		day0.addHourlyMeasurement(measurement0);
		location1.addDailyRecord(day0);

		int result = location1.countDangerouslyHotDays();

		assertEquals(1, result);
	}

	@Test
	public void testMultipleMeasurementsAllAboveDangerouslyHot() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 120, 1);
		DailyRecord day1 = new DailyRecord(1, 2, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 120, 1);
		DailyRecord day2 = new DailyRecord(1, 3, 2017);
		HourlyMeasurement measurement2 = new HourlyMeasurement(12, 120, 1);
		day0.addHourlyMeasurement(measurement0);
		day1.addHourlyMeasurement(measurement1);
		day2.addHourlyMeasurement(measurement2);
		location1.addDailyRecord(day0);
		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);

		int result = location1.countDangerouslyHotDays();

		assertEquals(3, result);
	}

	@Test
	public void testMultipleMeasurementsAllBelowDangerouslyHot() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 90, 1);
		DailyRecord day1 = new DailyRecord(1, 2, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		DailyRecord day2 = new DailyRecord(1, 3, 2017);
		HourlyMeasurement measurement2 = new HourlyMeasurement(12, 70, 1);
		day0.addHourlyMeasurement(measurement0);
		day1.addHourlyMeasurement(measurement1);
		day2.addHourlyMeasurement(measurement2);
		location1.addDailyRecord(day0);
		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);

		int result = location1.countDangerouslyHotDays();

		assertEquals(0, result);
	}

	@Test
	public void testMultipleMeasurementsSomeAboveDangerouslyHot() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 120, 1);
		DailyRecord day1 = new DailyRecord(1, 2, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		DailyRecord day2 = new DailyRecord(1, 3, 2017);
		HourlyMeasurement measurement2 = new HourlyMeasurement(12, 125, 1);
		day0.addHourlyMeasurement(measurement0);
		day1.addHourlyMeasurement(measurement1);
		day2.addHourlyMeasurement(measurement2);
		location1.addDailyRecord(day0);
		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);

		int result = location1.countDangerouslyHotDays();

		assertEquals(2, result);
	}
}
