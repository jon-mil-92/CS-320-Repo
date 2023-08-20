import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testGetContactId() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Verify the contact's contact ID.
		assertTrue(contact.getContactId().equals("1"));
	}
	
	@Test
	void testGetFirstName() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Verify the contact's first name.
		assertTrue(contact.getFirstName().equals("Jonathan"));
	}
	
	@Test
	void testGetLastName() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Verify the contact's last name.
		assertTrue(contact.getLastName().equals("Miller"));
	}
	
	@Test
	void testGetPhone() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Verify the contact's phone number.
		assertTrue(contact.getPhone().equals("9998887777"));
	}
	
	@Test
	void testGetAddress() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Verify the contact's address.
		assertTrue(contact.getAddress().equals("Urbana"));
	}
	
	@Test
	void testSetFirstName() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Try to set a new first name.
		contact.setFirstName("John");
		
		// Verify the new first name was set.
		assertTrue(contact.getFirstName().equals("John"));
	}
	
	@Test
	void testSetLastName() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Try to set a new last name.
		contact.setLastName("Doe");
		
		// Verify the new last name was set.
		assertTrue(contact.getLastName().equals("Doe"));
	}
	
	@Test
	void testSetPhone() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Try to set a new phone number.
		contact.setPhone("8887776666");
		
		// Verify the new description was set.
		assertTrue(contact.getPhone().equals("8887776666"));
	}
	
	@Test
	void testSetAddress() {
		// Test object.
		Contact contact = new Contact("1", "Jonathan", "Miller", "9998887777", "Urbana");
		
		// Try to set a new address.
		contact.setAddress("Ohio");
		
		// Verify the new address was set.
		assertTrue(contact.getAddress().equals("Ohio"));
	}
	
	@Test
	void testTooLongContactId() {
		// Verify an exception was thrown for the too long contact ID.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("*".repeat(11), "Jonathan", "Miller", "9998887777", "Urbana");
		});
	}
	
	@Test
	void testNullContactId() {
		// Verify an exception was thrown for the null contact ID.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Jonathan", "Miller", "9998887777", "Urbana");
		});
	}
	
	@Test
	void testTooLongFirstName() {
		// Verify an exception was thrown for the too long first name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jonathannnn", "Miller", "9998887777", "Urbana");
		});
	}
	
	@Test
	void testNullFirstName() {
		// Verify an exception was thrown for the null first name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Miller", "9998887777", "Urbana");
		});
	}
	
	@Test
	void testTooLongLastName() {
		// Verify an exception was thrown for the too long last name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jonathan", "Millerrrrrr", "9998887777", "Urbana");
		});
	}
	
	@Test
	void testNullLastName() {
		// Verify an exception was thrown for the null last name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jonathan", null, "9998887777", "Urbana");
		});
	}
	
	@Test
	void testInvalidPhoneLength() {
		// Verify an exception was thrown for the invalid phone number length.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jonathan", "Miller", "99988877770", "Urbana");
		});
	}
	
	@Test
	void testNullPhone() {
		// Verify an exception was thrown for the null phone number.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jonathan", "Miller", null, "Urbana");
		});
	}
	
	@Test
	void testTooLongAddress() {
		// Verify an exception was thrown for the too long address.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jonathan", "Miller", "9998887777", 
					"This Address Is Too Long. Try Again.");
		});
	}
	
	@Test
	void testNullAddress() {
		// Verify an exception was thrown for the null address.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jonathan", "Miller", "9998887777", null);
		});
	}
}