package appointment;

import java.util.ArrayList;

import appointment.Appointment;

public class Appointment_Service {
	// Array for storing appointments
	ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	// Adds appointments as long as the ID is unique. Throws exception if ID is already in array.
	public ArrayList<Appointment> addAppointment(Appointment newAppointment) {
		
		if (appointmentList.isEmpty()) {
			appointmentList.add(newAppointment);
		}
		else {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (appointmentList.get(i).getID().equals(newAppointment.getID())) {
					throw new IllegalArgumentException("ID already added");
				}
			}
			appointmentList.add(newAppointment);
		}
		
		return appointmentList;
	}
	
	// Deletes appointments if the ID value in array matches the ID of the deleteApp parameter.
	public ArrayList<Appointment> deleteAppointment(Appointment deleteApp) {
		
		for (int j = 0; j < appointmentList.size(); j++) {
			if (appointmentList.get(j).getID().equals(deleteApp.getID())) {
				appointmentList.remove(j);
				break;
			}
		}
		
		return appointmentList;
	}
}
