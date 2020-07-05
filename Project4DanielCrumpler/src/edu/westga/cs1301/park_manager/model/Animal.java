package edu.westga.cs1301.park_manager.model;

/**
 * Store information for a single Animal
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class Animal {
	private String type;
	private int poundsOfFoodNeeded;

	/**
	 * Create a new Animal with the provided information
	 * 
	 * @precondition type != null && !type.isEmpty() && weightInGrams > 0
	 * @postcondition getType() == type && getPoundsOfFoodToEat() ==
	 *                poundsOfFoodToEat
	 * 
	 * @param type              the animal's type
	 * @param poundsOfFoodToEat weight of food needed to feed this animal
	 */
	public Animal(String type, int poundsOfFoodToEat) {
		if (type == null) {
			throw new IllegalArgumentException("type must not be null");
		}
		if (type.isEmpty()) {
			throw new IllegalArgumentException("type must not be empty");
		}
		if (poundsOfFoodToEat <= 0) {
			throw new IllegalArgumentException("weight of food must be positive");
		}
		this.type = type;
		this.poundsOfFoodNeeded = poundsOfFoodToEat;
	}

	/**
	 * Return the animal's type
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the animal's type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Return the weight of food needed to feed this animal
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the weight of food needed to fee this animal
	 */
	public int getPoundsOfFoodNeeded() {
		return this.poundsOfFoodNeeded;
	}
}
