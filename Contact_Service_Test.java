package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contact.Contact_Service;
import contact.Contact;

class Contact_Service_Test {

	// Test checks the addContact, seeing if contacts can be added by ID to an array.
	// If a contact with an ID is already added exception is thrown.
	@Test
	void addContactTest() {
		Contact_Service addThisContact = new Contact_Service();
		Contact newContact = new Contact("AB111", "Jay", "May", "1234567891", "Circle Rd");
		assertTrue(addThisContact.addContact(newContact).indexOf(newContact) > -1);
		
		Contact newContact2 = new Contact("AC111", "Greg", "Grape", "5552228778", "Diamond Court");
		assertTrue(addThisContact.addContact(newContact2).indexOf(newContact2) > -1);
		
		Contact newContact3 = new Contact("AB111", "Phil", "Bill", "3455476841", "Triangle St");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			addThisContact.addContact(newContact3);
		});
	}
	// Test to verify deleteContact method functions as intended.
	@Test
	void deleteContactTest() {
		Contact_Service removeContact = new Contact_Service();
		Contact deleteTheContact = new Contact("ABC 100", "Later", "Remove", "1111111111", "Town");
		Contact keepContact = new Contact("201", "Keep", "Contact", "4321119800", "Stay in city");
		
		removeContact.addContact(deleteTheContact);
		removeContact.addContact(keepContact);
		
		assertTrue(removeContact.deleteContact(deleteTheContact).indexOf(deleteTheContact) == -1);
		assertTrue(removeContact.deleteContact(deleteTheContact).indexOf(keepContact) == 0);
	}
	// Test case for the updateContact method, checks for proper updates of attributes.
	@Test
	void updateContactTest() {
		Contact_Service updateContact = new Contact_Service();
		Contact firstContact = new Contact("101", "John", "John", "5555555555", "Square City");
		Contact secondContact = new Contact("300", "Up", "Down", "7779997997", "Location");
		Contact thirdContact = new Contact("CS 101", "Dog", "Jog", "3336669991", "Ruff Ruff Drive");
		
		updateContact.addContact(firstContact);
		updateContact.addContact(secondContact);
		updateContact.addContact(thirdContact);
		
		assertTrue(updateContact.updateContact(firstContact, "first name", "Bohn").get(0).getFirstName()
				.equals("Bohn"));
		
		assertTrue(updateContact.updateContact(secondContact, "last name", "Side").get(1).getLastName()
				.equals("Side"));

		assertTrue(updateContact.updateContact(thirdContact, "first name", "Big Dog").get(2).getFirstName()
				.equals("Big Dog"));
		assertTrue(updateContact.updateContact(thirdContact, "last name", "Jogger").get(2).getLastName()
				.equals("Jogger"));
		assertTrue(updateContact.updateContact(thirdContact, "phone", "5657092219").get(2).getPhone()
				.equals("5657092219"));
		assertTrue(updateContact.updateContact(thirdContact, "address", "Barky Avenue").get(2).getAddress()
				.equals("Barky Avenue"));
	}
	
	// Tests the error messages of the updateContact method. Includes error for updating a contact
	// with an ID that is not in contact array and errors for updating attributes with null or
	// illegal character lengths.
	@Test
	void updateContactExceptionsTest() {
		Contact_Service errorUpdate = new Contact_Service();
		Contact illegalContact = new Contact("900", "Error", "Update", "1111111111", "Wrong Turn");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.updateContact(illegalContact, "address", "Right Turn");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.addContact(illegalContact);
			errorUpdate.updateContact(illegalContact, "first name", "Ten characters is not enough");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.updateContact(illegalContact, "first name", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.updateContact(illegalContact, "last name", "I like long last names");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.updateContact(illegalContact, "last name", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.updateContact(illegalContact, "phone", "1800");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.updateContact(illegalContact, "phone", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.updateContact(illegalContact, "address", "Thirty characters for an address");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			errorUpdate.updateContact(illegalContact, "address", null);
		});
	}
	
}
