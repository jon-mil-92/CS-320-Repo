//================================================================================
// Jonathan Miller - CS-320 - Project One - AppointmentService
//================================================================================

import java.util.Date;
import java.util.HashMap;

public class AppointmentService {
	// Container to hold all the appointments.
	private HashMap<String, Appointment> appointments;
	
	/**
	 * Constructor for the AppointmentService class.
	 */
	public AppointmentService() {
		// Initialize the appointments container.
		this.appointments = new HashMap<String, Appointment>();
	}
	
	//================================================================================
    // Public Methods
    //================================================================================
	
	/**
	 * Accessor method to get the appointments hash map.
	 * 
	 * @returns The hash map of appointments.
	 */
	public HashMap<String, Appointment> getAppointments() {
		return appointments;
	}
	
	/**
	 * Add a new appointment to the hash map with the given appointment ID if it doesn't exist.
	 * 
	 * @param appointmentId - The unique appointment ID for the new appointment.
	 * @param date - The date for the appointment.
	 * @param description - The description for the appointment.
	 */
	public void addAppointment(String appointmentId, Date date, String description) {
		// If the hash map does not contain the given appointment ID.
		if (!appointments.containsKey(appointmentId)) {
			// Create the new appointment.
			Appointment newAppointment = new Appointment(appointmentId, date, description);
		
			// Add the new appointment to the hash map.
			appointments.put(appointmentId, newAppointment);
		}
		else {
			// Print a message to the console.
			System.out.print("Appointment already exists.");
		}
	}
	
	/**
	 * Delete a specified appointment from the hash map.
	 * 
	 * @param appointmentId - The unique appointment ID for the specified appointment.
	 */
	public void deleteAppointment(String appointmentId) {
		// If the hash map contains the given appointment ID...
		if (appointments.containsKey(appointmentId)) {
			// Delete the specified appointment from the hash map.
			appointments.remove(appointmentId);
		}
		else {
			// Print a message to the console.
			System.out.print("Appointment does not exist.");
		}
	}
	
	/**
	 * Update the specified appointment's date from the hash map.
	 * 
	 * @param appointmentId - The unique appointment ID for the specified appointment.
	 * @param date - The new date for the specified appointment.
	 */
	public void updateAppointmentDate(String appointmentId, Date date) {
		// If the appointment exists in the hash map...
		if (appointments.containsKey(appointmentId)) {
			// Update the appointment's date.
			appointments.get(appointmentId).setDate(date);
		}
		else
		{
			// Print a message to the console.
			System.out.print("Appointment does not exist.");
		}
	}
	
	/**
	 * Update the specified appointment's description from the hash map.
	 * 
	 * @param appointmentId - The unique appointment ID for the specified appointment.
	 * @param description - The new description for the specified appointment.
	 */
	public void updateAppointmentDescription(String appointmentId, String description) {
		// If the appointment exists in the hash map...
		if (appointments.containsKey(appointmentId)) {
			// Update the appointment's description.
			appointments.get(appointmentId).setDescription(description);
		}
		else
		{
			// Print a message to the console.
			System.out.print("Appointment does not exist.");
		}
	}
}
