package edu.westga.carlot.model;

/**
 * Summary of car data.
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class Car {
	private static final int MIN_MODEL_YEAR = 1900;
	private String make;
	private String model;
	private int year;
	private double msrp;
	private double mpg;
	private boolean isUsed;

	/**
	 * Creates a default Car.
	 * 
	 * @precondition none
	 * @postcondition getMake()==null && getModel()==null && getYear()==2000 &&
	 *                getPrice()==0 && getMgp()==0
	 */
	public Car() {
		this.year = 2000;
		this.make = null;
		this.model = null;
		this.msrp = 0;
		this.mpg = 0;
		this.isUsed = true;
	}

	/**
	 * Creates a car with a make, model, year, price, and mpg rating.
	 * 
	 * @precondition make != null && model != null && year > 1900 && price >=0 &&
	 *               mpg > 0
	 * @postcondition getMake()==make && getModel()==model && getYear()==year &&
	 *                getPrice()==price && getMpg()==mpg
	 * 
	 * @param make   the brand of auto
	 * @param model  the model name of the the auto
	 * @param msrp   starting price of the car
	 * @param year 	 year of the car
	 * @param mpg    miles per gallon
	 * @param isUsed true if car is a used car
	 */
	public Car(String make, String model, int year, double msrp, double mpg, boolean isUsed) {
		if (make == null) {
			throw new IllegalArgumentException("make can not be null");
		}

		if (model == null) {
			throw new IllegalArgumentException("model can not be null");
		}

		if (year <= MIN_MODEL_YEAR) {
			throw new IllegalArgumentException("year must be > 1900");
		}

		if (msrp < 0) {
			throw new IllegalArgumentException("price must be > 0.0");
		}

		if (mpg <= 0) {
			throw new IllegalArgumentException("mpg must be > 0.0");
		}

		this.make = make;
		this.model = model;
		this.year = year;
		this.msrp = msrp;
		this.mpg = mpg;
		this.isUsed = isUsed;
	}

	/**
	 * Gets whether or not this is a used car.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if car is used.
	 */
	public boolean getIsUsed() {
		return this.isUsed;
	}

	/**
	 * Gets the make (brand name) of the auto
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return make of the car
	 */
	public String getMake() {
		return this.make;
	}

	/**
	 * Gets the model name of the auto
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the model name
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * Gets the model year of the auto
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the year it was manufactured
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Gets the car's MSRP
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the msrp
	 */
	public double getMSRP() {
		return this.msrp;
	}

	/**
	 * Gets the car's fuel efficiency
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the mpg.
	 */
	public double getMpg() {
		return this.mpg;
	}

	/**
	 * Calculates the actual price of the car.
	 * 
	 * @precondition yearSold >= getYear()
	 * @postcondition none
	 * 
	 * @param yearSold the year the car sold.
	 * @return the actual price of the car
	 */
	public double calculateActualPriceFor(int yearSold) {
		if (yearSold < this.year) {
			throw new IllegalArgumentException("yearSold must be >= model year");
		}

		if (!this.isUsed) {
			return this.getMSRP();
		}

		double actualPrice = this.msrp;
		for (int i = yearSold - 1; i >= this.year; i--) {
			actualPrice = actualPrice * 0.9;
		}

		return actualPrice;
	}
}
