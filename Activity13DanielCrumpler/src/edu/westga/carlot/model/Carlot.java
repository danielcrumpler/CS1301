
package edu.westga.carlot.model;

import java.util.ArrayList;

/**
 * Summary of cars in a Carlot.
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class Carlot {

	private ArrayList<Car> inventory;

	/**
	 * Creates a new carlot
	 * 
	 * @precondition none
	 * @postcondition size() == 0
	 *
	 */
	public Carlot() {
		this.inventory = new ArrayList<Car>();
	}

	/**
	 * Gets the total number of cars in the inventory.
	 * 
	 * @return size of the invetory
	 */
	public int size() {
		return this.inventory.size();
	}

	/**
	 * Adds a new Car to the inventory.
	 * 
	 * @precondition make != null && model != null && year > 1900 && price >=0 &&
	 *               mpg > 0
	 * @postcondition size()==size()@prev+1
	 * 
	 * @param make   the brand of auto
	 * @param model  the model name of the the auto
	 * @param isUsed true if this is a used car, false if this is a new car
	 * @param year 	 year of the car
	 * @param price  price of the car
	 * @param mpg    miles per gallon
	 */
	public void addCar(String make, String model, int year, double price, double mpg, boolean isUsed) {
		Car theCar = new Car(make, model, year, price, mpg, isUsed);
		this.inventory.add(theCar);
	}

	/**
	 * Gets the model year of the newest car on the lot.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the model year of the newest car
	 */
	public int determineNewestCarYear() {
		int latestYear = Integer.MIN_VALUE;
		for (Car currentCar : this.inventory) {
			if (currentCar.getYear() > latestYear) {
				latestYear = currentCar.getYear();
			}
		}
		return latestYear;
	}

	/**
	 * Gets the model year of the oldest car on the lot.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the oldest car in the array.
	 */
	public int determineOldestCarYear() {
		int earliestYear = Integer.MAX_VALUE;
		for (Car currentCar : this.inventory) {
			if (currentCar.getYear() < earliestYear) {
				earliestYear = currentCar.getYear();
			}
		}
		return earliestYear;
	}

	/**
	 * Calculates average price of cars in inventory.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the average price of the cars in inventory.
	 */
	public double calculateAveragePrice() {
		if (this.inventory.isEmpty()) {
			return 0;
		}

		double sum = 0;
		for (Car currentCar : this.inventory) {
			sum += currentCar.getMSRP();
		}
		return sum / this.inventory.size();
	}

	/**
	 * Gets the number of used cars in the inventory.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return number of cars
	 */
	public int getNumberOfUsedCars() {
		int cars = 0;
		for (Car currentCar : this.inventory) {
			if (currentCar.getIsUsed()) {
				cars++;
			}
		}
		return cars;
	}

	/**
	 * Gets the number of new cars in the inventory.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of new cars in the inventory
	 */
	public int getNumberOfNewCars() {
		int count = 0;
		for (Car currentCar : this.inventory) {
			if (!currentCar.getIsUsed()) {
				count++;
			}
		}	
		return count;
	}

	/**
	 * Adds the given car to the inventory.
	 * 
	 * @precondition theCar != null
	 * @postcondition size()==size()@prev + 1
	 * 
	 * @param theCar the car to add
	 */
	public void addCar(Car theCar) {
		if (theCar == null) {
			throw new IllegalArgumentException("theCar may not be null");
		}
		this.inventory.add(theCar);
	}

	/**
	 * Searches for the first instance of a car with the given criteria
	 *
	 * @precondition make != null && model != null && budget > 0
	 * @postcondition none
	 * 
	 * @param make   the make of car desired
	 * @param model  the model of car desired
	 * @param budget the maximum the buyer is willing to spend
	 * @return the first matching car; null if none is found
	 */
	public Car searchByMakeModelAndPrice(String make, String model, double budget) {
		if (make == null) {
			throw new IllegalArgumentException("make can not be null");
		}

		if (model == null) {
			throw new IllegalArgumentException("model can not be null");
		}

		if (budget <= 0) {
			throw new IllegalArgumentException("budget must be > 0");
		}

		for (Car currentCar : this.inventory) {
			if (currentCar.getMake().equals(make) && currentCar.getModel().equals(model) && currentCar.getMSRP() < budget) {
				return currentCar;
			}
		}
		return null;
	}

	/**
	 * Gets a list of all the used cars in the car lot.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return all the used cars in the lot.
	 */
	public ArrayList<Car> getUsedCars() {
		ArrayList<Car> usedCars = new ArrayList<Car>();
		for (Car currentCar : this.inventory) {
			if (currentCar.getIsUsed()) {
				usedCars.add(currentCar);
			}
		}
		return usedCars;
	}

	/**
	 * Gets a list of all the new cars in the car lot.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return all the new cars in the lot.
	 */
	public ArrayList<Car> getNewCars() {
		ArrayList<Car> newCars = new ArrayList<Car>();
		for (Car currentCar : this.inventory) {
			if (!currentCar.getIsUsed()) {
				newCars.add(currentCar);
			}
		}
		return newCars;
	}

	/**
	 * Calculates the tax write-off for the entire car lot, where the write-off is
	 * the difference between a car's MSRP and actual price.
	 * 
	 * @precondition forYear >= determineNewestCarYear()
	 * @postcondition none
	 * 
	 * @param year year
	 * @return the total tax write-off for the car lot
	 */
	public double calculateTaxWriteOffFor(int year) {
		if (year < this.determineNewestCarYear()) {
			throw new IllegalArgumentException("forYear must be >= the newest car year");
		}
		double tax = 0;
		for (Car currentCar : this.inventory) {
			tax += currentCar.getMSRP() - currentCar.calculateActualPriceFor(year);
		}

		return tax;
	}
}
