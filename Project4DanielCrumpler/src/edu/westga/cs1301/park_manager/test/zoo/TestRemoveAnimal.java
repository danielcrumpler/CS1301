package edu.westga.cs1301.park_manager.test.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.park_manager.model.Animal;
import edu.westga.cs1301.park_manager.model.Zoo;

public class TestRemoveAnimal {

	@Test
	public void testEmptyUnfedList() {
		Zoo theZoo = new Zoo("Test Zoo");
		assertEquals(0, theZoo.getNumberOfUnfedAnimals());
	}

	@Test
	public void testOneAnimalMatchesType() {
		Zoo theZoo = new Zoo("Test Zoo");
		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);
		assertEquals(1, theZoo.getNumberOfUnfedAnimals());
		boolean result = theZoo.removeAnimal("zebra", 0);
		assertEquals(1, theZoo.getNumberOfUnfedAnimals());
		assertFalse(result);
	}

	@Test
	public void testOneAnimalMatchesFoodWeight() {
		Zoo theZoo = new Zoo("Test Zoo");
		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);
		assertEquals(1, theZoo.getNumberOfUnfedAnimals());
		boolean result = theZoo.removeAnimal("lion", 1);
		assertEquals(1, theZoo.getNumberOfUnfedAnimals());
		assertFalse(result);
	}

	@Test
	public void testOneAnimalMatchesBothTypeAndFoodWeight() {
		Zoo theZoo = new Zoo("Test Zoo");
		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);
		assertEquals(1, theZoo.getNumberOfUnfedAnimals());
		boolean result = theZoo.removeAnimal("zebra", 1);
		assertEquals(0, theZoo.getNumberOfUnfedAnimals());
		assertTrue(result);
	}

	@Test
	public void testMultipleAnimalsFirstMatchesBothTypeAndFoodWeight() {
		Zoo theZoo = new Zoo("Test Zoo");
		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);
		Animal theLion = new Animal("lion", 2);
		theZoo.addAnimal(theLion);
		Animal theTiger = new Animal("tiger", 3);
		theZoo.addAnimal(theTiger);
		assertEquals(3, theZoo.getNumberOfUnfedAnimals());
		boolean result = theZoo.removeAnimal("zebra", 1);
		assertEquals(2, theZoo.getNumberOfUnfedAnimals());
		assertTrue(result);
	}

	@Test
	public void testMultipleAnimalsMiddleMatchesBothTypeAndFoodWeight() {
		Zoo theZoo = new Zoo("Test Zoo");
		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);
		Animal theLion = new Animal("lion", 2);
		theZoo.addAnimal(theLion);
		Animal theTiger = new Animal("tiger", 3);
		theZoo.addAnimal(theTiger);
		assertEquals(3, theZoo.getNumberOfUnfedAnimals());
		boolean result = theZoo.removeAnimal("lion", 2);
		assertEquals(2, theZoo.getNumberOfUnfedAnimals());
		assertTrue(result);
	}

	@Test
	public void testMultipleAnimalsLastMatchesBothTypeAndFoodWeight() {
		Zoo theZoo = new Zoo("Test Zoo");
		Animal theZebra = new Animal("zebra", 1);
		theZoo.addAnimal(theZebra);
		Animal theLion = new Animal("lion", 2);
		theZoo.addAnimal(theLion);
		Animal theTiger = new Animal("tiger", 3);
		theZoo.addAnimal(theTiger);
		assertEquals(3, theZoo.getNumberOfUnfedAnimals());
		boolean result = theZoo.removeAnimal("tiger", 3);
		assertEquals(2, theZoo.getNumberOfUnfedAnimals());
		assertTrue(result);
	}
}
