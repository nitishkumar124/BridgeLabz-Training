package com.clinic.dao;

import com.clinic.dto.VisitHistory;
import java.util.List;

public interface VisitHistoryDAO {
    VisitHistory getVisitByAppointmentId(int appointmentId);
    List<VisitHistory> getPatientMedicalHistory(int patientId);
}