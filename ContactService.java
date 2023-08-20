//================================================================================
// Jonathan Miller - CS-320 - Project One - ContactService
//================================================================================

import java.util.HashMap;

public class ContactService {
	// Container to hold all the contacts.
	private HashMap<String, Contact> contacts;
	
	/**
	 * Constructor for the ContactService class.
	 */
	public ContactService() {
		// Initialize the contacts container.
		this.contacts = new HashMap<String, Contact>();
	}
	
	//================================================================================
    // Public Methods
    //================================================================================
	
	/**
	 * Accessor method to get the contacts hash map.
	 * 
	 * @returns The hash map of contacts.
	 */
	public HashMap<String, Contact> getContacts() {
		return contacts;
	}
	
	/**
	 * Add a new contact to the hash map with the given parameters if the contact ID is unique.
	 * 
	 * @param contactId - The unique contact ID for the new contact.
	 * @param firstName - The first name for the new contact.
	 * @param lastName - The last name for the new contact.
	 * @param phone - The phone number for the new contact.
	 * @param address - The new address for the new contact.
	 */
	public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
		// If the hash map does not contain the given contact ID.
		if (!contacts.containsKey(contactId)) {
			// Create the new contact.
			Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
		
			// Add the new contact to the hash map.
			contacts.put(contactId, newContact);
		}
		else {
			// Print a message to the console.
			System.out.print("Contact already exists.");
		}
	}
	
	/**
	 * Delete a specified contact with the given contact ID from the hash map.
	 * 
	 * @param contactId - The unique contact ID for the specified contact.
	 */
	public void deleteContact(String contactId) {
		// If the hash map contains the given contact ID...
		if (contacts.containsKey(contactId)) {
			// Delete the specified contact from the hash map.
			contacts.remove(contactId);
		}
		else {
			// Print a message to the console.
			System.out.print("Contact does not exist.");
		}
	}
	
	/**
	 * Update the first name for the specified contact with the given contact ID.
	 * 
	 * @param contactId - The unique contact ID for the specified contact.
	 * @param firstName - The new first name for the specified contact.
	 */
	public void updateContactFirstName(String contactId, String firstName) {
		// If the contact exists in the hash map...
		if (contacts.containsKey(contactId)) {
			// Update the contact's first name.
			contacts.get(contactId).setFirstName(firstName);
		}
		else
		{
			// Print a message to the console.
			System.out.print("Contact does not exist.");
		}
	}
	
	/**
	 * Update the last name for the specified contact with the given contact ID.
	 * 
	 * @param contactId - The contact ID for the specified contact.
	 * @param lastName - The new last name for the specified contact.
	 */
	public void updateContactLastName(String contactId, String lastName) {
		// If the contact exists in the hash map...
		if (contacts.containsKey(contactId)) {
			// Update the contact's last name.
			contacts.get(contactId).setLastName(lastName);
		}
		else
		{
			// Print a message to the console.
			System.out.print("Contact does not exist.");
		}
	}
	
	/**
	 * Update the phone number for the specified contact with the given contact ID.
	 * 
	 * @param contactId - The contact ID for the specified contact.
	 * @param phone - The new phone number for the specified contact.
	 */
	public void updateContactPhone(String contactId, String phone) {
		// If the contact exists in the hash map...
		if (contacts.containsKey(contactId)) {
			// Update the contact's phone number.
			contacts.get(contactId).setPhone(phone);
		}
		else
		{
			// Print a message to the console.
			System.out.print("Contact does not exist.");
		}
	}
	
	/**
	 * Update the address for the specified contact with the given contact ID.
	 * 
	 * @param contactId - The contact ID for the specified contact.
	 * @param address - The new address for the specified contact.
	 */
	public void updateContactAddress(String contactId, String address) {
		// If the contact exists in the hash map...
		if (contacts.containsKey(contactId)) {
			// Update the contact's address.
			contacts.get(contactId).setAddress(address);
		}
		else
		{
			// Print a message to the console.
			System.out.print("Contact does not exist.");
		}
	}
}
