package com.clinic.dao;

import com.clinic.dto.Appointment;
import java.util.List;

public interface AppointmentDAO {
	int scheduleAppointment(Appointment appointment);

	List<Appointment> getAppointmentsByDoctor(int doctorId);
}