package ContactSource;

import java.util.ArrayList;

public class ContactService {
	
	String uniqueID = "0";
	public ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	//Each contact will have a unique ID starting from 0 that increments by 1,
	// as a simple way to ensure no collisions
	private String newUniqueID() {
		int uniqueIdInt = Integer.parseInt(this.uniqueID); //Converting string to int so that we can increment it
		this.uniqueID = String.valueOf(uniqueIdInt++); //Incrementing and then converting back to string to satisfy requirements
		return this.uniqueID;
	}
	
	private int findContact(String ID) throws Exception {
		int i = 0;
		while (i < contactList.size()) {
			if (ID.equals(contactList.get(i).getID())) {
				return i;
			}
			++i;
		}
		throw new Exception("Contact not found");
	}
	
	//Simply adding a new contact will guarantee a unique ID (unique ID does not need to be explicitly provided as an argument)
	public void addContact(String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(newUniqueID(), firstName, lastName, phone, address);
		contactList.add(contact);
	}
	
	public void removeContact(String ID) throws Exception {
		contactList.remove(findContact(ID));
	}
	
	//Verifying that contact attributes are not null and meet length min/max requirements
	public void updateFirstName(String ID, String firstName) {
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid name");
		}
		int contactIndex = Integer.parseInt(ID);
		contactList.get(contactIndex).setFirstName(firstName);
	}
	
	public void updateLastName(String ID, String lastName) {
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid name");
		}
		int contactIndex = Integer.parseInt(ID);
		contactList.get(contactIndex).setLastName(lastName);		
	}

	public void updatePhone(String ID, String phone) {
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		int contactIndex = Integer.parseInt(ID);
		contactList.get(contactIndex).setPhone(phone);		
	}
	
	public void updateAddress(String ID, String address) {
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		}
		int contactIndex = Integer.parseInt(ID);
		contactList.get(contactIndex).setAddress(address);		
	}
}
