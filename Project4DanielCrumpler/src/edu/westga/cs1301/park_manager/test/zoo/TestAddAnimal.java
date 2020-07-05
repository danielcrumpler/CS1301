package edu.westga.cs1301.park_manager.test.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.park_manager.model.Zoo;
import edu.westga.cs1301.park_manager.model.Animal;

/**
 * Tests the method to add an animal
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class TestAddAnimal {

	@Test
	public void testNullAnimalProvided() {
		Zoo theZoo = new Zoo("Test Zoo");

		assertThrows(IllegalArgumentException.class, () -> {
			theZoo.addAnimal(null);
		});
	}

	@Test
	public void testAddAnimalToEmptyUnfedList() {
		Zoo theZoo = new Zoo("Test Zoo");
		Animal theZebra = new Animal("zebra", 1);

		theZoo.addAnimal(theZebra);

		assertEquals(1, theZoo.getNumberOfUnfedAnimals());
	}

	@Test
	public void testAddAnimalToNonEmptyUnfedList() {
		Zoo theZoo = new Zoo("Test Zoo");
		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);
		Animal theCamel = new Animal("camel", 2);

		theZoo.addAnimal(theCamel);

		assertEquals(2, theZoo.getNumberOfUnfedAnimals());
	}

}
