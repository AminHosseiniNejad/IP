package testIP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import IP.Project;

public class ProjectTest {
	Project aProject;

	@BeforeEach
	public void setUp() {
		aProject = new Project("Party", "23-09-2019", "toDo");
	}

	@Test
	public void testSetProjectTilte() {
		aProject.setProjectTitle("Party");
		assertEquals(aProject.getProjectTitle(), "Party");
		try {
			aProject.setProjectTitle(null);
			fail("null project titles should throw error");
		} catch (Exception e) {

		}

	}

	@Test
	void testSetProjectDueDate() {
		aProject.setProjectDueDate("23-09-2019");
		assertEquals(aProject.getProjectDueDate(), "23-09-2019");
		try {
			aProject.setProjectDueDate(null);
			fail("null project due date should throw error");
		} catch (Exception e) {
		}
		
		try {
			aProject.setProjectTitle("35-13-2019");
			fail("Number of the days more than 31 and number of the months more tha 12 in project due dates should throw error");
		} catch (Exception e) {

		}

		try {
			aProject.setProjectTitle("20/13/2019");
			fail("Any seperator other than '-' in project due date formats should throw error");
		} catch (Exception e) {

		}
	}

	@Test
	void testSetProjectStatus() {
		aProject.setProjectStatus("toDo");
		assertEquals(aProject.getProjectStatus(), "toDo");
		try {
			aProject.setProjectStatus(null);
			fail("null task status should throw error");
		} catch (Exception e) {

		}
		
		try {
			aProject.setProjectStatus("anything");
			fail(" Anything other than either 'toDo' or 'done' as project status should throw error");
		} catch (Exception e) {

		}

	}

}
