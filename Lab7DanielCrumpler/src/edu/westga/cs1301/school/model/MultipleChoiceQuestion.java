package edu.westga.cs1301.school.model;

/**
 * This class represents a multiple choice question
 * 	with question text, 4 answers, and a point value
 * 
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class MultipleChoiceQuestion {
	private String questionText;
	private int answerNumber;
	private int pointValue;
	
	/**
	 * Creates a new MultipleChoiceQuestion with the values
	 * 	specified.
	 * 
	 * @precondition	questionText != null && !questionText.isEmpty()
	 * @precondition	0 < answerNumber <= 4
	 * @precondition	pointValue > 0

	 * @param questionText	The question's text
	 * @param answerNumber	The number corresponding to the answer option
	 * @param pointValue	The point value for this question
	 * 
	 */
	public MultipleChoiceQuestion(String questionText, int answerNumber, int pointValue) {
		if (questionText == null) {
			throw new IllegalArgumentException("questionText cannot be null");
		}
		if (questionText == "") {
			throw new IllegalArgumentException("questionText cannot be empty");
		}
		if (answerNumber <= 0 || answerNumber > 4) {
			throw new IllegalArgumentException("answerValue cannot be less than or equal to zero and cannot be more than four");
		}
		if (pointValue <= 0) {
			throw new IllegalArgumentException("pointValue cannot be less than or equal to zero");
		}
		this.questionText = questionText;
		this.answerNumber = answerNumber;
		this.pointValue = pointValue;
	}
	
	/**
	 * Returns this question's text
	 * @precondition	none
	 * @return			the question's text
	 */
	public String getQuestionText() {
		return this.questionText;
	}
	
	/**
	 * Sets the question's text
	 * 
	 * @precondition	questionText != null && !questionText.isEmpty()
	 * @postcondition	getQuestionText().equals(questionText)
	 * @param questionText	the question's text
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	/**
	 * Returns the question's answer number
	 * @precondition	none
	 * @return	the questions correct answer number
	 */
	public int getAnswerNumber() {
		return this.answerNumber;
	}
	
	/**
	 * Sets the question's answer number
	 * 
	 * @precondition	0 < answerNumber < 5
	 * @postcondition	getAnswerNumber() == answerNumber
	 * @param answerNumber	the question's answer number
	 */
	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}
	
	/**
	 * Returns the question's point value
	 * @precondition	none
	 * @return	the question's point value
	 */
	public int getPointValue() {
		return this.pointValue;
	}
	
	/**
	 * Sets the question's point value
	 * 
	 * @precondition	0 < pointValue
	 * @postcondition	getPointValue() == pointValue
	 * @param answerNumber	the question's point value
	 */
	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}
}
