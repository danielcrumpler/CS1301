package edu.westga.cs1301.school.model;

import java.time.LocalDate;

/**
 * This class represents a student's application to a school
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class ApplicationData {
	private LocalDate applicationDate;
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
	 * @precondition date != null
	 * @precondition 0 <= gpa <= 4.0
	 * @precondition 0 <= testScore <= 100
	 * @postcondition getGpa() == gpa && getTestScore == testScore
	 * @param gpa       the applicant's GPA
	 * @param testScore the applicant's admissions test score
	 */
	public ApplicationData(LocalDate applicationDate, double gpa, int testScore) {
		if (applicationDate == null) {
			throw new IllegalArgumentException("applicationDate cannot be null");
		}
		if (gpa < 0 || gpa > 4.0) {
			throw new IllegalArgumentException("gpa cannot be less than zero and cannot be more than four");
		}
		if (testScore < 0 || testScore > 100) {
			throw new IllegalArgumentException("testScore cannot be less than zero and cannot be more than one hundred");
		}	
		this.applicationDate = applicationDate;
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
	 * Returns the applicant's application date
	 * 
	 * @precondition none
	 * @return the applicant's application date
	 */
	public LocalDate getApplicationDate() {
		return this.applicationDate;
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
