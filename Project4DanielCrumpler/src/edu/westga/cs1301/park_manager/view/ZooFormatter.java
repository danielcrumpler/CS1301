package edu.westga.cs1301.park_manager.view;

import java.util.Iterator;

import edu.westga.cs1301.park_manager.model.Animal;
import edu.westga.cs1301.park_manager.model.FeedingSchedule;
import edu.westga.cs1301.park_manager.model.ScheduleList;
import edu.westga.cs1301.park_manager.model.Zoo;

/**
 * Formatter for the Zoo GUI
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class ZooFormatter {

	/**
	 * A formatter for ANIMALS for the GUI
	 * 
	 * @precondition animal != null
	 * @postcondition none
	 * 
	 * @param animal A animal object
	 * @return Formatted ANIMAL String
	 */
	public String formatAnimal(Animal animal) {
		if (animal == null) {
			throw new IllegalArgumentException("Animal cannot be null");
		}
		return "ANIMAL " + animal.getType() + " that eats " + animal.getPoundsOfFoodNeeded() + " pounds";
	}

	/**
	 * A formatter for the ZOOS for the GUI
	 * 
	 * @precondition zoo != null
	 * @postcondition none
	 * 
	 * @param zoo A zoo object
	 * @return Formatted ZOO String
	 */
	public String formatUnfedList(Zoo zoo) {
		if (zoo == null) {
			throw new IllegalArgumentException("Zoo cannot be null");
		}
		String unfedlisttext = zoo.getName() + " UNFED LIST";
		String begintext = "BEGIN " + unfedlisttext + System.lineSeparator();
		String endtext = "END " + unfedlisttext;
		String animaltext = "";

		Iterator<Animal> iterator = zoo.getAnimals().iterator();

		while (iterator.hasNext()) {
			Animal animal = iterator.next();
			animaltext += "	 " + this.formatAnimal(animal) + System.lineSeparator();
		}
		return begintext + animaltext + endtext;

	}

	/**
	 * A formatter for the Feeding Schedule for the GUI
	 * 
	 * @precondition feedingschedule != null
	 * @postcondition none
	 * 
	 * @param feedingschedule A feeding schedule object
	 * @return Formatted Feeding Schedule string
	 */
	public String formatFeedingSchedule(FeedingSchedule feedingschedule) {
		if (feedingschedule == null) {
			throw new IllegalArgumentException("Feeding Schedule cannot be null");
		}
		String begintext = "FEEDING SCHEDULE " + feedingschedule.getNumberOfFeedingSchedule() + " BEGIN"
				+ System.lineSeparator();
		String endtext = "FEEDING SCHEDULE END";
		String animaltext = "";

		Iterator<Animal> iterator = feedingschedule.getFeedingSchedule().iterator();

		while (iterator.hasNext()) {
			Animal animal = iterator.next();
			animaltext += "	" + this.formatAnimal(animal) + System.lineSeparator();
		}
		return begintext + animaltext + endtext;
	}

	/**
	 * A formatter for the Feeding History for the GUI
	 * 
	 * @precondition feedinghistory != null
	 * @postcondition none
	 * 
	 * @param feedinghistory A feeding history object
	 * @return Formatted Feeding History String
	 */
	public String formatFeedingHistory(ScheduleList feedinghistory) {
		if (feedinghistory == null) {
			throw new IllegalArgumentException("Feeding History cannot be null");
		}
		String begintext = "SCHEDULE LIST " + feedinghistory.getNumberOfFeedingSchedule() + " BEGIN "
				+ System.lineSeparator();
		String endtext = "SCHEDULE LIST END";
		String animaltext = "";

		Iterator<FeedingSchedule> iterator = feedinghistory.getFeedingSchedule().iterator();

		while (iterator.hasNext()) {
			FeedingSchedule feedingschedule = iterator.next();
			animaltext += "   " + this.formatFeedingSchedule(feedingschedule) + System.lineSeparator();
		}
		return begintext + animaltext + endtext;
	}
}
