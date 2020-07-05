package edu.westga.cs1301.weather.test.dailyrecord;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs1301.weather.model.DailyRecord;

public class TestConstructor {

	@Test
	public void testWhenHaveNoMeasurementsInNewDailyRecord() {
		DailyRecord summary = new DailyRecord(1, 1, 2017);

		assertTrue(summary.getTheHourlyMeasurements().isEmpty());
	}
}
