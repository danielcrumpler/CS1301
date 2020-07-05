package edu.westga.cs1301.park_manager.test.zoo_formatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.park_manager.model.Animal;
import edu.westga.cs1301.park_manager.model.Zoo;
import edu.westga.cs1301.park_manager.view.ZooFormatter;

public class TestFormatZoo {

	@Test
	public void testNullZoo() {
		ZooFormatter formatter = new ZooFormatter();
		assertThrows(IllegalArgumentException.class, () -> formatter.formatUnfedList(null));
	}

	@Test
	public void testEmptyZoo() {
		ZooFormatter formatter = new ZooFormatter();
		Zoo zoo = new Zoo("Atlanta Zoo");
		String result = formatter.formatUnfedList(zoo);
		assertEquals("BEGIN Atlanta Zoo UNFED LIST" + System.lineSeparator() + "END Atlanta Zoo UNFED LIST", result);
	}

	@Test
	public void testSingleAnimalZoo() {
		ZooFormatter formatter = new ZooFormatter();
		Zoo zoo = new Zoo("Atlanta Zoo");
		Animal animal1 = new Animal("tiger", 20);
		zoo.addAnimal(animal1);
		String result = formatter.formatUnfedList(zoo);
		assertEquals("BEGIN Atlanta Zoo UNFED LIST" + System.lineSeparator() + "	ANIMAL tiger that eats 20 pounds"
				+ System.lineSeparator() + "END Atlanta Zoo UNFED LIST", result);
	}

	@Test
	public void testMultipleAnimalZoo() {
		ZooFormatter formatter = new ZooFormatter();
		Zoo zoo = new Zoo("Atlanta Zoo");
		Animal animal1 = new Animal("tiger", 20);
		Animal animal2 = new Animal("lion", 15);
		Animal animal3 = new Animal("cougar", 17);
		zoo.addAnimal(animal1);
		zoo.addAnimal(animal2);
		zoo.addAnimal(animal3);
		String result = formatter.formatUnfedList(zoo);
		assertEquals(
				"BEGIN Atlanta Zoo UNFED LIST" + System.lineSeparator() + "	ANIMAL tiger that eats 20 pounds"
						+ System.lineSeparator() + "	ANIMAL lion that eats 15 pounds" + System.lineSeparator()
						+ "	ANIMAL cougar that eats 17 pounds" + System.lineSeparator() + "END Atlanta Zoo UNFED LIST",
				result);
	}

}
