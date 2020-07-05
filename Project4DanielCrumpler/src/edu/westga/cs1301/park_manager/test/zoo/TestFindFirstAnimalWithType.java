package edu.westga.cs1301.park_manager.test.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.park_manager.model.Zoo;
import edu.westga.cs1301.park_manager.model.Animal;

/**
 * Tests the method to find the first animal with this type
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class TestFindFirstAnimalWithType {

	@Test
	public void testNullTypeProvided() {
		Zoo theZoo = new Zoo("Test Zoo");

		assertThrows(IllegalArgumentException.class, () -> {
			theZoo.findFirstAnimalWithType(null);
		});
	}

	@Test
	public void testEmptyTypeProvided() {
		Zoo theZoo = new Zoo("Test Zoo");

		assertThrows(IllegalArgumentException.class, () -> {
			theZoo.findFirstAnimalWithType("");
		});
	}

	@Test
	public void testEmptyUnfedList() {
		Zoo theZoo = new Zoo("Test Zoo");

		Animal result = theZoo.findFirstAnimalWithType("zebra");

		assertNull(result);
	}

	@Test
	public void testMultipleAnimalsInUnfedListOnlyFirstHasTheSpecifiedType() {
		Zoo theZoo = new Zoo("Test Zoo");

		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);

		Animal theCamel = new Animal("camel", 2);
		theZoo.addAnimal(theCamel);

		Animal theBear = new Animal("bear", 3);
		theZoo.addAnimal(theBear);

		Animal result = theZoo.findFirstAnimalWithType("zebra");

		assertSame(theZebra, result);
	}

	@Test
	public void testMultipleAnimalsInUnfedListOnlyMiddleHasTheSpecifiedType() {
		Zoo theZoo = new Zoo("Test Zoo");

		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);

		Animal theCamel = new Animal("camel", 2);
		theZoo.addAnimal(theCamel);

		Animal theBear = new Animal("bear", 3);
		theZoo.addAnimal(theBear);

		Animal result = theZoo.findFirstAnimalWithType("camel");

		assertSame(theCamel, result);
	}

	@Test
	public void testMultipleAnimalsInUnfedListOnlyLastHasTheSpecifiedType() {
		Zoo theZoo = new Zoo("Test Zoo");

		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);

		Animal theCamel = new Animal("camel", 2);
		theZoo.addAnimal(theCamel);

		Animal theBear = new Animal("bear", 3);
		theZoo.addAnimal(theBear);

		Animal result = theZoo.findFirstAnimalWithType("bear");

		assertSame(theBear, result);
	}

	@Test
	public void testMultipleAnimalsInUnfedListFirstTwoHaveTheSpecifiedType() {
		Zoo theZoo = new Zoo("Test Zoo");

		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);

		Animal theSecondZebra = new Animal("zebra", 2);
		theZoo.addAnimal(theSecondZebra);

		Animal theBear = new Animal("bear", 3);
		theZoo.addAnimal(theBear);

		Animal result = theZoo.findFirstAnimalWithType("zebra");

		assertSame(theZebra, result);
	}
}
