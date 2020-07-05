package edu.westga.cs1301.grade_converter.test.roster;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.grade_converter.model.Roster;

public class TestConstructor {

	@Test
	public void testInitialization() {
		Roster roster = new Roster();
		assertTrue(roster.getStudents().isEmpty());
	}

}
