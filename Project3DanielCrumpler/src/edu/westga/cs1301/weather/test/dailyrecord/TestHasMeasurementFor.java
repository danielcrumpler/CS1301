package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;

public class TestHasMeasurementFor {

	@Test
	public void testNotAllowBorderCaseHourOfNegativeOne() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		assertThrows(IllegalArgumentException.class, () -> summary.hasMeasurementFor(-1));
	}

	@Test
	public void testNotAllowNegativeHour() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		assertThrows(IllegalArgumentException.class, () -> summary.hasMeasurementFor(-5));
	}

	@Test
	public void testNotAllowBorderCaseHourOf24() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		assertThrows(IllegalArgumentException.class, () -> summary.hasMeasurementFor(24));
	}

	@Test
	public void testNotAllowHourGreaterThan23() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		assertThrows(IllegalArgumentException.class, () -> summary.hasMeasurementFor(30));
	}

	@Test
	public void testHaveMeasurementAtBorderCaseOfHourZero() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement = new HourlyMeasurement(0, 80, 1);
		summary.addHourlyMeasurement(measurement);

		boolean result = summary.hasMeasurementFor(0);

		assertTrue(result);
	}

	@Test
	public void testHaveMeasurementAtBorderCaseOfHour23() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement = new HourlyMeasurement(23, 80, 1);
		summary.addHourlyMeasurement(measurement);

		boolean result = summary.hasMeasurementFor(23);

		assertTrue(result);
	}

	@Test
	public void testHaveSingleMeasurement() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement);

		boolean result = summary.hasMeasurementFor(12);

		assertTrue(result);
	}

	@Test
	public void testEmptySummaryShouldNotHaveMeasurement() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);

		boolean result = summary.hasMeasurementFor(12);

		assertFalse(result);
	}

	@Test
	public void testHaveFirstMeasurement() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(4, 80, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(15, 80, 1);
		summary.addHourlyMeasurement(measurement3);

		boolean result = summary.hasMeasurementFor(12);

		assertTrue(result);
	}

	@Test
	public void testHaveMiddleMeasurement() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(4, 80, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(15, 80, 1);
		summary.addHourlyMeasurement(measurement3);

		boolean result = summary.hasMeasurementFor(4);

		assertTrue(result);
	}

	@Test
	public void testHaveLastMeasurement() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(4, 80, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(15, 80, 1);
		summary.addHourlyMeasurement(measurement3);

		boolean result = summary.hasMeasurementFor(15);

		assertTrue(result);
	}

	@Test
	public void testNotHaveMeasurement() {
		DailyRecord summary = new DailyRecord(9, 15, 2017);
		HourlyMeasurement measurement1 = new HourlyMeasurement(12, 80, 1);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(4, 80, 1);
		summary.addHourlyMeasurement(measurement2);
		HourlyMeasurement measurement3 = new HourlyMeasurement(15, 80, 1);
		summary.addHourlyMeasurement(measurement3);

		boolean result = summary.hasMeasurementFor(10);

		assertFalse(result);
	}
}
