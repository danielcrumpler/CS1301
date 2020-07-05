package edu.westga.cs1301.grade_converter.model;

/**
 * Class that converts numerical grades to letter grades.
 * 
 * @author CS1301
 * @date Spring 2019
 * 
 */
public class GradeConverter {

	/**
	 * Convert the specified numeric grade to the appropriate letter grade. A:90-100
	 * B: 80-89 C: 70-79 D: 60-69 F: 0-59
	 * 
	 * @precondition 0 <= grade <= 100
	 * @postcondition none
	 * 
	 * @param grade numeric grade to be converted
	 * 
	 * @return The appropriate letter grade
	 */
	public String convertToLetterGrade(int grade) {
		if (grade < 0 || grade > 100) {
			throw new IllegalArgumentException("grade out of range of 0 to 100, inclusive.");
		}

		String letter = "";

		if (grade >= 90) {
			letter = "A";
		} else if (grade >= 80) {
			letter = "B";
		} else if (grade >= 70) {
			letter = "C";
		} else if (grade >= 60) {
			letter = "D";
		} else {
			letter = "F";
		}

		return letter;
	}

	/**
	 * Determine and return the appropriate plus or minus (or neither) dependent on
	 * the grade provided.
	 * 
	 * +: 87-89, 77-79, 67-69 -: 90-92, 80-82, 70-72, 60-62 All other options return
	 * an empty string
	 * 
	 * Note: There is no A+ nor F+ or F-.
	 * 
	 * @precondition 0 <= grade <= 100
	 * @postcondition none
	 * 
	 * @param grade numeric grade
	 * 
	 * @return "+" || "-" || ""
	 */
	public String getPlusOrMinus(int grade) {
		if (grade < 0 || grade > 100) {
			throw new IllegalArgumentException("grade out of range of 0 to 100, inclusive.");
		}

		if (grade > 92 || grade < 60)
			return "";
		
		int gradeRange = grade % 10;
		if (gradeRange >= 7) {
			return "+";
		} else if (gradeRange <= 2) {
			return "-";
		} else {
			return "";
		}
	}
}
