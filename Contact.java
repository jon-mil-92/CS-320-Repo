//================================================================================
// Jonathan Miller - CS-320 - Project One - Contact
//================================================================================

public class Contact {
	// contact fields.
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constants.
	private static final int MAX_ID_LENGTH = 10;
	private static final int MAX_FIRST_NAME_LENGTH = 10;
	private static final int MAX_LAST_NAME_LENGTH = 10;
	private static final int PHONE_LENGTH = 10;
	private static final int MAX_ADDRESS_LENGTH = 30;
	
	// The default constructor is hidden to ensure unique contact ID's.
	@SuppressWarnings("unused")
	private Contact() {}
	
	/**
	 * Constructor for the Contact class.
	 * 
	 * @param contactId - The unique ID for this contact.
	 * @param firstName - The first name for this contact.
	 * @param lastName - The last name for this contact.
	 * @param phone - The phone number for this contact.
	 * @param address - The address for this contact.
	 */
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// Verify format for all fields.
		checkContactIdFormat(contactId);
		checkFirstNameFormat(firstName);
		checkLastNameFormat(lastName);
		checkPhoneFormat(phone);
		checkAddressFormat(address);
		
		// Initialize fields.
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	//================================================================================
    // Private Input Format Checker Methods
    //================================================================================
	
	/**
	 * Check the format of the given contact ID.
	 * 
	 * @param contactId - The contact ID to check for proper formatting.
	 */
	private void checkContactIdFormat(String contactId) {
		// Verify the contact ID format.
		if (contactId == null || contactId.length() > MAX_ID_LENGTH) {
			// Throw an error if the contact ID format is incorrect.
			throw new IllegalArgumentException("Invalid contact ID format.");
		}
	}
	
	/**
	 * Check the format of the given first name.
	 * 
	 * @param firstName - The first name to check for proper formatting.
	 */
	private void checkFirstNameFormat(String firstName) {
		// Verify the first name format.
		if (firstName == null || firstName.length() > MAX_FIRST_NAME_LENGTH) {
			// Throw an error if the first name format is incorrect.
			throw new IllegalArgumentException("Invalid first name format.");
		}
	}
	
	/**
	 * Check the format of the given last name.
	 * 
	 * @param lastName - The last name to check for proper formatting.
	 */
	private void checkLastNameFormat(String lastName) {
		// Verify the last name format.
		if (lastName == null || lastName.length() > MAX_LAST_NAME_LENGTH) {
			// Throw an error if the last name format is incorrect.
			throw new IllegalArgumentException("Invalid last name format.");
		}
	}
	
	/**
	 * Check the format of the given phone number.
	 * 
	 * @param phone - The phone number to check for proper formatting.
	 */
	private void checkPhoneFormat(String phone) {
		// Verify the phone number format.
		if (phone == null || phone.length() != PHONE_LENGTH) {
			// Throw an error if the phone number format is incorrect.
			throw new IllegalArgumentException("Invalid phone number format.");
		}
	}
	
	/**
	 * Check the format of the given address.
	 * 
	 * @param address - The address to check for proper formatting.
	 */
	private void checkAddressFormat(String address) {
		// Verify the address format.
		if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
			// Throw an error if the address format is incorrect.
			throw new IllegalArgumentException("Invalid address format.");
		}
	}
	
	//================================================================================
    // Accessors
    //================================================================================
	
	/**
	 * Accessor method for the contact ID.
	 * 
	 * @return The contact ID for this contact.
	 */
	public String getContactId() {
		return this.contactId;
	}
	
	/**
	 * Accessor method for the first name.
	 * 
	 * @return The first name for this contact.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Accessor method for the last name.
	 * 
	 * @return The last name for this contact.
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Accessor method for the phone number.
	 * 
	 * @return The phone number for this contact.
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Accessor method for the address.
	 * 
	 * @return The address for this contact.
	 */
	public String getAddress() {
		return this.address;
	}
	
	//================================================================================
    // Mutators
    //================================================================================
	
	/**
	 * Mutator method for the first name.
	 * 
	 * @param firstName - The new first name for this contact.
	 */
	public void setFirstName(String firstName) {
		// Verify the format of the given first name.
		checkFirstNameFormat(firstName);
		
		// Update this contact's first name.
		this.firstName = firstName;
	}
	
	/**
	 * Mutator method for the last name.
	 * 
	 * @param lastName - The new last name for this contact.
	 */
	public void setLastName(String lastName) {
		// Verify the format of the given last name.
		checkLastNameFormat(lastName);
		
		// Update this contact's last name.
		this.lastName = lastName;
	}
	
	/**
	 * Mutator method for the phone number.
	 * 
	 * @param phone - The new phone number for this contact.
	 */
	public void setPhone(String phone) {
		// Verify the format of the given phone number.
		checkPhoneFormat(phone);
		
		// Update this contact's phone number.
		this.phone = phone;
	}
	
	/**
	 * Mutator method for the address.
	 * 
	 * @param address - The new address for this contact.
	 */
	public void setAddress(String address) {
		// Verify the format of the given address.
		checkAddressFormat(address);
		
		// Update this contact's address.
		this.address = address;
	}
}