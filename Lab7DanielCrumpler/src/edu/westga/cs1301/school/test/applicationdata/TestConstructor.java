package edu.westga.cs1301.school.test.applicationdata;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.school.model.ApplicationData;

/**
 * This class contains a set of tests to confirm correct functionality
 *  of the ApplicationData's constructor
 *  
 * @author	CS1301
 * @version	Spring 2019
 *
 */
public class TestConstructor {

	@Test
	public void shouldNotAllowNullDate() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ApplicationData(null, 3.0, 95);
		});
	}
	
	@Test
	public void shouldNotAllowGPABelowLowestPossible() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ApplicationData(LocalDate.now(), -0.01, 95);
		});
	}
	
	@Test
	public void shouldNotAllowTestScoreBelowLowestPossible() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ApplicationData(LocalDate.now(), 3.0, -1);
		});
	}
	
	@Test
	public void shouldNotAllowGPAAboveHighestPossible() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ApplicationData(LocalDate.now(), 4.01, 95);
		});
	}
	
	@Test
	public void shouldNotAllowTestScoreAboveHighestPossible() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ApplicationData(LocalDate.now(), 3.0, 101);
		});
	}
	
	@Test
	public void shouldAllowGPAAtLowest() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 0.0, 70);
		assertEquals(date, data.getApplicationDate());
		assertEquals(0.0, data.getGpa(), 0.001);
		assertEquals(70, data.getTestScore());
	}
		
	@Test
	public void shouldAllowGPAAtHighest() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 4.0, 70);
		assertEquals(date, data.getApplicationDate());
		assertEquals(4.0, data.getGpa(), 0.001);
		assertEquals(70, data.getTestScore());
	}
	
	@Test
	public void shouldAllowTestScoreAtLowest() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 2.0, 0);
		assertEquals(date, data.getApplicationDate());
		assertEquals(2.0, data.getGpa(), 0.001);
		assertEquals(0, data.getTestScore());
	}
		
	@Test
	public void shouldAllowTestScoreAtHighest() {
		LocalDate date = LocalDate.of(2019, 3, 1);
		ApplicationData data = new ApplicationData(date, 2.0, 100);
		assertEquals(date, data.getApplicationDate());
		assertEquals(2.0, data.getGpa(), 0.001);
		assertEquals(100, data.getTestScore());
	}
}
