package edu.westga.cs1301.weather.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Summary of weather data for a particular day.
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class DailyRecord {
	public static final int FREEZING_POINT = 32;

	private LocalDate date;
	private ArrayList<HourlyMeasurement> theHourlyMeasurements;

	/**
	 * Creates a new DailyRecord, with no hourly measurements, for the given month,
	 * day, and year.
	 * 
	 * @precondition month/day/year is a valid date
	 * @postcondition getYear()==year && getDay()==day && getMonth()==month &&
	 *                getNumberOfMeasurements()==0
	 * 
	 * @param month the month for this measurement
	 * @param day   the day-of-the-month for this measurement
	 * @param year  the year of this measurement
	 */
	public DailyRecord(int month, int day, int year) {
		try {
			this.date = LocalDate.of(year, month, day);
		} catch (DateTimeException theException) {
			throw new IllegalArgumentException("Invalid date.");
		}

		this.theHourlyMeasurements = new ArrayList<HourlyMeasurement>();

	}

	/**
	 * Gets the year associated with this daily summary
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the year
	 */
	public int getYear() {
		return this.date.getYear();
	}

	/**
	 * Gets the month (as a number between 1 and 12) associated with this daily
	 * summary
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the month
	 */
	public int getMonth() {
		return this.date.getMonthValue();
	}

	/**
	 * Gets the day-of-the-month associated with this daily summary
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the day-of-the-month
	 */
	public int getDay() {
		return this.date.getDayOfMonth();
	}

	/**
	 * Gets the number of measurements for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of measurements for the day.
	 */
	public int getNumberOfMeasurements() {
		return this.theHourlyMeasurements.size();
	}

	/**
	 * Gets all the hourly measurements
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the collection of hourly measurements
	 */
	public ArrayList<HourlyMeasurement> getTheHourlyMeasurements() {
		return this.theHourlyMeasurements;
	}

	/**
	 * Adds an HourlyMeasurement to this summary.
	 * 
	 * @precondition measurement != null && measurement.getHourOfDay() does not
	 *               match the getHourOfDay() of an already-added measurement
	 * @postcondition getNumberOfMeasurements() = getNumberOfMeasurements()@prev + 1
	 * 
	 * @param measurement the measurement to add
	 * 
	 * @return true if added measurement, false otherwise.
	 */
	public boolean addHourlyMeasurement(HourlyMeasurement measurement) {

		if (measurement == null) {
			throw new IllegalArgumentException("measurement cannot be null.");
		}

		if (this.hasMeasurementFor(measurement.getHourOfDay())) {
			throw new IllegalArgumentException("Cannot add measurement for hour that already exits.");
		}

		return this.theHourlyMeasurements.add(measurement);

	}

	/**
	 * Checks if this DailyRecord already has an HourlyMeasurement for the given
	 * hour.
	 * 
	 * @precondition hour >= HourlyMeasurement.MIN_HOUR && hour <=
	 *               HourlyMeasurement.MAX_HOUR
	 * @postcondition none
	 * 
	 * @param hour the hour of the day, as a number from 0 (midnight) to 23 (11pm)
	 * @return true if an HourlyMeasurement with the given hour-of-day already
	 *         exists in this DailyRecord; false otherwise
	 */
	public boolean hasMeasurementFor(int hour) {

		if (hour < HourlyMeasurement.MIN_HOUR || hour > HourlyMeasurement.MAX_HOUR) {
			throw new IllegalArgumentException("Invalid hour.");
		}

		for (HourlyMeasurement hourlyMeasurement : this.theHourlyMeasurements) {
			if (hourlyMeasurement.getHourOfDay() == hour) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Finds the highest recorded temperature for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the highest recorded temperature for the day, or Integer.MIN_VALUE if
	 *         no measurements recorded.
	 */
	public int getHighestFahrenheitTemperature() {
		int max = Integer.MIN_VALUE;

		for (HourlyMeasurement hourlyMeasurement : this.theHourlyMeasurements) {
			if (hourlyMeasurement.getFahrenheitTemperature() > max) {
				max = hourlyMeasurement.getFahrenheitTemperature();
			}
		}

		return max;
	}

	/**
	 * Finds the lowest recorded temperature for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the lowest recorded temperature for the day, or Integer.MAX_VALUE if
	 *         no measurements recorded.
	 */
	public int getLowestFahrenheitTemperature() {
		int min = Integer.MAX_VALUE;

		for (HourlyMeasurement hourlyMeasurement : this.theHourlyMeasurements) {
			if (hourlyMeasurement.getFahrenheitTemperature() < min) {
				min = hourlyMeasurement.getFahrenheitTemperature();
			}
		}

		return min;
	}

	/**
	 * Gets the average of all recorded temperatures for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the average of all recorded temperatures for the day, or
	 *         Double.MIN_VALUE if no measurements recorded.
	 */
	public double getAverageTemperature() {
		if (this.theHourlyMeasurements.size() == 0) {
			return Double.MIN_VALUE;
		}

		double sum = 0;
		for (HourlyMeasurement hourlyMeasurement : this.theHourlyMeasurements) {
			sum += hourlyMeasurement.getFahrenheitTemperature();

		}

		return sum / this.theHourlyMeasurements.size();
	}

	/**
	 * Gets the total rain for the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the total precipitation for the day
	 */
	public int getTotalRainfall() {
		int total = 0;
		for (HourlyMeasurement hourlyMeasurement : this.theHourlyMeasurements) {
			total += hourlyMeasurement.getInchesOfRain();
		}

		return total;
	}

	/**
	 * Checks if the temperature for the day ever dropped to or below freezing for
	 * the day.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the temperature for the day dropped below freezing; false
	 *         otherwise
	 */
	public boolean hadFreezingTemperatures() {
		for (HourlyMeasurement hourlyMeasurement : this.theHourlyMeasurements) {
			if (hourlyMeasurement.getFahrenheitTemperature() <= FREEZING_POINT) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the temperature for this day was over the specified threshold
	 * passed to this method.
	 * 
	 * @precondition temperature >= HourlyMeasurement.FAHRENHEIT_MIN && temperature
	 *               <= HourlyMeasurement.FAHRENHEIT_MAX
	 * @postcondition none
	 * 
	 * @param temperature the threshold temperature
	 * @return true if this day's high was greater than temperature; false otherwise
	 */
	public boolean wasHighTemperatureOver(int temperature) {
		if (temperature > HourlyMeasurement.MAX_FAHRENHEIT || temperature < HourlyMeasurement.MIN_FAHRENHEIT) {
			throw new IllegalArgumentException("Temperature must be valid on scale");
		}

		for (HourlyMeasurement hourlyMeasurement : this.theHourlyMeasurements) {
			if (hourlyMeasurement.getFahrenheitTemperature() > temperature) {
				return true;
			}
		}
		return false;
	}

}
