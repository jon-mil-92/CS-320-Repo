//================================================================================
// Jonathan Miller - CS-320 - Project One - Appointment
//================================================================================

import java.util.*;

public class Appointment {
	// Appointment fields.
	private String appointmentId;
	private Date date;
	private String description;
	
	// Constants.
	private static final int MAX_ID_LENGTH = 10;
	private static final int MAX_DESCRIPTION_LENGTH = 50;
	
	// The default constructor is hidden to ensure unique appointment ID's.
	@SuppressWarnings("unused")
	private Appointment() {}
	
	/**
	 * Constructor for the Appointment class.
	 * 
	 * @param appointmentId - The unique appointment ID for the new appointment.
	 * @param date - The date for the appointment.
	 * @param description - The description for the appointment.
	 */
	public Appointment(String appointmentId, Date date, String description) {
		// Verify format for all fields.
		checkAppointmentIdFormat(appointmentId);
		checkDateFormat(date);
		checkDescriptionFormat(description);
		
		// Initialize fields.
		this.appointmentId = appointmentId;
		this.date = date;
		this.description = description;
	}
	
	//================================================================================
	// Private Input Format Checker Methods
	//================================================================================
	
	/**
	 * Check the format of the given appointment ID.
	 * 
	 * @param appointmentId - The appointment ID to check proper formatting for.
	 */
	private void checkAppointmentIdFormat(String appointmentId) {
		// Verify the appointment ID format.
		if (appointmentId == null || appointmentId.length() > MAX_ID_LENGTH) {
			// Throw an error if the appointment ID is null or too long.
			throw new IllegalArgumentException("Invalid appointment ID format.");
		}
	}
	
	/**
	 * Check the format of the given date.
	 * 
	 * @param date - The date to check proper formatting for.
	 */
	private void checkDateFormat(Date date) {
		// Verify the date format.
		if (date == null || date.before(new Date())) {
			// Throw an error if the date is null or in the past.
			throw new IllegalArgumentException("Invalid date.");
		}
	}
	
	/**
	 * Check the format of the given description.
	 * 
	 * @param description - The description to check proper formatting for.
	 */
	private void checkDescriptionFormat(String description) {
		// Verify the description format.
		if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
			// Throw an error if the description is null or too long.
			throw new IllegalArgumentException("Invalid description format.");
		}
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	/**
	 * Accessor method for the appointment ID.
	 * 
	 * @return The appointment ID for this appointment.
	 */
	public String getAppointmentId() {
		return appointmentId;
	}
	
	/**
	 * Accessor method for the date.
	 * 
	 * @return The date for this appointment.
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Accessor method for the description.
	 * 
	 * @return The description for this appointment.
	 */
	public String getDescription() {
		return description;
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	/**
	 * Mutator method for the description.
	 * 
	 * @param description - The new description for this appointment.
	 */
	public void setDescription(String description) {
		// Verify the format of the given description.
		checkDescriptionFormat(description);
		
		// Update this appointment's description.
		this.description = description;
	}
	
	/**
	 * Mutator method for the date.
	 * 
	 * @param date - The new date for this appointment.
	 */
	public void setDate(Date date) {
		// Verify the format of the given date.
		checkDateFormat(date);
		
		// Update this appointment's date.
		this.date = date;
	}
}