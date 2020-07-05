package edu.westga.cs1301.weather.test.weatherlocation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.WeatherLocation;

public class TestAddDailyRecord {

	@Test
	public void testNotAddNull() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		assertThrows(IllegalArgumentException.class, () -> location1.addDailyRecord(null));
	}

	@Test
	public void testNotAddDuplicate() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day1 = new DailyRecord(1, 1, 2017);
		location1.addDailyRecord(day1);

		DailyRecord day2 = new DailyRecord(1, 1, 2017);
		assertThrows(IllegalArgumentException.class, () -> location1.addDailyRecord(day2));
	}

	@Test
	public void testAddSingleDailyRecord() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day1 = new DailyRecord(1, 1, 2017);
		boolean result = location1.addDailyRecord(day1);

		assertTrue(result);
	}

	@Test
	public void testAddMultipleDailyRecord() {
		WeatherLocation location1 = new WeatherLocation("Atlanta");
		DailyRecord day1 = new DailyRecord(1, 1, 2017);
		boolean result1 = location1.addDailyRecord(day1);
		DailyRecord day2 = new DailyRecord(1, 2, 2017);
		boolean result2 = location1.addDailyRecord(day2);
		DailyRecord day3 = new DailyRecord(1, 3, 2017);
		boolean result3 = location1.addDailyRecord(day3);
		assertTrue(result1);
		assertTrue(result2);
		assertTrue(result3);
	}
}
