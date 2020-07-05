package edu.westga.cs1301.park_manager.test.zoo_formatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.park_manager.model.Animal;
import edu.westga.cs1301.park_manager.view.ZooFormatter;

public class TestFormatAnimal {

	@Test
	public void testNullAnimal() {
		ZooFormatter formatter = new ZooFormatter();
		assertThrows(IllegalArgumentException.class, () -> formatter.formatAnimal(null));
	}

	@Test
	public void testValidAnimal() {
		ZooFormatter formatter = new ZooFormatter();
		Animal animal = new Animal("tiger", 20);
		String result = formatter.formatAnimal(animal);
		assertEquals("ANIMAL tiger that eats 20 pounds", result);
	}
}
