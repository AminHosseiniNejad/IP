package testIP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import IP.Task;

public class TaskTest {
	Task aTask;

	@BeforeEach
	public void setUp() {
		aTask = new Task("Buy a gift card", "23-09-2019", "toDo");
	}

	@Test
	public void testSetTaskTilte() {
		aTask.setTaskTitle("Buy a gift card");
		assertEquals(aTask.getTaskTitle(), "Buy a gift card");
		try {
			aTask.setTaskTitle(null);
			fail("null task titles should throw error");
		} catch (Exception e) {

		}

	}

	@Test
	void testSetProjectDueDate() {
		aTask.setTaskDueDate("23-09-2019");
		assertEquals(aTask.getTaskDueDate(), "23-09-2019");
		try {
			aTask.setTaskDueDate(null);
			fail("null task due date should throw error");
		} catch (Exception e) {
		}
		
		try {
			aTask.setTaskTitle("35-13-2019");
			fail("Number of the days more than 31 and number of the months more tha 12 in task due dates should throw error");
		} catch (Exception e) {

		}

		try {
			aTask.setTaskTitle("20/13/2019");
			fail("Any seperator other than '-' in task due date formats should throw error");
		} catch (Exception e) {

		}
	}

	@Test
	void testSetTaskStatus() {
		aTask.setTaskStatus("toDo");
		assertEquals(aTask.getTaskStatus(), "toDo");
		try {
			aTask.setTaskStatus(null);
			fail("null task status should throw error");
		} catch (Exception e) {

		}
		
		try {
			aTask.setTaskStatus("anything");
			fail(" Anything other than either 'toDo' or 'done' as task status should throw error");
		} catch (Exception e) {

		}

	}

}
