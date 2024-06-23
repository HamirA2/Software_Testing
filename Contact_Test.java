package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class Contact_Test {

	// Test to ensure a contact object with attributes can be created.
	@Test
	void testContactClass() {
		Contact contactOne = new Contact ("123", "Ham", "Turkey", "1800000000", "Round Way Circle");
		assertTrue(contactOne.getID().equals("123"));
		assertTrue(contactOne.getFirstName().equals("Ham"));
		assertTrue(contactOne.getLastName().equals("Turkey"));
		assertTrue(contactOne.getPhone().equals("1800000000"));
		assertTrue(contactOne.getAddress().equals("Round Way Circle"));
	}
	
	// Test case successfully throws illegal argument exceptions when object params are null.
	@Test
	void testContactClassNull() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Ham", "Abc", "1234567890", null);
			});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("202", null, "Abc", "1234567890", "246 Lane Street");
			});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("202", "Ham", null, "1234567890", "246 Lane Street");
			});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("202", "Ham", "Abc", null, "246 Lane Street");
			});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("202", "Ham", "Abc", "1111111111", null);
			});
		}
	
	// Test method throws illegal argument exceptions when proper attribute lengths are not met.
	@Test
	void testContactClassLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Mah", "efg", "2222222222", "Corner");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Longer than 10", "efg", "2222222222", "Corner");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Mah", "Really long last name", "2222222222", "Corner");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Ham", "Run", "1800", "Corner");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "Water", "Techno", "2222222222", "WatermelonTechnologyAgriculture123");
		});
	}
}
