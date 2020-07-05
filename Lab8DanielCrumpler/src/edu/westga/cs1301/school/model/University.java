package edu.westga.cs1301.school.model;

import java.util.ArrayList;

import edu.westga.cs1301.school.model.ApplicationData;

/**
 * This class represents a simple University object by keeping track of a
 * collection of applications
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class University {

	private ArrayList<ApplicationData> applications;
	private String name;

	/**
	 * Creates a new University with the given name and no applications
	 * 
	 * @precondition name != null && !name.isEmpty()
	 * @postcondition getName() == name && getNumberOfApplications() == 0
	 * @param name the university's name
	 */
	public University(String name) {
		if (name == null) {
			throw new IllegalArgumentException("University name cannot be null.");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("University name cannot be empty.");
		}
		this.name = name;
		this.applications = new ArrayList<ApplicationData>();

	}

	/**
	 * Gets the list of applications from this university.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the list of applications from this university.
	 */
	public ArrayList<ApplicationData> getApplications() {
		return this.applications;
	}

	/**
	 * Returns the name of the university
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the name of the university
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Checks to see if there is an application for the number provided
	 * 
	 * @precondition number > 0
	 * @postcondition none
	 * @param number the application number being searched for
	 * @return true if there is an application with this number, false otherwise
	 */
	public boolean hasApplicationNumber(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException("number must be greater than zero.");
		}
		for (ApplicationData university : applications) {
			if (university.getApplicationNumber() == number)
				return true;
		}
		return false;
	}

	/**
	 * Returns the number of applications to this university
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the number of applications to this university
	 */
	public int getNumberOfApplications() {
		return this.applications.size();
	}

	/**
	 * Adds a new application to the university
	 * 
	 * @precondition application != null && application.getApplicationNumber() is
	 *               not already present
	 * @postcondition getNumberOfApplications() == getNumberOfApplications()@pre + 1
	 * @param application the application to be added
	 */
	public void addApplication(ApplicationData application) {
		if (application == null) {
			throw new IllegalArgumentException("application can not be null.");
		}
		for (ApplicationData university : applications) {
			if (university.getApplicationNumber() == application.getApplicationNumber())
				throw new IllegalArgumentException("application can not have the same application number.");
		}
		this.applications.add(application);
	}

	/**
	 * Finds and returns the highest test score in any of the applications submitted
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the highest test score in any of the applications submitted
	 */
	public int findHighestTestScore() {
		int max = Integer.MIN_VALUE;

		for (ApplicationData university : this.applications) {
			if (university.getTestScore() > max) {
				max = university.getTestScore();
			}
		}
		return max;
	}

	/**
	 * Gets the average of all grade point averages in the applications submitted
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the average of all grade point averages in the applications submitted
	 */
	public double getAverageGpa() {
		double avg = 0.0;
		double gpa = 0.0;
		double current = Integer.MIN_VALUE;
		if (applications.size() > 0) {
			for (int i = 0; i < applications.size(); i++) {
				current = this.applications.get(i).getGpa();
				gpa += current;
			}
			avg = gpa / applications.size();
			return avg;
		}
		return Double.MIN_VALUE;
	}
}
