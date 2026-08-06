package com.clinic.dao;

import com.clinic.dto.Doctor;
import java.util.List;

public interface DoctorDAO {
	int insertDoctor(Doctor doctor);

	boolean linkSpecialization(int doctorId, int specializationId);

	List<Doctor> getDoctorsBySpecialization(int specializationId);

	List<Doctor> getAllDoctors();
}