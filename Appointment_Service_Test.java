package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.Appointment_Service;

class Appointment_Service_Test {

	// Test that appointments can be added to an array with a unique ID. Also throws exception when
	// appointment object is being added that has the same ID as one already in array.
	@Test
	void addAppointmentTest() {
		Appointment_Service addAppointments = new Appointment_Service();
		Appointment firstAppointment = new Appointment("1000", new Date(), "Needs flu shot");
		Appointment secondAppointment = new Appointment("1111", new Date(), "Will have surgery");
		
		assertTrue(addAppointments.addAppointment(firstAppointment).contains(firstAppointment));
		assertTrue(addAppointments.addAppointment(secondAppointment).contains(secondAppointment));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			addAppointments.addAppointment(secondAppointment);
		});
	}
	// Test checks on the delete method deleting appointments per ID.
	@Test
	void deleteAppointmentTest() {
		Appointment_Service removeAppointments = new Appointment_Service();
		Appointment removeAppointment1 = new Appointment("HAM", new Date(), "Regular checkup");
		Appointment removeAppointment2 = new Appointment("JAM", new Date(), "Teeth cleaning");
		Appointment removeAppointment3 = new Appointment("WAM", new Date(), "Loan session");
		
		removeAppointments.addAppointment(removeAppointment1);
		removeAppointments.addAppointment(removeAppointment2);
		removeAppointments.addAppointment(removeAppointment3);
		
		assertTrue(removeAppointments.deleteAppointment(removeAppointment2).indexOf(removeAppointment2) == -1);
		assertTrue(removeAppointments.deleteAppointment(removeAppointment1).indexOf(removeAppointment3) == 0);
	}

}
