import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	private final PrintStream initialConsoleOutput = System.out;
	
	@BeforeEach
	private void setOutputStream() {
	    System.setOut(new PrintStream(consoleOutput));
	}
	
	@AfterEach
	private void restoreInitialOutputStream() {
	    System.setOut(initialConsoleOutput);
	}
	
	@Test
	void testAddContact() {
		// Test object.
		ContactService contactService = new ContactService();
		
		// Try to add a valid contact.
		contactService.addContact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Verify the contact was added.
		assertTrue(contactService.getContacts().containsKey("1"));
	}
	
	@Test
	void testAddInvalidContact() {
		// Test object.
		ContactService contactService = new ContactService();

		// Verify an exception occurs when trying to add the invalid contact.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Try to add an invalid contact.
			contactService.addContact("*".repeat(11), "*".repeat(11), "*".repeat(11), "*".repeat(11), "*".repeat(31));
		});
	}
	
	@Test
	void testAddDuplicateContact() {
		// Test object.
		ContactService contactService = new ContactService();
		
		// Try to add a valid contact.
		contactService.addContact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Try to add another valid contact with the same contact ID.
		contactService.addContact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Verify a duplicate contact was not added.
		assertTrue(contactService.getContacts().size() == 1);
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Contact already exists."));
	}
	
	@Test
	void testDeleteContact() {
		// Test object.
		ContactService contactService = new ContactService();
				
		// Try to add a valid contact.
		contactService.addContact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Try to delete a contact that already exists.
		contactService.deleteContact("1");
		
		// Verify the contact was deleted from the contacts hash map.
		assertFalse(contactService.getContacts().containsKey("1"));
	}
	
	@Test
	void testDeleteNonExistentContact() {
		// Test object.
		ContactService contactService = new ContactService();
		
		// Get the current contacts hash map.
		HashMap<String, Contact> currentContacts = contactService.getContacts();
		
		// Try to delete a contact that does not exist.
		contactService.deleteContact("1");
		
		// Verify the contact hash map is unchanged.
		assertTrue(currentContacts == contactService.getContacts());
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Contact does not exist."));
	}
	
	@Test
	void testUpdateFirstName() {
		// Test object.
		ContactService contactService = new ContactService();
						
		// Try to add a valid contact.
		contactService.addContact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Update the first name.
		contactService.updateContactFirstName("1", "John");
		
		// Verify that the first name has changed.
		assertTrue(contactService.getContacts().get("1").getFirstName().equals("John"));
	}
	
	@Test
	void testUpdateNonExistentContactFirstName() {
		// Test object.
		ContactService contactService = new ContactService();

		// Update the first name.
		contactService.updateContactFirstName("1", "Jonathan");
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Contact does not exist."));
	}
	
	@Test
	void testUpdateLastName() {
		// Test object.
		ContactService contactService = new ContactService();
						
		// Try to add a valid contact.
		contactService.addContact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Update the last name.
		contactService.updateContactLastName("1", "Doe");
		
		// Verify that the last name has changed.
		assertTrue(contactService.getContacts().get("1").getLastName().equals("Doe"));
	}
	
	@Test
	void testUpdateNonExistentContactLastName() {
		// Test object.
		ContactService contactService = new ContactService();

		// Update the last name.
		contactService.updateContactLastName("1", "Miller");
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Contact does not exist."));
	}
	
	@Test
	void testUpdatePhone() {
		// Test object.
		ContactService contactService = new ContactService();
						
		// Try to add a valid contact.
		contactService.addContact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Update the phone number.
		contactService.updateContactPhone("1", "8887776666");
		
		// Verify that the phone number has changed.
		assertTrue(contactService.getContacts().get("1").getPhone().equals("8887776666"));
	}
	
	@Test
	void testUpdateNonExistentContactPhone() {
		// Test object.
		ContactService contactService = new ContactService();

		// Update the phone number.
		contactService.updateContactPhone("1", "9998887777");
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Contact does not exist."));
	}
	
	@Test
	void testUpdateAddress() {
		// Test object.
		ContactService contactService = new ContactService();
						
		// Try to add a valid contact.
		contactService.addContact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Update the address.
		contactService.updateContactAddress("1", "Columbus");
		
		// Verify that the address has changed.
		assertTrue(contactService.getContacts().get("1").getAddress().equals("Columbus"));
	}
	
	@Test
	void testUpdateNonExistentContactAddress() {
		// Test object.
		ContactService contactService = new ContactService();

		// Update the address.
		contactService.updateContactAddress("1", "Urbana");
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Contact does not exist."));
	}
}