package edu.westga.cs1301.weather.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.text.DateFormatSymbols;

/**
 * Defines a weather location which will have a collection of DailyRecord
 * objects.
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class WeatherLocation {
	public static final int DANGEROUS_HIGH_TEMPERATURE = 110;

	private String locationName;
	private ArrayList<DailyRecord> theDailyRecords;

	/**
	 * Creates a new WeatherLocation, with no daily records, for the given location.
	 * 
	 * @precondition locationName != null
	 * @postcondition getLocationName()==locationName && getNumberofRecords()==0
	 * 
	 * @param locationName the name of the location
	 */
	public WeatherLocation(String locationName) {
		if (locationName == null) {
			throw new IllegalArgumentException("locationName can not be null");
		}
		if (locationName.isEmpty()) {
			throw new IllegalArgumentException("locationName can not be empty.");
		}
		this.locationName = locationName;
		this.theDailyRecords = new ArrayList<DailyRecord>();
	}

	/**
	 * Gets the location name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the location name
	 */
	public String getLocationName() {
		return this.locationName;
	}

	/**
	 * Sets the location name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param locationName the name of the location
	 */
	public void getLocationName(String locationName) {
		if (locationName == null) {
			throw new IllegalArgumentException("locationName cannot be null");
		}
		this.locationName.equalsIgnoreCase(locationName);
	}

	/**
	 * Gets all daily records
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the collection of daily records
	 */
	public ArrayList<DailyRecord> getDailyRecords() {
		return this.theDailyRecords;
	}

	/**
	 * Find a Daily Record in the Daily Record Array
	 * 
	 * @precondition month/day/year is a valid date
	 * @postcondition getYear()==year && getDay()==day && getMonth()==month &&
	 *                getNumberOfMeasurements()==0
	 * 
	 * @param month the month for this measurement
	 * @param day   the day-of-the-month for this measurement
	 * @param year  the year of this measurement
	 * 
	 * @return true if the dailyrecord is found
	 */
	public boolean hasDailyRecord(int day, int month, int year) {
		if (day <= 0) {
			throw new IllegalArgumentException("number must be greater than zero.");
		}
		for (DailyRecord currentDailyRecords : this.theDailyRecords) {
			if (currentDailyRecords.getMonth() == month && currentDailyRecords.getDay() == day
					&& currentDailyRecords.getYear() == year) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Find a Daily Record in the Daily Record Array
	 * 
	 * @precondition month/day/year is a valid date
	 * @postcondition getMonth()==month && getNumberOfMeasurements()==0
	 * 
	 * @param month the month for this measurement
	 * @param year  the year of this measurement
	 * 
	 * @return true if the dailyrecord is found
	 */
	public boolean hasDailyRecord(int month, int year) {
		for (DailyRecord currentDailyRecords : this.theDailyRecords) {
			if (currentDailyRecords.getMonth() == month && currentDailyRecords.getYear() == year) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a new application to theDailyRecords
	 * 
	 * @precondition dailyrecord != null && dailyrecord is not already present
	 * @postcondition getNumberOfDailyRecords() == getNumberOfDailyRecords()@prev +
	 *                1
	 * @param dailyrecord the DailyRecord to be added
	 * @return true if dailyrecord is added to the array
	 */
	public boolean addDailyRecord(DailyRecord dailyrecord) {
		if (dailyrecord == null) {
			throw new IllegalArgumentException("dailyrecord can not be null.");
		}
		for (DailyRecord currentDailyRecords : this.theDailyRecords) {
			if (currentDailyRecords.getMonth() == dailyrecord.getMonth()
					&& currentDailyRecords.getDay() == dailyrecord.getDay()
					&& currentDailyRecords.getYear() == dailyrecord.getYear()) {
				throw new IllegalArgumentException("dailyrecord can not have the same dailyrecord date.");
			}
		}
		this.theDailyRecords.add(dailyrecord);
		if (this.hasDailyRecord(dailyrecord.getDay(), dailyrecord.getMonth(), dailyrecord.getYear())) {
			return true;
		}
		return false;
	}

	/**
	 * Finds the highest daily record for a location.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the highest recorded daily record for a location, or
	 *         Integer.MIN_VALUE if no measurements recorded.
	 */
	public int getHighestFahrenheitTemperature() {
		int max = Integer.MIN_VALUE;

		for (DailyRecord currentDailyRecords : this.theDailyRecords) {
			if (currentDailyRecords.getHighestFahrenheitTemperature() > max) {
				max = currentDailyRecords.getHighestFahrenheitTemperature();
			}
		}

		return max;
	}

	/**
	 * Counts the number of hot dangerously hot days in a location
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return total number of dangerously hot days
	 */
	public int countDangerouslyHotDays() {
		int total = 0;
		for (DailyRecord currentDailyRecords : this.theDailyRecords) {
			if (currentDailyRecords.wasHighTemperatureOver(DANGEROUS_HIGH_TEMPERATURE - 1)) {
				total += 1;
			}
		}

		return total;
	}

	/**
	 * Gets the total rain for a time period.
	 * 
	 * @precondition startingmonth >= 1 && startingmonth <= 12 && endingmonth >= 1
	 *               && endingmonth <= 12
	 * @postcondition none
	 * 
	 * @param startingmonth The starting month
	 * @param startingyear  The starting year
	 * @param endingmonth   The ending month
	 * @param endingyear    The ending year
	 * 
	 * @return the total precipitation for the day
	 */
	public int getTotalRainfall(int startingmonth, int startingyear, int endingmonth, int endingyear) {
		if (startingmonth < 1 || startingmonth > 12 || endingmonth < 1 || endingmonth > 12) {
			throw new IllegalArgumentException("months must be between 1 and 12");
		}
		int total = 0;
		for (DailyRecord currentDailyRecords : this.theDailyRecords) {
			int currentmonth = currentDailyRecords.getMonth();
			int currentyear = currentDailyRecords.getYear();
			if (startingmonth <= currentmonth && currentmonth <= endingmonth && startingyear <= currentyear
					&& currentyear <= endingyear) {
				total += currentDailyRecords.getTotalRainfall();
			}
		}
		return total;
	}

	/**
	 * Converts month integer to name
	 * 
	 * precondition none postcondition none
	 * 
	 * @param month month in integer form
	 * @return months name
	 */
	public String convertMonth(int month) {
		return new DateFormatSymbols().getMonths()[month - 1];
	}

	/**
	 * Finds the wettest month in a given year and returns it by name
	 * 
	 * @precondition theDailyRecord!=.isEmpty();
	 * @postcondition none
	 * 
	 * @param year year
	 * @return the wettest month by name
	 */
	public String getWettestMonthofYear(int year) {
		if (this.theDailyRecords.isEmpty()) {
			throw new IllegalArgumentException("Array cannot be empty");
		}
		int currentMaxRainfall = 0;
		int maxRainfall = 0;
		int maxMonth = 0;
		String months = "";
		for (int month = 0; month < 13; month++) {
			for (DailyRecord currentDailyRecords : this.theDailyRecords) {
				if (currentDailyRecords.getYear() == year) {
					if (currentDailyRecords.getMonth() == month) {
						maxRainfall += currentDailyRecords.getTotalRainfall();
					}
					if (currentMaxRainfall < maxRainfall) {
						currentMaxRainfall = maxRainfall;
						maxMonth = currentDailyRecords.getMonth();
					}
				}
			}

		}
		if (maxMonth == 0) {
			throw new IllegalArgumentException("There is no month that was the wettest");
		}
		months = this.convertMonth(maxMonth);
		return months;
	}

	/**
	 * Remove the records in the array from the give month and year
	 * 
	 * @precondition month >= 1 && month <= 12
	 * @postcondition Records are removed from the array
	 * 
	 * @param month Month to remove
	 * @param year  Year to remove
	 */
	public void removeRecord(int month, int year) {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("month must be between 1 and 12");
		}
		Iterator<DailyRecord> iterator = this.theDailyRecords.iterator();

		while (iterator.hasNext()) {
			DailyRecord records = iterator.next();

			if (records.getMonth() == month && records.getYear() == year) {
				iterator.remove();
			}
		}
	}
}