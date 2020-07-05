package edu.westga.cs1301.park_manager.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store and manage the feeding schedules for a zoo
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class FeedingSchedule {

	private ArrayList<Animal> feedingSchedule;

	/**
	 * Return the collection of feeding schedule for animals at the zoo
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the collection of feeding schedule for animals at the zoo
	 */
	public ArrayList<Animal> getFeedingSchedule() {
		return this.feedingSchedule;
	}

	/**
	 * Return the number of feeding animals at the zoo
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of feeding animals at the zoo
	 */
	public int getNumberOfFeedingSchedule() {
		return this.feedingSchedule.size();
	}

	/**
	 * Create a new empty feeding schedule
	 * 
	 * @precondition none
	 * @postcondition size() == 0 && getAnimals().size() == 0
	 * 
	 */
	public FeedingSchedule() {
		this.feedingSchedule = new ArrayList<Animal>();
	}

	/**
	 * Add a new animal to the feeding schedule
	 * 
	 * @precondition theAnimal != null
	 * @postcondition getFeedingSchedule().size() == getFeedingSchedule.size()@pre +
	 *                1
	 * 
	 * @param theAnimal animal to be added to the feeding schedule at the zoo
	 */
	public void addAnimal(Animal theAnimal) {
		if (theAnimal == null) {
			throw new IllegalArgumentException("animal must not be null");
		}
		this.feedingSchedule.add(theAnimal);
	}

	/**
	 * Calculates the total weight of the Feeding Schedule
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return Total calculated food weight
	 */
	public int calculateTotalFoodWeight() {
		int total = 0;
		for (Animal currentAnimal : this.feedingSchedule) {
			total += currentAnimal.getPoundsOfFoodNeeded();
		}
		return total;
	}

	/**
	 * Remove a new animal to the feeding schedule
	 * 
	 * @precondition theAnimal != null
	 * @postcondition getUnfedList().size() == getUnfedList.size()@pre - 1
	 * 
	 * @param type       Animal Type
	 * @param foodweight Weight of food
	 * 
	 * @return True if Animal is removed
	 */
	public boolean removeAnimal(String type, int foodweight) {
		if (type == null) {
			throw new IllegalArgumentException("animal cannot be null");
		}
		Iterator<Animal> iterator = this.feedingSchedule.iterator();
		while (iterator.hasNext()) {
			Animal animals = iterator.next();
			if (animals.getType().equals(type) && animals.getPoundsOfFoodNeeded() == foodweight) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes all animals from feeding schedule
	 * 
	 * @precondition none
	 * @postcondition all animals removed from feeding schedule
	 */
	public void removeAllAnimals() {
		Iterator<Animal> iterator = this.feedingSchedule.iterator();
		while (iterator.hasNext()) {
			Animal animals = iterator.next();
			if (animals.getPoundsOfFoodNeeded() > Integer.MIN_VALUE) {
				iterator.remove();
			}
		}
	}

	/**
	 * Creates a animal object
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return A animal object from list
	 */
	public Animal createAnAnimal() {
		String type = "";
		int weight = 0;
		Iterator<Animal> iterator = this.feedingSchedule.iterator();
		while (iterator.hasNext()) {
			Animal animals = iterator.next();
			if (animals.getPoundsOfFoodNeeded() > Integer.MIN_VALUE) {
				weight = animals.getPoundsOfFoodNeeded();
				type = animals.getType();
			}
		}
		Animal animal = new Animal(type, weight);
		return animal;
	}
}
