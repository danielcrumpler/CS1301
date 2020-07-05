package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;

public class TestGetTotalRainfall {

	@Test
	public void testGetTotalWhenNoHourlyMeasurements() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);

		int result = summary.getTotalRainfall();

		assertEquals(0, result);
	}

	@Test
	public void testGetTotalWhenOnlyHasOneMeasurement() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);

		int result = summary.getTotalRainfall();

		assertEquals(1, result);
	}

	@Test
	public void testGetTotalWhenHasManyMeasurements() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(13, 90, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(14, 50, 1);
		summary.addHourlyMeasurement(measurement3);

		int result = summary.getTotalRainfall();

		assertEquals(3, result);
	}
}