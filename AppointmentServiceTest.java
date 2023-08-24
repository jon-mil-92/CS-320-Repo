import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	private final PrintStream initialConsoleOutput = System.out;
	private final long TEN_SECONDS = 10000;
	private long currentTime;
	private Date newValidDate;
	
	@BeforeEach
	private void setOutputStream() {
	    System.setOut(new PrintStream(consoleOutput));
	}
	
	@BeforeEach
	private void createNewValidDate() {
		// Set the current system time epoch in milliseconds.
	    currentTime = System.currentTimeMillis();
	    
	    // Set the test date to 10 seconds passed the current time.
	    newValidDate = new Date(currentTime + TEN_SECONDS);
	}
	
	@AfterEach
	private void restoreInitialOutputStream() {
	    System.setOut(initialConsoleOutput);
	}
	
	@Test
	void testAddAppointment() {
		// Test object.
		AppointmentService appointmentService = new AppointmentService();
		
		// Try to add a valid appointment.
		appointmentService.addAppointment("1", newValidDate, "Appointment Description");

		// Verify the appointment was added.
		assertTrue(appointmentService.getAppointments().containsKey("1"));
	}
	
	@Test
	void testAddInvalidAppointment() {
		// Get the current time epoch in milliseconds and then subtract 1 to create a date in the past.
		long oldDate = System.currentTimeMillis() - 1;
		
		// Test object.
		AppointmentService appointmentService = new AppointmentService();

		// Verify an exception occurs when trying to add the invalid appointment.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Try to add an invalid appointment.
			appointmentService.addAppointment("*".repeat(11), new Date(oldDate), "*".repeat(51));
		});
	}
	
	@Test
	void testAddDuplicateAppointment() {
		// Test object.
		AppointmentService appointmentService = new AppointmentService();

		// Try to add a valid appointment.
		appointmentService.addAppointment("1", newValidDate, "Appointment Description");

		// Try to add another valid appointment with the same appointment ID.
		appointmentService.addAppointment("1", newValidDate, "Appointment Description");

		// Verify a duplicate appointment was not added.
		assertTrue(appointmentService.getAppointments().size() == 1);
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Appointment already exists."));
	}
	
	@Test
	void testDeleteAppointment() {
		// Test object.
		AppointmentService appointmentService = new AppointmentService();
	
		// Try to add a valid appointment.
		appointmentService.addAppointment("1", newValidDate, "Appointment Description");

		// Try to delete an appointment that already exists.
		appointmentService.deleteAppointment("1");

		// Verify the appointment was deleted from the appointments hash map.
		assertFalse(appointmentService.getAppointments().containsKey("1"));
	}
	
	@Test
	void testDeleteNonExistentAppointment() {
		// Test object.
		AppointmentService appointmentService = new AppointmentService();

		// Get the current appointments hash map.
		HashMap<String, Appointment> currentAppointments = appointmentService.getAppointments();

		// Try to delete an appointment that does not exist.
		appointmentService.deleteAppointment("1");

		// Verify the appointments hash map is unchanged.
		assertTrue(currentAppointments == appointmentService.getAppointments());
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Appointment does not exist."));
	}
	
	@Test
	void testUpdateAppointmentDate() {
		// Test object.
		AppointmentService appointmentService = new AppointmentService();
		
		// Create a new valid date to update the appointment with.
		Date updatedDate = new Date(System.currentTimeMillis() + TEN_SECONDS);

		// Try to add a valid appointment.
		appointmentService.addAppointment("1", newValidDate, "Appointment Description");

		// Update the date.
		appointmentService.updateAppointmentDate("1", updatedDate);

		// Verify that the date has changed.
		assertTrue(appointmentService.getAppointments().get("1").getDate().equals(updatedDate));
	}
	
	@Test
	void testUpdateNonExistentAppointmentDate() {
		// Test object.
		AppointmentService appointmentService = new AppointmentService();

		// Update the date.
		appointmentService.updateAppointmentDate("1", newValidDate);
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Appointment does not exist."));
	}
	
	@Test
	void testUpdateAppointmentDescription() {
		// Test object.
		AppointmentService appointmentService = new AppointmentService();

		// Try to add a valid appointment.
		appointmentService.addAppointment("1", newValidDate, "Appointment Description");

		// Update the description.
		appointmentService.updateAppointmentDescription("1", "New Appointment Description");

		// Verify that the description has changed.
		assertTrue(appointmentService.getAppointments().get("1").getDescription()
				.equals("New Appointment Description"));
	}
	
	@Test
	void testUpdateNonExistentAppointmentDescription() {
		// Test object.
		AppointmentService appointmentService = new AppointmentService();

		// Update the description.
		appointmentService.updateAppointmentDescription("1", "New Appointment Description");
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Appointment does not exist."));
	}
}