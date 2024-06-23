package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.Task;

import task.Task_Service;

class Task_Service_Test {

	// Test verifies task objects can be added using addTask().
	// Throws exception if task with the same ID is already added.
	@Test
	void addTaskTest() {
		Task_Service taskService = new Task_Service();
		Task firstTask = new Task("000", "Vanilla Swirl", "Tasty Cool Treat");
		Task secondTask = new Task("Dino 1", "T Rex", "Large Extinct Predator");
		Task thirdTask = new Task("Planet", "Mars", "Looks like a desert");
		
		assertTrue(taskService.addTask(firstTask).contains(firstTask));
		assertTrue(taskService.addTask(secondTask).contains(secondTask));
		assertTrue(taskService.addTask(thirdTask).indexOf(thirdTask) == 2);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(new Task("000", "Mint Chocolate", "Minty Cool Treat"));
		});
		
	}
	// Test the deleteTask method showing tasks are no longer in array when deleted.
	@Test
	void deleteTaskTest() {
		Task_Service deleteService = new Task_Service();
		Task testTask = new Task("Furniture", "A Bed", "Used for resting");
		Task testTask2 = new Task("Furniture2", "Big Couch", "Used for laying down");
		Task testTask3 = new Task("Furniture3", "Dining Chair", "Used for eating while sitting");
		
		deleteService.addTask(testTask);
		deleteService.addTask(testTask2);
		deleteService.addTask(testTask3);
		
		assertTrue(deleteService.deleteTask(testTask3).indexOf(testTask3) == -1);
		assertTrue(deleteService.deleteTask(testTask).indexOf(testTask) == -1);
	}
	// Tests the updateTask method.
	@Test
	void updateTaskTest() {
		Task_Service updateService = new Task_Service();
		Task updateTask1 = new Task("Comp 10", "Tech Guy", "Works on the computer");
		Task updateTask2 = new Task("NUR 2", "Nurse Nancy", "Helps patients feel secure");
		Task updateTask3 = new Task("Plum 1", "Jake Plumber", "Fixes toilets");
		
		updateService.addTask(updateTask1);
		updateService.addTask(updateTask2);
		updateService.addTask(updateTask3);
		
		// Checks if new attributes get added to each task attribute properly.
		assertTrue(updateService.updateTask(updateTask1, "name", "Tech Associate").get(0).getName().equals
				  ("Tech Associate"));
		assertTrue(updateService.updateTask(updateTask1, "name", "Tech Associate").get(0).getDescription()
				 .equals("Works on the computer"));
		
		assertTrue(updateService.updateTask(updateTask2, "description", "Healer").get(1).getDescription()
				.equals("Healer"));
		
		assertTrue(updateService.updateTask(updateTask3, "name", "Plumber Jake").get(2).getName().equals
				("Plumber Jake"));
		assertTrue(updateService.updateTask(updateTask3, "description", "Master Plumber").get(2).
				getDescription().equals("Master Plumber"));
	}
	// Test verifies exceptions when attributes are updated with null or longer characters.
	@Test
	void updateTaskExceptionTest() {
		Task_Service badUpdate = new Task_Service();
		Task notUpdatable = new Task("456", "Dirt", "Top layer of Earth");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			badUpdate.updateTask(notUpdatable, "name", "Soil");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			badUpdate.addTask(notUpdatable);
			badUpdate.updateTask(notUpdatable, "name", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			badUpdate.updateTask(notUpdatable, "name", "surface of the Earth allows standing");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			badUpdate.updateTask(notUpdatable, "description", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			badUpdate.updateTask(notUpdatable, "description", "Really long and unnecessary description for testing error");
		});
	}

}
