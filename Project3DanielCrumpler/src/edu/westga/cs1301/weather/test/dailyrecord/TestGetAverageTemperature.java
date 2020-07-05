package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;
import edu.westga.cs1301.weather.test.TestingConstants;

public class TestGetAverageTemperature {

	@Test
	public void testGetSentinelWhenNoHourlyMeasurements() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);

		double result = summary.getAverageTemperature();

		assertEquals(Double.MIN_VALUE, result, TestingConstants.DELTA);
	}

	@Test
	public void testGetAverageWhenOnlyHasOneMeasurement() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);

		double result = summary.getAverageTemperature();

		assertEquals(80, result, TestingConstants.DELTA);
	}

	@Test
	public void testGetAverageWhenHasManyMeasurements() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(13, 90, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(14, 50, 1);
		summary.addHourlyMeasurement(measurement3);

		double result = summary.getAverageTemperature();

		assertEquals(73.3333333, result, TestingConstants.DELTA);
	}
}
