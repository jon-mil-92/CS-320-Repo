import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	private final long TEN_SECONDS = 10000;
	private long currentTime;
	private Date newValidDate;
	
	@BeforeEach
	private void createNewValidDate() {
		// Set the current system time epoch in milliseconds.
	    currentTime = System.currentTimeMillis();
	    
	    // Set the test date to 10 seconds passed the current time.
	    newValidDate = new Date(currentTime + TEN_SECONDS);
	}
	
	@Test
	void testGetAppointmentId() {
		// Test object.
		Appointment appointment = new Appointment("1", newValidDate, "Appointment Description");
		
		// Verify the appointment's appointment ID.
		assertTrue(appointment.getAppointmentId().equals("1"));
	}
	
	@Test
	void testGetDate() {
		// Test object.
		Appointment appointment = new Appointment("1", newValidDate, "Appointment Description");
		
		// Verify the appointment's date.
		assertTrue(appointment.getDate().equals(newValidDate));
	}
	
	@Test
	void testGetDescription() {
		// Test object.
		Appointment appointment = new Appointment("1", newValidDate, "Appointment Description");
		
		// Verify the appointment's description.
		assertTrue(appointment.getDescription().equals("Appointment Description"));
	}
	
	@Test
	void testSetDate() {
		// Create a new valid date for the appointment.
		Date updatedDate = new Date(System.currentTimeMillis() + (TEN_SECONDS * 2));
		
		// Test object.
		Appointment appointment = new Appointment("1", newValidDate, "Appointment Description");
		
		// Try to set the date.
		appointment.setDate(updatedDate);
		
		// Verify the new appointment date was set.
		assertTrue(appointment.getDate().equals(updatedDate));;
	}
	
	@Test
	void testSetDescription() {
		// Test object.
		Appointment appointment = new Appointment("1", newValidDate, "Appointment Description");
		
		// Try to set the description.
		appointment.setDescription("New Appointment Description");
		
		// Verify the new description was set.
		assertTrue(appointment.getDescription().equals("New Appointment Description"));
	}
	
	@Test
	void testTooLongAppointmentId() {
		// Verify an exception was thrown for too long appointment ID.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("*".repeat(11), newValidDate, "Appointment Description");
		});
	}
	
	@Test
	void testNullAppointmentId() {
		// Verify an exception was thrown for null appointment ID.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, newValidDate, "Appointment Description");
		});
	}
	
	@Test
	void testOldDate() {
		// Get the current time epoch in milliseconds and then subtract 1 to create a date in the past.
		long oldDate = System.currentTimeMillis() - 1;
		
		// Verify an exception was thrown for a date that is old.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", new Date(oldDate), "Appointment Description");
		});
	}
	
	@Test
	void testNullDate() {
		// Verify an exception was thrown for null date.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", null, "Appointment Description");
		});
	}
	
	@Test
	void testTooLongDescription() {
		// Verify an exception was thrown for too long description.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", newValidDate, "*".repeat(51));
		});
	}
	
	@Test
	void testNullDescription() {
		// Verify an exception was thrown for null description.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", newValidDate, null);
		});
	}
}