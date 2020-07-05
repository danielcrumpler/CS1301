package edu.westga.cs1301.park_manager.test.feeding_schedule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.park_manager.model.Animal;
import edu.westga.cs1301.park_manager.model.FeedingSchedule;

/**
 * Tests the method to add an animal
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class TestAddAnimal {

	@Test
	public void testNullAnimalProvided() {
		FeedingSchedule theFeedingSchedule = new FeedingSchedule();

		assertThrows(IllegalArgumentException.class, () -> {
			theFeedingSchedule.addAnimal(null);
		});
	}

	@Test
	public void testAddAnimalToEmptyFeedingSchedule() {
		FeedingSchedule theFeedingSchedule = new FeedingSchedule();
		Animal theZebra = new Animal("zebra", 1);

		theFeedingSchedule.addAnimal(theZebra);

		assertEquals(1, theFeedingSchedule.getNumberOfFeedingSchedule());
	}

	@Test
	public void testAddAnimalToNonEmptyFeedingSchedule() {
		FeedingSchedule theFeedingSchedule = new FeedingSchedule();
		Animal theZebra = new Animal("zebra", 1);
		theFeedingSchedule.addAnimal(theZebra);
		Animal theCamel = new Animal("camel", 2);

		theFeedingSchedule.addAnimal(theCamel);

		assertEquals(2, theFeedingSchedule.getNumberOfFeedingSchedule());
	}

}
