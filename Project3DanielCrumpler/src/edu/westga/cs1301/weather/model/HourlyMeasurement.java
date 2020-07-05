package edu.westga.cs1301.weather.model;

/**
 * Represents temperature and precipitation measurement taken at a time-of-day
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class HourlyMeasurement {
	public static final int MAX_FAHRENHEIT = 150;
	public static final int MIN_FAHRENHEIT = -150;
	public static final int MIN_HOUR = 0;
	public static final int MAX_HOUR = 23;

	private int hourOfDay;
	private int fahrenheitTemperature;
	private int inchesOfRain;

	/**
	 * Creates a new Measurement with the given values.
	 * 
	 * @precondition hourOfDay >= MIN_HOUR && hourOfDay <= MAX_HOUR &&
	 *               fahrenheitTemperature >= -MIN_FARENHEIT &&
	 *               fahrenheitTemperature <= MAX_FARENHEIT && inchesOfRain >= 0
	 * 
	 * @postcondition getHourOfDay()==hourOfDay &&
	 *                getFahrenheitTemperature()==fahrenheitTemperature &&
	 *                getInchesOfRain()==inchesOfRain
	 * 
	 * @param hourOfDay             the hour of the day, 24-hour clock (0 for 12am,
	 *                              12 for 12pm, 23 for 11pm, etc)
	 * @param fahrenheitTemperature the temperature in Fahrenheit
	 * @param inchesOfRain          the inches of rain that have fallen since the
	 *                              last measurement
	 * 
	 */
	public HourlyMeasurement(int hourOfDay, int fahrenheitTemperature, int inchesOfRain) {
		if (hourOfDay < HourlyMeasurement.MIN_HOUR || hourOfDay > HourlyMeasurement.MAX_HOUR) {
			throw new IllegalArgumentException("hourOfDay must be between 0 and 23 inclusive");
		}

		if (fahrenheitTemperature < HourlyMeasurement.MIN_FAHRENHEIT
				|| fahrenheitTemperature > HourlyMeasurement.MAX_FAHRENHEIT) {
			throw new IllegalArgumentException("tempInF must be between -150 and 150 inclusive");
		}

		if (inchesOfRain < 0) {
			throw new IllegalArgumentException("inchesOfRain must be at least 0");
		}

		this.hourOfDay = hourOfDay;
		this.fahrenheitTemperature = fahrenheitTemperature;
		this.inchesOfRain = inchesOfRain;
	}

	/**
	 * Gets the hour at which this measurement was made.
	 * 
	 * @return the hour at which this measurement was made.
	 */
	public int getHourOfDay() {
		return this.hourOfDay;
	}

	/**
	 * Gets the temperature in Fahrenheit
	 * 
	 * @return the temperature in Fahrenheit
	 */
	public int getFahrenheitTemperature() {
		return this.fahrenheitTemperature;
	}

	/**
	 * Gets the amount of rainfall, in inches, since the last measurement.
	 * 
	 * @return the amount of rainfall, in inches, since the last measurement.
	 */
	public int getInchesOfRain() {
		return this.inchesOfRain;
	}

	@Override
	public String toString() {
		return "HourlyMeasurement [hourOfDay=" + this.hourOfDay + ", fahrenheitTemperature="
				+ this.fahrenheitTemperature + ", inchesOfRain=" + this.inchesOfRain + "]";
	}

}
