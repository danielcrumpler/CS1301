package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;

public class TestHadFreezingTemperatures {

	@Test
	public void testGetTemperatureWhenNoHourlyMeasurements() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);

		boolean result = summary.hadFreezingTemperatures();

		assertFalse(result);
	}

	@Test
	public void testOneMeasurementOneDegreeBelowFreezing() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 31, 1);
		summary.addHourlyMeasurement(measurement1);

		boolean result = summary.hadFreezingTemperatures();

		assertTrue(result);
	}

	@Test
	public void testOneMeasurementAtFreezing() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 32, 1);
		summary.addHourlyMeasurement(measurement1);

		boolean result = summary.hadFreezingTemperatures();

		assertTrue(result);
	}

	@Test
	public void testOneMeasurementOneDegreeAboveFreezing() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 33, 1);
		summary.addHourlyMeasurement(measurement1);

		boolean result = summary.hadFreezingTemperatures();

		assertFalse(result);
	}

	@Test
	public void testManyMeasurementsNoneBelowFreezing() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(13, 90, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(14, 50, 1);
		summary.addHourlyMeasurement(measurement3);

		boolean result = summary.hadFreezingTemperatures();

		assertFalse(result);
	}

	@Test
	public void testManyMeasurementsFirstBelowFreezing() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 30, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(13, 90, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(14, 50, 1);
		summary.addHourlyMeasurement(measurement3);

		boolean result = summary.hadFreezingTemperatures();

		assertTrue(result);
	}

	@Test
	public void testManyMeasurementsLastBelowFreezing() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(13, 90, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(14, 30, 1);
		summary.addHourlyMeasurement(measurement3);

		boolean result = summary.hadFreezingTemperatures();

		assertTrue(result);
	}

	@Test
	public void testManyMeasurementsMiddleBelowFreezing() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(13, 30, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(14, 50, 1);
		summary.addHourlyMeasurement(measurement3);

		boolean result = summary.hadFreezingTemperatures();

		assertTrue(result);
	}

	@Test
	public void testManyMeasurementsMoreThanOneFreezingButNotAll() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 28, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(13, 29, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(14, 30, 1);
		summary.addHourlyMeasurement(measurement3);
		HourlyMeasurement measurement4 = new HourlyMeasurement(15, 60, 1);
		summary.addHourlyMeasurement(measurement4);
		HourlyMeasurement measurement5 = new HourlyMeasurement(16, 70, 1);
		summary.addHourlyMeasurement(measurement5);

		boolean result = summary.hadFreezingTemperatures();

		assertTrue(result);
	}
}
