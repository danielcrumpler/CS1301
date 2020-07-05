package edu.westga.carlot.test.carlot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.carlot.model.Carlot;

public class TestConstruction {

	@Test
	public void testDefaultConstructor() {
		Carlot theLot = new Carlot();
		
		assertEquals(0, theLot.size());
	}

}
