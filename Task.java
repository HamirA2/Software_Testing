package task;

// Task class with id, name, and description attributes.
public class Task {

	private String ID;
	private String name;
	private String description;
	
	// Constructor assigns proper values to each attribute, throws exceptions if invalid.
	public Task(String ID, String name, String description) {
		
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		// Assign attributes if no error is thrown.
		this.ID = ID;
		this.name = name;
		this.description = description;
	}
	
	// Getter methods.
	public String getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	//Setter methods with exceptions to prevent invalid name and description updates.
	public void setName(String newName) {
		if (newName == null || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		this.name = newName;
	}
	
	public void setDescription(String newDescription) {
		if (newDescription == null || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.description = newDescription;
	}
}
