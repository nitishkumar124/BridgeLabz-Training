package com.clinic.dao;

import com.clinic.config.DatabaseConnection;
import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

	@Override
	public int insertPatient(Patient patient) {
		String sql = "INSERT INTO patients (first_name, last_name, date_of_birth, gender, phone_number, email) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, patient.getFirstName());
			pstmt.setString(2, patient.getLastName());
			pstmt.setDate(3, patient.getDateOfBirth());
			pstmt.setString(4, patient.getGender());
			pstmt.setString(5, patient.getPhoneNumber());
			pstmt.setString(6, patient.getEmail());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.err.println("Error inserting patient: " + e.getMessage());
		}
		return -1;
	}

	@Override
	public Patient getPatientById(int id) {
		String sql = "SELECT * FROM patients WHERE patient_id = ?";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				return mapResultSetToPatient(rs);
		} catch (SQLException e) {
			System.err.println("Error fetching patient: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> list = new ArrayList<>();
		String sql = "SELECT * FROM patients";
		try (Connection conn = HikariConnectionPool.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				list.add(mapResultSetToPatient(rs));
			}
		} catch (SQLException e) {
			System.err.println("Error listing patients: " + e.getMessage());
		}
		return list;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		String sql = "UPDATE patients SET first_name=?, last_name=?, phone_number=?, email=? WHERE patient_id=?";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, patient.getFirstName());
			pstmt.setString(2, patient.getLastName());
			pstmt.setString(3, patient.getPhoneNumber());
			pstmt.setString(4, patient.getEmail());
			pstmt.setInt(5, patient.getPatientId());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error updating patient: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deactivatePatient(int id) {
		String sql = "UPDATE patients SET is_active = FALSE WHERE patient_id = ?";
		try (Connection conn = HikariConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error deactivating patient: " + e.getMessage());
		}
		return false;
	}

	private Patient mapResultSetToPatient(ResultSet rs) throws SQLException {
		Patient p = new Patient();
		p.setPatientId(rs.getInt("patient_id"));
		p.setFirstName(rs.getString("first_name"));
		p.setLastName(rs.getString("last_name"));
		p.setDateOfBirth(rs.getDate("date_of_birth"));
		p.setGender(rs.getString("gender"));
		p.setPhoneNumber(rs.getString("phone_number"));
		p.setEmail(rs.getString("email"));
		p.setActive(rs.getBoolean("is_active"));
		p.setRegisteredOn(rs.getTimestamp("registered_on"));
		return p;
	}
}