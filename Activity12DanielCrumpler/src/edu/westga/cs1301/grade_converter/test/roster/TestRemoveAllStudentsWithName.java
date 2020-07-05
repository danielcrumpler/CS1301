package edu.westga.cs1301.grade_converter.test.roster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.grade_converter.model.Roster;

public class TestRemoveAllStudentsWithName {

	@Test
	public void testNullName() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		assertThrows(IllegalArgumentException.class, () -> {
			roster.removeAllStudentsWithName(null);
		});
	}
	
	@Test
	public void testEmptyName() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		assertThrows(IllegalArgumentException.class, () -> {
			roster.removeAllStudentsWithName("");
		});
	}

	@Test
	public void testEmptyRoster() {
		Roster roster = new Roster();
		roster.removeAllStudentsWithName("Jim");
		assertEquals(0, roster.getNumberOfStudents());
		assertEquals(false, roster.hasStudentWithName("Jim"));
	}

	@Test
	public void testOneElementNoOccurence() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		roster.removeAllStudentsWithName("Tom");
		assertEquals(1, roster.getNumberOfStudents());
		assertEquals(true, roster.hasStudentWithName("Jim"));
	}

	@Test
	public void testOneElementOneOccurence() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		roster.removeAllStudentsWithName("Jim");
		assertEquals(0, roster.getNumberOfStudents());
		assertEquals(false, roster.hasStudentWithName("Jim"));
	}
	
	@Test
	public void testMultipleElementNoOccurence() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		roster.addStudent("Ron", 78);
		roster.addStudent("Tom", 82);
		roster.addStudent("Jon", 55);
		roster.removeAllStudentsWithName("Bob");
		assertEquals(4, roster.getNumberOfStudents());
		assertEquals(true, roster.hasStudentWithName("Jim"));
		assertEquals(true, roster.hasStudentWithName("Ron"));
		assertEquals(true, roster.hasStudentWithName("Tom"));
		assertEquals(true, roster.hasStudentWithName("Jon"));
	}
	
	@Test
	public void testMultipleElementOneOccurenceAtFirstPosition() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		roster.addStudent("Ron", 78);
		roster.addStudent("Tom", 82);
		roster.addStudent("Jon", 55);
		roster.removeAllStudentsWithName("Jim");
		assertEquals(3, roster.getNumberOfStudents());
		assertFalse(roster.hasStudentWithName("Jim"));
		assertTrue(roster.hasStudentWithName("Ron"));
		assertTrue(roster.hasStudentWithName("Tom"));
		assertTrue(roster.hasStudentWithName("Jon"));
	}
	
	@Test
	public void testMultipleElementOneOccurenceAtLastPosition() {
		Roster roster = new Roster();
		roster.addStudent("Ron", 78);
		roster.addStudent("Tom", 82);
		roster.addStudent("Jon", 55);
		roster.addStudent("Jim", 77);
		roster.removeAllStudentsWithName("Jim");
		assertEquals(3, roster.getNumberOfStudents());
		assertTrue(roster.hasStudentWithName("Ron"));
		assertTrue(roster.hasStudentWithName("Tom"));
		assertTrue(roster.hasStudentWithName("Jon"));
		assertFalse(roster.hasStudentWithName("Jim"));
	}
	
	@Test
	public void testMultipleElementOneOccurenceInBetween() {
		Roster roster = new Roster();
		roster.addStudent("Ron", 78);
		roster.addStudent("Tom", 82);
		roster.addStudent("Jim", 77);
		roster.addStudent("Jon", 55);
		roster.removeAllStudentsWithName("Jim");
		assertEquals(3, roster.getNumberOfStudents());
		assertTrue(roster.hasStudentWithName("Ron"));
		assertTrue(roster.hasStudentWithName("Tom"));
		assertFalse(roster.hasStudentWithName("Jim"));
		assertTrue(roster.hasStudentWithName("Jon"));
	}
	
	@Test
	public void testMultipleElementMultipleOccurences() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		roster.addStudent("Ron", 78);
		roster.addStudent("Tom", 82);
		roster.addStudent("Jim", 62);
		roster.addStudent("Jon", 55);
		roster.removeAllStudentsWithName("Jim");
		assertEquals(3, roster.getNumberOfStudents());
		assertFalse(roster.hasStudentWithName("Jim"));
		assertTrue(roster.hasStudentWithName("Ron"));
		assertTrue(roster.hasStudentWithName("Tom"));
		assertTrue(roster.hasStudentWithName("Jon"));
	}
	
	@Test
	public void testMultipleRemovals() {
		Roster roster = new Roster();
		roster.addStudent("Jim", 77);
		roster.addStudent("Ron", 78);
		roster.addStudent("Tom", 82);
		roster.addStudent("Jim", 62);
		roster.addStudent("Jon", 55);
		roster.removeAllStudentsWithName("Jim");
		roster.removeAllStudentsWithName("Jon");
		assertEquals(2, roster.getNumberOfStudents());
		assertFalse(roster.hasStudentWithName("Jim"));
		assertTrue(roster.hasStudentWithName("Ron"));
		assertTrue(roster.hasStudentWithName("Tom"));
		assertFalse(roster.hasStudentWithName("Jon"));
	}
}




