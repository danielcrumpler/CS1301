package edu.westga.cs1301.school.test.applicationdata;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.school.model.ApplicationData;

/**
 * This class contains a set of tests to confirm correct functionality of the
 * ApplicationData's getClassificationResult method
 * 
 * @author CS1301
 * @version Spring 2019
 *
 */
public class TestGetAdmissionResult {

	@Test
	public void shouldAllowGPAAtLowestBoundOfAccepted() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 3.0, 90);
		assertEquals(date, data.getApplicationDate());
		assertEquals(3.0, data.getGpa(), 0.0001);
		assertEquals(90, data.getTestScore());
		assertEquals("Accepted", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowGPAAtUpperBoundOfFurtherReviewTestScore() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 3.5, 89);
		assertEquals(date, data.getApplicationDate());
		assertEquals(3.5, data.getGpa(), 0.001);
		assertEquals(89, data.getTestScore());
		assertEquals("Further Review", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtUpperBoundOfFurtherReviewGPA() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 2.99, 95);
		assertEquals(date, data.getApplicationDate());
		assertEquals(2.99, data.getGpa(), 0.001);
		assertEquals(95, data.getTestScore());
		assertEquals("Further Review", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtLowerBoundOfFurtherReviewTestScore() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 3.5, 75);
		assertEquals(date, data.getApplicationDate());
		assertEquals(3.5, data.getGpa(), 0.001);
		assertEquals(75, data.getTestScore());
		assertEquals("Further Review", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtLowerBoundOfFurtherReviewGPA() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 2.0, 95);
		assertEquals(date, data.getApplicationDate());
		assertEquals(2.0, data.getGpa(), 0.001);
		assertEquals(95, data.getTestScore());
		assertEquals("Further Review", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtLowerBoundOfFurtherReviewBothGPAAndTestScore() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 2.3, 85);
		assertEquals(date, data.getApplicationDate());
		assertEquals(2.3, data.getGpa(), 0.001);
		assertEquals(85, data.getTestScore());
		assertEquals("Further Review", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtUpperBoundOfDeniedGPAWithTestScoreOfFurtherReview() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 1.99, 85);
		assertEquals(date, data.getApplicationDate());
		assertEquals(1.99, data.getGpa(), 0.001);
		assertEquals(85, data.getTestScore());
		assertEquals("Denied", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtUpperBoundOfDeniedGPAWithTestScoreOfAccepted() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 1.99, 95);
		assertEquals(date, data.getApplicationDate());
		assertEquals(1.99, data.getGpa(), 0.001);
		assertEquals(95, data.getTestScore());
		assertEquals("Denied", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtUpperBoundOfDeniedTestScoreWithGPAOfFurtherReview() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 2.5, 74);
		assertEquals(date, data.getApplicationDate());
		assertEquals(2.5, data.getGpa(), 0.001);
		assertEquals(74, data.getTestScore());
		assertEquals("Denied", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtUpperBoundOfDeniedTestScoreWithGPAOfAccepted() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 3.5, 74);
		assertEquals(date, data.getApplicationDate());
		assertEquals(3.5, data.getGpa(), 0.001);
		assertEquals(74, data.getTestScore());
		assertEquals("Denied", data.getAdmissionResult());
	}

	@Test
	public void shouldAllowAtDeniedApplicationWithTestScoreAndGPAOfDenied() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 2.0, 70);
		assertEquals(date, data.getApplicationDate());
		assertEquals(2.0, data.getGpa(), 0.001);
		assertEquals(70, data.getTestScore());
		assertEquals("Denied", data.getAdmissionResult());
	}
}
