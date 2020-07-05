package edu.westga.cs1301.weather.test.weatherlocation;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;
import edu.westga.cs1301.weather.model.WeatherLocation;

public class TestGetWettestMonthInAYear {

	@Test
	public void testWithNoRecords() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");

		assertThrows(IllegalArgumentException.class, () -> location1.getWettestMonthofYear(2017));
	}
	
	@Test
	public void testTotalRainfallOnOneMeasurement() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(2, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 3);
		day0.addHourlyMeasurement(measurement0);
		location1.addDailyRecord(day0);

		String result = location1.getWettestMonthofYear(2017);

		assertEquals("February", result);
	}
	
	@Test
	public void testTotalRainfallOnOneMeasurementNotInSpecificedYears() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(3, 1, 2018);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 3);
		day0.addHourlyMeasurement(measurement0);
		location1.addDailyRecord(day0);

		assertThrows(IllegalArgumentException.class, () -> location1.getWettestMonthofYear(2017));

	}
	
	@Test
	public void testTotalRainfallOnMultipleMeasurement() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 2);
		DailyRecord day1 = new DailyRecord(1, 2, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 50, 3);
		DailyRecord day2 = new DailyRecord(1, 3, 2017);
		HourlyMeasurement measurement2 = new HourlyMeasurement(12, 51, 3);
		day0.addHourlyMeasurement(measurement0);
		day1.addHourlyMeasurement(measurement1);
		day2.addHourlyMeasurement(measurement2);
		location1.addDailyRecord(day0);
		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);

		String result = location1.getWettestMonthofYear(2017);

		assertEquals("January", result);
	}
	
	@Test
	public void testTotalRainfallOnMultipleMeasurementSomeInPeriod() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day0 = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 100, 2);
		DailyRecord day1 = new DailyRecord(1, 2, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 50, 2);
		DailyRecord day2 = new DailyRecord(6, 3, 2017);
		HourlyMeasurement measurement2 = new HourlyMeasurement(12, 51, 3);
		DailyRecord day3 = new DailyRecord(6, 4, 2017);
		HourlyMeasurement measurement3 = new HourlyMeasurement(12, 51, 3);
		DailyRecord day4 = new DailyRecord(4, 3, 2018);
		HourlyMeasurement measurement4 = new HourlyMeasurement(12, 51, 3);
		day0.addHourlyMeasurement(measurement0);
		day1.addHourlyMeasurement(measurement1);
		day2.addHourlyMeasurement(measurement2);
		day3.addHourlyMeasurement(measurement3);
		day4.addHourlyMeasurement(measurement4);
		location1.addDailyRecord(day0);
		location1.addDailyRecord(day1);
		location1.addDailyRecord(day2);
		location1.addDailyRecord(day3);
		location1.addDailyRecord(day4);
		
		String result = location1.getWettestMonthofYear(2017);

		assertEquals("June", result);
	}
}
