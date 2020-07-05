package edu.westga.cs1301.park_manager.test.feeding_schedule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.park_manager.model.FeedingSchedule;
import edu.westga.cs1301.park_manager.model.Animal;

public class TestCalculateTotalFoodWeight {

	@Test
	public void testEmptyFeedingSchedule() {
		FeedingSchedule schedule = new FeedingSchedule();
		int result = schedule.calculateTotalFoodWeight();
		assertEquals(0, result);
	}

	@Test
	public void testOneAnimalInFeedingSchedule() {
		FeedingSchedule schedule = new FeedingSchedule();

		Animal theBear = new Animal("bear", 3);
		schedule.addAnimal(theBear);

		int result = schedule.calculateTotalFoodWeight();
		assertEquals(3, result);
	}

	@Test
	public void testMultipleAnimalsInFeedingSchedule() {
		FeedingSchedule schedule = new FeedingSchedule();

		Animal theZebra = new Animal("zebra", 1);
		schedule.addAnimal(theZebra);

		Animal theCamel = new Animal("camel", 2);
		schedule.addAnimal(theCamel);

		Animal theBear = new Animal("bear", 3);
		schedule.addAnimal(theBear);

		int result = schedule.calculateTotalFoodWeight();
		assertEquals(6, result);
	}

}
