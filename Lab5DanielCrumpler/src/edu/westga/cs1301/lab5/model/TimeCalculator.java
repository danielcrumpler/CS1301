package edu.westga.cs1301.lab5.model;

/**
 * This class can be used to perform some useful calculations with time.
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TimeCalculator {
	/**
	 * Converts the total number of seconds into a more readable time in the form:
	 * H:M:S where H = the number of hours M = the number of minutes S = the number
	 * of seconds Example: If totalSeconds is 12,345 then that is:
	 * 
	 * 3 hours (10,800 seconds) 25 minutes (+1,500 seconds) 45 seconds (+45, for a
	 * total of 12,345)
	 * 
	 * this produces the String: 3:25:45
	 * 
	 * @precondition totalSeconds >= 0
	 * @postcondition none
	 * 
	 * @param totalSeconds the total number of seconds to be converted
	 * @param totalMinutes the total number of minutes
	 * @param totalHours   the total number of hours
	 * @return the time formatted as specified above
	 */
	public String getTimeBreakdown(int totalSeconds) {
		if (totalSeconds < 60) {
			return "0:0:" + totalSeconds;
		} else if (totalSeconds >= 60 && totalSeconds <= 3599) {
			int totalMinutes = totalSeconds / 60;
			totalSeconds = totalSeconds - (totalMinutes * 60);
			return "0:" + totalMinutes + ":" + totalSeconds;
		} else if (totalSeconds >= 3600) {
			int totalHours = totalSeconds / 3600;
			totalSeconds = totalSeconds - (totalHours * 3600);
			int totalMinutes = totalSeconds / 60;
			totalSeconds = totalSeconds - (totalMinutes * 60);
			return totalHours + ":" + totalMinutes + ":" + totalSeconds;
		}
		return "0:0:0";
	}

	/**
	 * Returns the average time for a biathlete on a team. The average time is just
	 * the total seconds for the entire team, plus any penalties, divided by the
	 * number of team members. Notes: Each penalty is worth 15 seconds additional
	 * time. Time averages will truncate fractional parts of a second
	 * 
	 * @precondition totalSeconds >= 0 and totalOfPenalties >= 0 and
	 *               numberOfTeammates >= 1
	 * @postcondition none
	 * 
	 * @param totalSeconds      total seconds elapsed skiing for the team
	 * @param numberOfPenalties total number of penalties for the team
	 * @param numberOfTeammates total number of members on the team
	 * @param totalTime       	total time
	 * @param averageTime       total time averaged together due to number of team members
	 * 
	 * @return the average time per person on the team
	 */
	public String getBiathlonAverage(int totalSeconds, int numberOfPenalties, int numberOfTeammates) {
		int totalTime = totalSeconds + (numberOfPenalties * 15);
		int averageTime = totalTime / numberOfTeammates;
		return this.getTimeBreakdown(averageTime);
	}

	/**
	 * Calculates the distance covered by an object moving the given speed for a
	 * given distance. The speed must be adjusted based on the wind speed, either in
	 * the same direction as the object is moving (positive), or against the object
	 * (negative)
	 *
	 * @precondition numberOfSeconds >= 0 and objectSpeed >= 0 and speeds are in
	 *               same units/second
	 *
	 * @param numberOfSeconds the number of seconds going at the speed specified
	 * @param objectSpeed     the object's speed
	 * @param windSpeed       the wind speed
	 * @param totalTime       the total time
	 *
	 * @return the distance covered
	 */
	public double getDistanceMoved(int totalSeconds, double objectSpeed, double windSpeed) {
		double totalTime = totalSeconds * (objectSpeed + windSpeed);
		return totalTime;
	}

}
