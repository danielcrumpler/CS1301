package edu.westga.cs1301.lab6.model;

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
	 * @return the time formatted as specified above
	 */
	public String getTimeBreakdown(int totalSeconds) {
		if (totalSeconds < 0) {
			throw new IllegalArgumentException("Time must be >= 0.");
		}
		int hours = totalSeconds / 3600;
		int minutes = totalSeconds % 3600 / 60;
		int seconds = totalSeconds % 3600 % 60;
		return hours + ":" + minutes + ":" + seconds;
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
	 * 
	 * @return the average time per person on the team
	 */
	public String getBiathlonAverage(int totalSeconds, int numberOfPenalties, int numberOfTeammates) {
		if (totalSeconds < 0) {
			throw new IllegalArgumentException("Time must be >= 0.");
		}
		if (numberOfPenalties < 0) {
			throw new IllegalArgumentException("Penalties must be >= 0.");
		}
		if (numberOfTeammates < 1) {
			throw new IllegalArgumentException("Teammates must be >= 1.");
		}
		int totalTime = totalSeconds + (numberOfPenalties * 15);
		int averageTime = totalTime / numberOfTeammates;
		return this.getTimeBreakdown(averageTime);
	}

	/**
	 * Calculates the distance covered by an object moving the given speed for a
	 * given distance. The speed must be adjusted based on the windspeed, either in
	 * the same direction as the object is moving (positive), or against the object
	 * (negative)
	 * 
	 * @precondition numberOfSeconds >= 0 and objectSpeed >= 0 and speeds are in
	 *               same units/second
	 * 
	 * @param numberOfSeconds the number of seconds going at the speed specified
	 * @param objectSpeed     the object's speed
	 * @param windSpeed       the wind speed
	 * 
	 * @return the distance covered
	 */
	public double getDistanceMoved(int numberOfSeconds, double objectSpeed, double windSpeed) {
		if (numberOfSeconds < 0) {
			throw new IllegalArgumentException("Time must be >= 0.");
		}
		if (objectSpeed < 0) {
			throw new IllegalArgumentException("objectSpeed must be >= 0.");
		}
		return numberOfSeconds * (objectSpeed + windSpeed);
	}

	/**
	 * Returns the number of seconds needed to complete the lap specified based on
	 * the skier's first lap time, given that the skier slows down by the rate
	 * specified per lap For example, if the skier's first lap is 10.0 seconds and
	 * their slow rate is 10%, then they would have a second lap time of 9.0 (10.0 -
	 * 10% * 10.0) and a third lap time of 8.1 (10 - 10% * 10.0 - 10% * 9.0)
	 * 
	 * @precondition initialLapTime > 0 and slowRate >= 0 and 0 < lapNumber <= 5
	 * 
	 * @param firstLapTime the skier's first lap time
	 * @param slowRate     the skier's rate slowed per lap
	 * @param lapNumber    the lap to determine the time for
	 * @param lapTime	   total time of lap
	 * @param i            declares that if the lap number is greater then 1 run loop.
	 * 
	 * @return the specified lap's time, based on slow rate provided
	 */
	public double getLapTime(double firstLapTime, double slowRate, int lapNumber) {
		if (firstLapTime < 0.0) {
			throw new IllegalArgumentException("firstLapTime must be >= 0.0.");
		}
		if (lapNumber < 1 || lapNumber > 5) {
			throw new IllegalArgumentException("lapNumber must be >= 1 && <= 5.");
		}
		double lapTime = firstLapTime;
		for (int i = 1; i < lapNumber; i++) {
			lapTime = lapTime + (lapTime * slowRate);
		}
		return lapTime;
	}

	/**
	 * Returns a listing of laps and lap times based on a first lap time and slow
	 * rate specified, for the number of laps provided
	 * 
	 * @precondition initialLapTime > 0 and slowRate >= 0
	 * 
	 * @param firstLapTime the skier's first lap time
	 * @param slowRate     the skier's rate slowed per lap
	 * 
	 * @return the skier's laps and lap times
	 */
	public String createTimeTable(double firstLapTime, double slowRate) {
		if (firstLapTime <= 0.0) {
			throw new IllegalArgumentException("firstLapTime must be > 0.0.");
		}
		if (slowRate < 0.0) {
			throw new IllegalArgumentException("slowRate must be >= 0.0.");
		}
		double lapTime = firstLapTime;
		int lapNumber = 1 ;
		String timeTable = "Lap Number, Lap Time\n" + lapNumber + ", " + firstLapTime + "\n";
		for (lapNumber = 2 ; lapNumber < 6; lapNumber++) {
			lapTime = lapTime + (lapTime * slowRate);
			timeTable = timeTable + lapNumber + ", " + lapTime + "\n";
		}
		return timeTable;
	}
}
