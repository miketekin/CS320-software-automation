package ContactTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ContactSource.*;


class ContactServiceTest {
	
	ContactService service;
	
	//Although "addContact" is included in every test, 
	// did not include "addContact" to setup because adding a contact is part of our tests
	@BeforeEach
	void setup() {
		service = new ContactService();
	}
	
	//Adding contacts that each have a unique ID
	@Test
	void testAddContact() {
		service.addContact("John", "Smith", "1234567890", "Home");
		// Verifying that all attributes were stored properly
		assertEquals(service.contactList.get(0).getID(), "0");
		assertEquals(service.contactList.get(0).getFirstName(), "John");
		assertEquals(service.contactList.get(0).getLastName(), "Smith");
		assertEquals(service.contactList.get(0).getPhone(), "1234567890");
		assertEquals(service.contactList.get(0).getAddress(), "Home");
		
		service.addContact("Jane", "Smith", "1234567890", "Home");
		assertNotNull(service.contactList.get(1).getID());
		assertNotNull(service.contactList.get(1).getFirstName());
		assertNotNull(service.contactList.get(1).getLastName());
		assertNotNull(service.contactList.get(1).getPhone());
		assertNotNull(service.contactList.get(1).getAddress());
		
		//Verifying that each contact added has a unique ID and that they are different contacts
		assertFalse(service.contactList.get(0).getID() == service.contactList.get(1).getID());
		assertFalse(service.contactList.get(0).getFirstName() == service.contactList.get(1).getFirstName());
	}

	//Deleting per contact ID
	@Test
	void testRemoveContact() throws Exception {
		service.addContact("John", "Smith", "1234567890", "Home");
		service.addContact("Jane", "Smith", "1234567890", "Home");
		assertEquals(service.contactList.get(0).getFirstName(), "John");
		assertEquals(service.contactList.get(1).getFirstName(), "Jane");
		
		service.removeContact(service.contactList.get(0).getID());
		//Showing that removing our first contact shifts all our contacts left
		assertThrows(IndexOutOfBoundsException.class, () -> {
			service.contactList.get(1);
		});
		assertEquals(service.contactList.get(0).getFirstName(), "Jane");
		
		//Showing that removing our final contact leaves our list empty
		service.removeContact(service.contactList.get(0).getID());
		assertThrows(IndexOutOfBoundsException.class, () -> {
			service.contactList.get(0);
		});
	}
	
	//Updating per contact ID (ID being 0 for the first contact added to our list)
	@Test
	void updateFirstName() {
		service.addContact("John", "Smith", "1234567890", "Home");
		service.updateFirstName("0", "Dave");
		assertEquals(service.contactList.get(0).getFirstName(), "Dave");
	}

	@Test
	void updateLastName() {
		service.addContact("John", "Smith", "1234567890", "Home");
		service.updateLastName("0", "Doe");
		assertEquals(service.contactList.get(0).getLastName(), "Doe");
	}

	@Test
	void updatePhone() {
		service.addContact("John", "Smith", "1234567890", "Home");
		service.updatePhone("0", "0123456789");
		assertEquals(service.contactList.get(0).getPhone(), "0123456789");
	}
	
	@Test
	void updateAddress() {
		service.addContact("John", "Smith", "1234567890", "Home");
		service.updateAddress("0", "The Moon");
		assertEquals(service.contactList.get(0).getAddress(), "The Moon");
	}

}
