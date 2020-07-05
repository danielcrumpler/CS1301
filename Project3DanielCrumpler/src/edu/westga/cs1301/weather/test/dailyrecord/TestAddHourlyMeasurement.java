package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import edu.westga.cs1301.weather.model.DailyRecord;
import edu.westga.cs1301.weather.model.HourlyMeasurement;

public class TestAddHourlyMeasurement {

	@Test
	public void testAddOneMeasurment() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement = new HourlyMeasurement(12, 90, 1);
		summary.addHourlyMeasurement(measurement);
		ArrayList<HourlyMeasurement> measurements = summary.getTheHourlyMeasurements();

		int result = summary.getNumberOfMeasurements();

		assertEquals(1, result);
		assertEquals(measurement, measurements.get(0));
	}

	@Test
	public void testAddManyMeasurements() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 90, 1);
		summary.addHourlyMeasurement(measurement0);
		HourlyMeasurement measurement1 = new HourlyMeasurement(13, 80, 10);
		summary.addHourlyMeasurement(measurement1);
		HourlyMeasurement measurement2 = new HourlyMeasurement(14, 70, 1);
		summary.addHourlyMeasurement(measurement2);

		int result = summary.getNumberOfMeasurements();

		assertEquals(3, result);

		ArrayList<HourlyMeasurement> measurements = summary.getTheHourlyMeasurements();

		assertEquals(measurement0, measurements.get(0));
		assertEquals(measurement1, measurements.get(1));
		assertEquals(measurement2, measurements.get(2));
	}

	@Test
	public void testNotAddIfHourAlreadyInSummary() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);

		HourlyMeasurement measurement0 = new HourlyMeasurement(12, 90, 1);
		summary.addHourlyMeasurement(measurement0);

		HourlyMeasurement duplicateHour = new HourlyMeasurement(12, 80, 10);
		assertThrows(IllegalArgumentException.class, () -> summary.addHourlyMeasurement(duplicateHour));
	}

	@Test
	public void testNotAddNull() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);

		assertThrows(IllegalArgumentException.class, () -> summary.addHourlyMeasurement(null));
	}

	@Test
	public void testNotAddIfAllHoursInSummary() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);
		for (int hourNumber = 0; hourNumber <= 23; hourNumber++) {
			HourlyMeasurement measurement = new HourlyMeasurement(hourNumber, 90, 1);
			summary.addHourlyMeasurement(measurement);
		}

		HourlyMeasurement invalidMeasurement = new HourlyMeasurement(12, 90, 1);
		assertThrows(IllegalArgumentException.class, () -> summary.addHourlyMeasurement(invalidMeasurement));
	}

}
