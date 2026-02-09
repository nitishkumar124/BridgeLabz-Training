package dao;

import java.sql.*;
import db.DBConnection;

public class PatientDAO {

	public void registerPatient(String name, Date dob, String phone, String email, String address, String bloodGroup)
			throws Exception {

		String sql = "INSERT INTO patients(name, dob, phone, email, address, blood_group) VALUES(?,?,?,?,?,?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, name);
			ps.setDate(2, dob);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, address);
			ps.setString(6, bloodGroup);

			ps.executeUpdate();
		}
	}

	public void searchPatientByName(String name) throws Exception {
		String sql = "SELECT * FROM patients WHERE name LIKE ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("patient_id") + " " + rs.getString("name"));
			}
		}
	}
}
