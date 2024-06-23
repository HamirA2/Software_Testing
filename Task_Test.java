package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.Task;

class Task_Test {

	// Test verifies task objects can be created with id, name, and description.
	@Test
	void taskTest() {
		Task newTask = new Task("JJJ1234567", "Pancake", "Works with butter");
		assertTrue(newTask.getID().equals("JJJ1234567"));
		assertTrue(newTask.getName().equals("Pancake"));
		assertTrue(newTask.getDescription().equals("Works with butter"));
	}
	// Test checks if exceptions are thrown for invalid task attributes.
	@Test
	void taskExceptionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, null, null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Greater than 10!", "Testing class", "True or false");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Reg 111", null, "IsEmpty");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("200", "Longer than twenty characters", "Department");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("ID 888", "Dragon Lizard", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123", "Short", "Longer than fifty characters/fifty characters throw exception");
		});
	}

}
