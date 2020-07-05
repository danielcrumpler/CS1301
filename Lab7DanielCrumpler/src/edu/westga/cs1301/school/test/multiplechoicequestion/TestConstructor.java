package edu.westga.cs1301.school.test.multiplechoicequestion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.school.model.MultipleChoiceQuestion;

/**
 * This class contains a set of tests to confirm correct functionality of the
 * MultipleChoiceQuestion constructor
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestConstructor {

	@Test
	public void shouldNotAllowNullQuestionText() {
		assertThrows(IllegalArgumentException.class, () -> {
			new MultipleChoiceQuestion(null, 3, 100);
		});
	}

	@Test
	public void shouldNotAllowEmptyQuestionText() {
		assertThrows(IllegalArgumentException.class, () -> {
			new MultipleChoiceQuestion("", 3, 100);
		});
	}

	@Test
	public void shouldNotAllowZeroAnswerNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			new MultipleChoiceQuestion("question", 0, 100);
		});
	}

	@Test
	public void shouldNotAllowNegativeAnswerNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			new MultipleChoiceQuestion("question", -1, 100);
		});
	}

	@Test
	public void shouldNotAllowMoreThanFourAnswerNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			new MultipleChoiceQuestion("question", 5, 100);
		});
	}

	@Test
	public void shouldNotAllowZeroPointValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new MultipleChoiceQuestion("question", 1, 0);
		});
	}

	@Test
	public void shouldNotAllowNegativePointValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new MultipleChoiceQuestion("question", 1, -1);
		});
	}
}
