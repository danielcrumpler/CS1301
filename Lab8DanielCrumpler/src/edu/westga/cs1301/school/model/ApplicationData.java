package edu.westga.cs1301.school.model;

/**
 * This class represents a student's application to a school
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class ApplicationData {
	private int applicationNumber;
	private double gpa;
	private int testScore;

	public static final double LOWEST_POSSIBLE_GPA = 0.0;
	public static final double HIGHEST_POSSIBLE_GPA = 4.0;
	public static final int LOWEST_POSSIBLE_TEST_SCORE = 0;
	public static final int HIGHEST_POSSIBLE_TEST_SCORE = 100;

	public static final double ACCEPTED_GPA_LOWER_BOUND = 3.0;
	public static final double FURTHER_REVIEW_GPA_LOWER_BOUND = 2.0;
	public static final int ACCEPTED_TEST_SCORE_LOWER_BOUND = 90;
	public static final int FURTHER_REVIEW_TEST_SCORE_LOWER_BOUND = 75;

	/**
	 * Creates an application data object, storing the applicant's GPA and
	 * admissions test score
	 * 
	 * @precondition applicationNumber > 0 && 0 <= gpa <= 4.0 && 0 <= testScore <=
	 *               100
	 * @postcondition getGpa() == gpa && getTestScore == testScore
	 * @param applicationNumber the application number for this student
	 * @param gpa               the applicant's GPA
	 * @param testScore         the applicant's admissions test score
	 */
	public ApplicationData(int applicationNumber, double gpa, int testScore) {
		if (applicationNumber <= 0) {
			throw new IllegalArgumentException("Application number must be greater than 0");
		}
		if (gpa < 0 || gpa > 4) {
			throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
		}
		if (testScore < 0 || testScore > 100) {
			throw new IllegalArgumentException("Test score must be between 0 and 100");
		}
		this.applicationNumber = applicationNumber;
		this.gpa = gpa;
		this.testScore = testScore;
	}

	/**
	 * Returns the admission's classification result: Accepted, Further Review, or
	 * Denied. An applicant with GPA at 3.0 or higher and an admissions test score
	 * over 89 will be accepted. An applicant with GPA greater than or equal to 2.0,
	 * but less than 3.0 and an admissions test score greater than or equal to 75,
	 * but less than 90 will need further review. An applicant with GPA lower than
	 * 2.0 or a test score below 75 will be denied.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return a String holding the classification result of either Accepted,
	 *         Further Review, or Denied, based on the criteria listed above
	 */
	public String getAdmissionResult() {
		if (this.gpa >= ApplicationData.ACCEPTED_GPA_LOWER_BOUND
				&& this.testScore >= ApplicationData.ACCEPTED_TEST_SCORE_LOWER_BOUND) {
			return "Accepted";
		} else if (this.gpa < ApplicationData.FURTHER_REVIEW_GPA_LOWER_BOUND
				|| this.testScore < ApplicationData.FURTHER_REVIEW_TEST_SCORE_LOWER_BOUND) {
			return "Denied";
		} else {
			return "Further Review";
		}
	}

	/**
	 * Returns the application number
	 * 
	 * @precondition none
	 * @return the application number
	 */
	public int getApplicationNumber() {
		return this.applicationNumber;
	}

	/**
	 * Returns the applicant's GPA
	 * 
	 * @precondition none
	 * @return the applicant's GPA
	 */
	public double getGpa() {
		return this.gpa;
	}

	/**
	 * Returns the applicant's admissions test score
	 * 
	 * @precondition none
	 * @return the applicant's admissions test score
	 */
	public int getTestScore() {
		return this.testScore;
	}
}
