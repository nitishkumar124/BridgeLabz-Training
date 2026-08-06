package com.clinic.dao;

import com.clinic.config.DatabaseConnection;
import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

	@Override
	public int insertDoctor(Doctor doctor) {
		String sql = "INSERT INTO doctors (first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?)";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, doctor.getFirstName());
			pstmt.setString(2, doctor.getLastName());
			pstmt.setString(3, doctor.getPhoneNumber());
			pstmt.setString(4, doctor.getEmail());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.err.println("Error inserting doctor: " + e.getMessage());
		}
		return -1;
	}

	@Override
	public boolean linkSpecialization(int doctorId, int specializationId) {
		String sql = "INSERT INTO doctor_specializations (doctor_id, specialization_id) VALUES (?, ?)";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, doctorId);
			pstmt.setInt(2, specializationId);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error linking specialization: " + e.getMessage());
		}
		return false;
	}

	@Override
	public List<Doctor> getDoctorsBySpecialization(int specializationId) {
		List<Doctor> list = new ArrayList<>();
		String sql = "SELECT d.* FROM doctors d " + "JOIN doctor_specializations ds ON d.doctor_id = ds.doctor_id "
				+ "WHERE ds.specialization_id = ? AND d.is_active = TRUE";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, specializationId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(mapResultSetToDoctor(rs));
			}
		} catch (SQLException e) {
			System.err.println("Error fetching doctors by specialization: " + e.getMessage());
		}
		return list;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> list = new ArrayList<>();
		String sql = "SELECT * FROM doctors WHERE is_active = TRUE";
		try (Connection conn = HikariConnectionPool.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				list.add(mapResultSetToDoctor(rs));
			}
		} catch (SQLException e) {
			System.err.println("Error fetching doctors: " + e.getMessage());
		}
		return list;
	}

	private Doctor mapResultSetToDoctor(ResultSet rs) throws SQLException {
		Doctor d = new Doctor();
		d.setDoctorId(rs.getInt("doctor_id"));
		d.setFirstName(rs.getString("first_name"));
		d.setLastName(rs.getString("last_name"));
		d.setPhoneNumber(rs.getString("phone_number"));
		d.setEmail(rs.getString("email"));
		d.setActive(rs.getBoolean("is_active"));
		return d;
	}
}