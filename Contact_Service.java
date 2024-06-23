package contact;

import java.util.ArrayList;

import contact.Contact;

public class Contact_Service {
	// Array to add, remove, and update contact objects.
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	// Method adds contacts to an array using the ID attribute. Throw exception if contact with same ID is
	// already added in the array.
	public ArrayList<Contact> addContact(Contact newContact) {
		
		if (contactList.isEmpty()) {
			contactList.add(newContact);
		}
		else {
			for (int i = 0; i < contactList.size(); i++) {
				if (contactList.get(i).getID().equals(newContact.getID())) {
					throw new IllegalArgumentException("ID already added");
				}
			}
			contactList.add(newContact);
		}
		
		return contactList;
	}
	
	// Method deletes contacts from an array using the ID attribute.
	public ArrayList<Contact> deleteContact(Contact remove) {
		for (int j = 0; j < contactList.size(); j++) {
			if (contactList.get(j).getID().equals(remove.getID())) {
				contactList.remove(j);
				break;
			}
		}
		return contactList;
	}
	
	// Updates contact object attributes in an array that have the same ID. Otherwise, through exception.
	public ArrayList<Contact> updateContact(Contact updatedContact, String updateAttr, String updateTerm) {
		
		if (contactList.contains(updatedContact) == false) {
			throw new IllegalArgumentException("ID not in contact list");
		}
		else {
			for (int h = 0; h < contactList.size(); h++) {
				if (contactList.get(h).getID().equals(updatedContact.getID())) {
					if (updateAttr == "first name") {
						contactList.get(h).setFirstName(updateTerm);
					}
					else if (updateAttr == "last name") {
						contactList.get(h).setLastName(updateTerm);
					}
					else if (updateAttr == "phone") {
						contactList.get(h).setPhone(updateTerm);
					}
					else if (updateAttr == "address") {
						contactList.get(h).setAddress(updateTerm);
					}
					break;
				}
			}
		}
		
		return contactList;
	}
}
