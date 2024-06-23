package appointment;

import java.util.Date;

public class Appointment {
	// Appointment attributes.
	private String ID;
	private Date appointmentDate;
	private String description;
	
	// Constructor sets proper values to attributes throwing exceptions if invalid.
	public Appointment(String ID, Date appointmentDate, String description) {
		
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.ID = ID;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	// Getter methods for each attribute.
	public String getID() {
		return ID;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public String getDescription() {
		return description;
	}
}
