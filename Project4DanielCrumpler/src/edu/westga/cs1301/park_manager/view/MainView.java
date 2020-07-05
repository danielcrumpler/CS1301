package edu.westga.cs1301.park_manager.view;

import java.net.URL;
import java.util.ResourceBundle;
import edu.westga.cs1301.park_manager.model.Zoo;
import edu.westga.cs1301.park_manager.model.Animal;
import edu.westga.cs1301.park_manager.model.FeedingSchedule;
import edu.westga.cs1301.park_manager.model.ScheduleList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Code-behind for the MainView
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class MainView {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextArea output;
	@FXML
	private TextField foodWeight;
	@FXML
	private TextField animalType;

	private Zoo theZoo;
	private FeedingSchedule theSchedule;
	private ScheduleList theHistory;

	/**
	 * Add a new animal with the specified type and weight of food needed to zoo.
	 * 
	 * @param event not used
	 */
	@FXML
	public void addAnimalToUnfedList(ActionEvent event) {
		ZooFormatter formatter = new ZooFormatter();
		String type = this.animalType.getText();
		String foodWeightString = this.foodWeight.getText();
		int weight = Integer.parseInt(foodWeightString);
		Animal animal = new Animal(type, weight);
		this.theZoo.addAnimal(animal);
		String formattedZooString = formatter.formatUnfedList(this.theZoo);
		this.output.setText(formattedZooString);
	}

	/**
	 * Remove the animal with the specified type and weight of food needed from zoo.
	 * 
	 * @param event not used
	 */
	@FXML
	public void removeAnimalFromUnfedList(ActionEvent event) {
		String type = this.animalType.getText();
		String foodWeightString = this.foodWeight.getText();
		int weight = Integer.parseInt(foodWeightString);
		this.theZoo.removeAnimal(type, weight);
		ZooFormatter formatter = new ZooFormatter();
		String formattedZooString = formatter.formatUnfedList(this.theZoo);
		this.output.setText(formattedZooString);
	}

	/**
	 * Display the unfed zoo animals using the following format:
	 * 
	 * BEGIN <zoo name> UNFED LIST ANIMAL <first animal type> that eats <first
	 * animal's food weight> ANIMAL <second animal type> that eats <second animal's
	 * food weight> END <zoo name> UNFED LIST
	 * 
	 * @param event not used
	 */
	@FXML
	public void displayUnfedList(ActionEvent event) {
		ZooFormatter formatter = new ZooFormatter();
		String formattedZooString = formatter.formatUnfedList(this.theZoo);
		this.output.setText(formattedZooString);
	}

	/**
	 * Display the current feeding schedule using the following format:
	 * 
	 * FEEDING SCHEDULE (<total number of animals to be fed>) BEGIN ANIMAL <first
	 * animal type> that eats <first animal's food weight> ANIMAL <second animal
	 * type> that eats <second animal's food weight> FEEDING SCHEDULE END
	 * 
	 * @param event not used
	 */
	@FXML
	public void displayFeedingSchedule(ActionEvent event) {
		ZooFormatter formatter = new ZooFormatter();
		String formattedZooStrings = formatter.formatFeedingSchedule(this.theSchedule);
		this.output.setText(formattedZooStrings);
	}

	/**
	 * Add the first animal with the specified type to the current feeding schedule,
	 * and remove it from zoo.
	 * 
	 * @param event not used
	 */
	@FXML
	public void addAnimalToFeedingSchedule(ActionEvent event) {
		ZooFormatter formatter = new ZooFormatter();
		String type = this.animalType.getText();
		String foodWeightString = this.foodWeight.getText();
		int weight = Integer.parseInt(foodWeightString);
		Animal animal = new Animal(type, weight);
		this.theSchedule.addAnimal(animal);
		String formattedZooStrings = formatter.formatFeedingSchedule(this.theSchedule);
		this.output.setText(formattedZooStrings);
	}

	/**
	 * Complete the current feeding schedule. Causes the current feeding schedule to
	 * be added to the list of schedules and reset to a new, empty feeding schedule.
	 * 
	 * @param event not used
	 */
	@FXML
	public void completeFeedingSchedule(ActionEvent event) {
		ZooFormatter formatter = new ZooFormatter();
		this.theHistory.addSchedule(this.theSchedule);
		this.theSchedule.removeAllAnimals();
		String formattedZooString = formatter.formatFeedingSchedule(this.theSchedule);
		this.output.setText(formattedZooString);
	}

	/**
	 * Cancel the current feeding schedule. Causes all animals in the current
	 * feeding schedule to be returned to zoo, and the current feeding schedule is
	 * reset to a new, empty feeding schedule.
	 * 
	 * @param event not used
	 */
	@FXML
	public void cancelFeedingSchedule(ActionEvent event) {
		ZooFormatter formatter = new ZooFormatter();
		for (int i = this.theSchedule.getNumberOfFeedingSchedule(); i > 0; i--) {
			Animal animal1 = this.theSchedule.createAnAnimal();
			this.theZoo.addAnimal(animal1);
			this.theSchedule.removeAnimal(animal1.getType(), animal1.getPoundsOfFoodNeeded());
		}
		String formattedZooString = formatter.formatFeedingSchedule(this.theSchedule);
		this.output.setText(formattedZooString);
	}

	/**
	 * Display the feeding schedule list using the following format:
	 * 
	 * SCHEDULE LIST (<total number of feeding schedules in list>) BEGIN <First
	 * Feeding Schedule> <Second Feeding Schedule> SCHEDULE LIST END
	 * 
	 * NOTE: Feeding schedules should formatted as in displayFeedingSchedule
	 * 
	 * @param event not used
	 */
	@FXML
	public void displayScheduleList(ActionEvent event) {
		ZooFormatter formatter = new ZooFormatter();
		String formattedZooStrings = formatter.formatFeedingHistory(this.theHistory);
		this.output.setText(formattedZooStrings);
	}

	/**
	 * Initialize the MainView
	 * 
	 */
	@FXML
	public void initialize() {
		assert this.output != null : "fx:id=\"output\" was not injected: check your FXML file 'MainView.fxml'.";
		assert this.foodWeight != null : "fx:id=\"foodWeight\" was not injected: check your FXML file 'MainView.fxml'.";
		assert this.animalType != null : "fx:id=\"animalType\" was not injected: check your FXML file 'MainView.fxml'.";

		this.theZoo = new Zoo("UWG Zoo");
		this.theSchedule = new FeedingSchedule();
		this.theHistory = new ScheduleList();
	}

}
