package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnection;

public class DoctorDAO {

	public void addDoctor(String name, String contact, double fee, int specialtyId) throws Exception {
		String sql = "INSERT INTO doctors(name, contact, consultation_fee, specialty_id) VALUES(?,?,?,?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, name);
			ps.setString(2, contact);
			ps.setDouble(3, fee);
			ps.setInt(4, specialtyId);
			ps.executeUpdate();
		}
	}

	public void deactivateDoctor(int doctorId) throws Exception {
		String sql = "UPDATE doctors SET is_active=false WHERE doctor_id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, doctorId);
			ps.executeUpdate();
		}
	}
}
