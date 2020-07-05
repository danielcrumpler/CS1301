package edu.westga.cs1301.grade_converter.test.roster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.grade_converter.model.Roster;

public class TestAddAllStudentsWithName {

	@Test
	public void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			Roster roster = new Roster();
			roster.addStudent(null, 78);
		});
	}
	
	@Test
	public void testEmptyListAddOne() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 78);
		assertEquals(1, roster.getNumberOfStudents());
		assertTrue(roster.hasStudentWithName("Jim"));
	}
	
	@Test
	public void testOneInListAddOne() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 78);
		roster.addStudent("Kim", 82);
		assertEquals(2, roster.getNumberOfStudents());
		assertTrue(roster.hasStudentWithName("Jim"));
		assertTrue(roster.hasStudentWithName("Kim"));
	}
	
	@Test
	public void testNonEmptyAddDuplicate() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 76);
		roster.addStudent("Kim", 82);
		assertThrows(IllegalArgumentException.class, () -> {
		roster.addStudent("Jim", 78);
		});	
	}
	
	@Test
	public void testSeveralInListAddOne() {
		Roster roster = new Roster();
		roster.addStudent("Sam", 92);
		roster.addStudent("Kim", 82);
		roster.addStudent("Jim", 78);
		assertEquals(3, roster.getNumberOfStudents());
		assertTrue(roster.hasStudentWithName("Jim"));
		assertTrue(roster.hasStudentWithName("Kim"));
		assertTrue(roster.hasStudentWithName("Jim"));
	}
}
