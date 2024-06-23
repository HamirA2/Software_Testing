package contact;

public class Contact {
	// Defined the string attributes for the Contact class.
	private String ID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor ensures that proper values are used for attributes. If not throw error.
	public Contact(String ID, String firstName, String lastName, String phone, String address) {
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		// Assign attributes with the arguments in constructor if no exception is thrown.
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	// Getter methods.
	public String getID() {
		return ID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	// Setter methods with error messages to ensure updates follow proper format.
	public void setFirstName(String newFirstName) {
		if (newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		this.firstName = newFirstName;
	}
	public void setLastName(String newLastName) {
		if (newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		this.lastName = newLastName;
	}
	public void setPhone(String newPhone) {
		if (newPhone == null || newPhone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		this.phone = newPhone;
	}
	public void setAddress(String newAddress) {
		if (newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.address = newAddress;
	}
}
