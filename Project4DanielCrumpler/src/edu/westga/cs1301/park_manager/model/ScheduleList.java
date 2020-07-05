package edu.westga.cs1301.park_manager.model;

import java.util.ArrayList;

/**
 * Store and manage the feeding schedules for a zoo
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class ScheduleList {

	private ArrayList<FeedingSchedule> feedingHistory;

	/**
	 * Return the collection of feeding history for animals at the zoo
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the collection of feeding schedule for animals at the zoo
	 */
	public ArrayList<FeedingSchedule> getFeedingSchedule() {
		return this.feedingHistory;
	}

	/**
	 * Return the number of feeding history at the zoo
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of feeding history at the zoo
	 */
	public int getNumberOfFeedingSchedule() {
		return this.feedingHistory.size();
	}

	/**
	 * Create a new empty ScheduleList
	 * 
	 * @precondition none
	 * @postcondition size() == 0 && getAnimals().size() == 0
	 * 
	 */
	public ScheduleList() {
		this.feedingHistory = new ArrayList<FeedingSchedule>();
	}

	/**
	 * Add a new feeding schedule to the feeding history
	 * 
	 * @precondition theSchedule != null
	 * @postcondition getFeedingSchedule().size() == getFeedingSchedule.size()@pre +
	 *                1
	 * 
	 * @param theSchedule feeding schedule to be added to the feeding history at the
	 *                    zoo
	 */
	public void addSchedule(FeedingSchedule theSchedule) {
		if (theSchedule == null) {
			throw new IllegalArgumentException("schedule must not be null");
		}
		this.feedingHistory.add(theSchedule);
	}
}
