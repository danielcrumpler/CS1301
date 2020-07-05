package edu.westga.cs1301.park_manager.test.animal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.park_manager.model.Animal;

/**
 * Tests the Animal constructor
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class TestConstructor {

	@Test
	public void testNullTypeProvided() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Animal(null, 1);
		});
	}

	@Test
	public void testEmptyTypeProvided() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Animal("", 1);
		});
	}

	@Test
	public void testWeightIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Animal("zebra", 0);
		});
	}

	@Test
	public void testWeightIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Animal("zebra", -1);
		});
	}

	@Test
	public void testValidTypeAndValidWeight() {
		Animal result = new Animal("zebra", 1);

		assertEquals("zebra", result.getType());
		assertEquals(1, result.getPoundsOfFoodNeeded());
	}

}
