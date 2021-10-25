package ContactTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ContactSource.Contact;



class ContactTest {
	
	@Test
	void testContactClass() {
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "The Moon");
		assertTrue(contact.getID().equals("12345"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("The Moon"));
	}
	
	@Test
	void testContactIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "John", "Smith", "1234567890", "The Moon");
		});
	}
	
	@Test
	void testContactIDIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Smith", "1234567890", "The Moon");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Johnyyyyyyy", "Smith", "1234567890", "The Moon");
		});
	}
	
	@Test
	void testContactFirstNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", null, "Smith", "1234567890", "The Moon");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smiiiiiiith", "1234567890", "The Moon");
		});
	}
	
	@Test
	void testContactLastNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "John", null, "1234567890", "The Moon");
		});
	}
	
	@Test
	void testContactPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "12345678901", "The Moon");
		});
	}
	
	@Test
	void testContactPhoneIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "John", "Smith", null, "The Moon");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "1234567890", "The Moon In Outer Space Thats Really Far");
		});
	}
	
	@Test
	void testContactAddressIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "John", "Smith", "1234567890", null);
		});
	}

}
