package edu.westga.cs1301.weather.test.weatherlocation;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.weather.model.WeatherLocation;

public class TestConstructor {

	@Test
	public void testShouldNotAllowNullLocationNameInNewWeatherLocation() {
		assertThrows(IllegalArgumentException.class, () -> new WeatherLocation(null));
	}

	@Test
	public void testShouldNotAllowEmptyLocationNameInNewWeatherLocation() {
		assertThrows(IllegalArgumentException.class, () -> new WeatherLocation(""));
	}

	@Test
	public void testGetTemperatureWhenNoHourlyMeasurements() {
		WeatherLocation place = new WeatherLocation("Atlanta");
		String result = place.getLocationName();
		assertEquals("Atlanta", result);
	}

	@Test
	public void testWhenHaveNoMeasurementsInNewWeatherLocation() {
		WeatherLocation place = new WeatherLocation("Atlanta");
		String result = place.getLocationName();
		assertEquals("Atlanta", result);
		assertTrue(place.getDailyRecords().isEmpty());
	}
}
