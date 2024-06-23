package task;

import java.util.ArrayList;

import task.Task;

public class Task_Service {
	// Array for storing task objects.
	ArrayList<Task> taskList = new ArrayList<Task>();
	
	// Adds tasks with a unique ID value.
	public ArrayList<Task> addTask(Task newTask) {
		
		if (taskList.isEmpty()) {
			taskList.add(newTask);
		}
		else {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getID().equals(newTask.getID())) {
					throw new IllegalArgumentException("ID already added");
				}
			}
			taskList.add(newTask);
		}
		
		return taskList;
	}
	// Deletes tasks by looping through task array and using the ID of the task to be removed.
	public ArrayList<Task> deleteTask(Task removeTask) {
		for (int j = 0; j < taskList.size(); j++) {
			if (taskList.get(j).getID().equals(removeTask.getID())) {
				taskList.remove(j);
				break;
			}
		}
		
		return taskList;
	}
	// Updates tasks name and description in array by finding id within the array, replacing name
	// or description with updated term.
	public ArrayList<Task> updateTask(Task updateTask, String updateAttr, String updateTerm) {
		
		if (taskList.contains(updateTask) == false) {
			throw new IllegalArgumentException("ID not found");
		}
		else {
			for (int h = 0; h < taskList.size(); h++) {
				if (taskList.get(h).getID().equals(updateTask.getID())) {
					if (updateAttr == "name"){
						taskList.get(h).setName(updateTerm);
					}
					else if (updateAttr == "description") {
						taskList.get(h).setDescription(updateTerm);
					}
					break;
				}
			}
		}
		return taskList;
	}
}
