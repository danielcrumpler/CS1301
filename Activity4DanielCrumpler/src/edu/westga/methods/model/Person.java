package edu.westga.methods.model;

/**
 * Represents a Person with a first name, last name, and age.
 * 
 * @author CS 1301
 * @date Spring 2019
 *
 */
public class Person {
	private int age;
	private String firstName;
	private String lastName;

	/**
	 * Creates a default person.
	 * 
	 * @precondition none
	 * @postcondition getFirstName().isEmpty() && getLastName().isEmpty() &&
	 *                getAge()==0
	 */
	public Person() {
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
	}

	/**
	 * Creates a Person with the give first and last name, and an age of zero.
	 * 
	 * @precondition firstName != null && !firstName.isEmpty() && lastName != null
	 *               && !lastName.isEmpty()
	 * @postcondition getFirstName().equals(firstName) &&
	 *                getLastName.equals(lastName) && getAge()==0
	 * 
	 * @param firstName the person's first name
	 * @param lastName  the person's last name
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = 0;
	}

	/**
	 * Gets the Person's age
	 * 
	 * @return the person's age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Sets the person's age
	 * 
	 * @precondition age >= 0
	 * @postcondition getAge() == age
	 * 
	 * @param age the person's new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the person's first name
	 * 
	 * @return the person's first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Gets the person's last name
	 * 
	 * @return the person's last name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Gets the person's full name
	 * 
	 * @return the person's full name
	 * 
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * Gets the person's formal name
	 * 
	 * @return the person's formal name
	 * 
	 * @param title Persons title
	 */
	public String getFormalName(String title) {
		return title + " " + this.lastName;
	}

	/**
	 * Ages the person by the given number of years.
	 * 
	 * @precondtion years >= 0
	 * @postcondition getAge() == getAge()@prev + years
	 * 
	 * @param years the number of years to age by
	 */
	public void growOlderBy(int years) {
		this.age = this.age + years;
	}

	/**
	 * Gets the person's initials, as a String.
	 *
	 * @return the person's initials, as a String.
	 */
	public String getInitials() {
		return this.firstName.charAt(0) + "." + this.lastName.charAt(0) + ".";
	}

	/**
	 * Finds the person's birth year.
	 * 
	 * @precondition currentYear > 1970
	 * @postcondition none
	 * @return the person's birth year.
	 */
	public int findBirthYear(int currentYear) {
		return currentYear - this.age;
	}

	/**
	 * Changes a Person's first and last name.
	 * 
	 * @precondition firstName !=null && !firstName.isEmpty() && lastName != null &&
	 *               !lastName.isEmpty()
	 * @postcondition getFirstName().equals(firstName) &&
	 *                getLastName().equals(lastName)
	 * 
	 * @param firstName the person's first name
	 * @param lastName  the person's last name
	 */
	public void changeName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
