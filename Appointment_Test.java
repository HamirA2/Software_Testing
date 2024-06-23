package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

class Appointment_Test {

	// Test checks that appointment objects can be created with no issues.
	@Test
	void appointmentTest() {
		Appointment newAppointment1 = new Appointment("123", new Date(2025, 5, 15), "Yearly checkup");
		Appointment newAppointment2 = new Appointment("III", new Date(2027, 11, 6), "Needs update");
		
		assertTrue(newAppointment1.getID().equals("123"));
		assertTrue(newAppointment1.getAppointmentDate().equals(null) == false);
		assertTrue(newAppointment1.getDescription().equals("Yearly checkup"));
		assertTrue(newAppointment2.getID().equals("III"));
		assertTrue(newAppointment2.getAppointmentDate().equals(new Date(2027, 11, 6)));
		assertTrue(newAppointment2.getDescription().equals("Needs update"));
	}
	
	// Test verifies error messages work when values are null, string values are too long, and
	// appointment dates are in the past.
	@Test
	void appointmentExceptionsTest() {
		Date pastDate = new Date(2015 - 2010, 1, 10);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment emptyAppointment1 = new Appointment(null, new Date(), "No ID");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment emptyAppointment2 = new Appointment("ID1", null, "No date");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment emptyAppointment3 = new Appointment("ID2", new Date(), null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment longAppointment1 = new Appointment("ID name is too long", new Date(), null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment oldAppointment1 = new Appointment("RegID", pastDate, "In the past");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment longAppointment2 = new Appointment("REGID2", new Date(), "Really long description"
					+ "should be longer than 50 characters");
		});
	}

}
