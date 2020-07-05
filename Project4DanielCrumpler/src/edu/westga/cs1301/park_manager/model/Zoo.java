package edu.westga.cs1301.park_manager.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store and manage the feeding schedules for a zoo
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class Zoo {
	private static final String ANIMAL_TYPE_MUST_NOT_BE_EMPTY = "animal type must not be empty";
	private static final String ANIMAL_TYPE_MUST_NOT_BE_NULL = "animal type must not be null";

	private String name;
	private ArrayList<Animal> unfedList;

	/**
	 * Create a new empty zoo
	 * 
	 * @precondition name != null && !name.isEmpty()
	 * @postcondition size() == 0 && getAnimals().size() == 0
	 * 
	 * @param name the zoo's name
	 */
	public Zoo(String name) {
		if (name == null) {
			throw new IllegalArgumentException("zoo name cannot be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("zoo name cannot be empty");
		}
		this.name = name;
		this.unfedList = new ArrayList<Animal>();
	}

	/**
	 * Return the collection of unfed animals at the zoo
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the collection of unfed animals at the zoo
	 */
	public ArrayList<Animal> getAnimals() {
		return this.unfedList;
	}

	/**
	 * Returns the name of this zoo
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the zoo
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the number of unfed animals at the zoo
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of unfed animals at the zoo
	 */
	public int getNumberOfUnfedAnimals() {
		return this.unfedList.size();
	}

	/**
	 * Add a new animal to the unfed list
	 * 
	 * @precondition theAnimal != null
	 * @postcondition getUnfedList().size() == getUnfedList.size()@pre + 1
	 * 
	 * @param theAnimal animal to be added to the unfed list at the zoo
	 */
	public void addAnimal(Animal theAnimal) {
		if (theAnimal == null) {
			throw new IllegalArgumentException("animal must not be null");
		}
		this.unfedList.add(theAnimal);
	}

	/**
	 * Remove a new animal to the unfed list
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
		Iterator<Animal> iterator = this.unfedList.iterator();
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
	 * Find first animal in the unfed list at the zoo with the type specified
	 * 
	 * @precondition animalType != null && !animalType.isEmpty()
	 * @postcondition none
	 * 
	 * @param animalType animal type to check for
	 * 
	 * @return null if an animal with the specified type is NOT in the unfed list
	 *         the first animal with the specified type if an animal with the
	 *         specified name is in the unfed list
	 */
	public Animal findFirstAnimalWithType(String animalType) {
		if (animalType == null) {
			throw new IllegalArgumentException(ANIMAL_TYPE_MUST_NOT_BE_NULL);
		}
		if (animalType.isEmpty()) {
			throw new IllegalArgumentException(ANIMAL_TYPE_MUST_NOT_BE_EMPTY);
		}

		for (Animal currentAnimal : this.unfedList) {
			if (currentAnimal.getType().equals(animalType)) {
				return currentAnimal;
			}
		}

		return null;
	}

}
