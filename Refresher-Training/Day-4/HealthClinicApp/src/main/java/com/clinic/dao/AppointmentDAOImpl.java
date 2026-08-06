package com.clinic.dao;

import com.clinic.config.DatabaseConnection;
import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Appointment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

	@Override
	public int scheduleAppointment(Appointment appointment) {
		String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, 'Scheduled')";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setInt(1, appointment.getPatientId());
			pstmt.setInt(2, appointment.getDoctorId());
			pstmt.setTimestamp(3, appointment.getAppointmentDate());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.err.println("Error scheduling appointment: " + e.getMessage());
		}
		return -1;
	}

	@Override
	public List<Appointment> getAppointmentsByDoctor(int doctorId) {
		List<Appointment> list = new ArrayList<>();
		String sql = "SELECT * FROM appointments WHERE doctor_id = ? ORDER BY appointment_date ASC";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, doctorId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Appointment appt = new Appointment();
				appt.setAppointmentId(rs.getInt("appointment_id"));
				appt.setPatientId(rs.getInt("patient_id"));
				appt.setDoctorId(rs.getInt("doctor_id"));
				appt.setAppointmentDate(rs.getTimestamp("appointment_date"));
				appt.setStatus(rs.getString("status"));
				list.add(appt);
			}
		} catch (SQLException e) {
			System.err.println("Error fetching schedule: " + e.getMessage());
		}
		return list;
	}
}