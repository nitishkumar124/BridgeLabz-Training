package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import db.DBConnection;

public class AppointmentDAO {

	public void bookAppointment(int patientId, int doctorId, Date date, Time time) throws Exception {

		String checkSql = "SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND appointment_date=? AND appointment_time=?";
		String insertSql = "INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time, status) VALUES(?,?,?,?,?)";

		try (Connection con = DBConnection.getConnection()) {
			con.setAutoCommit(false);

			PreparedStatement check = con.prepareStatement(checkSql);
			check.setInt(1, doctorId);
			check.setDate(2, date);
			check.setTime(3, time);

			ResultSet rs = check.executeQuery();
			rs.next();

			if (rs.getInt(1) > 0) {
				con.rollback();
				throw new Exception("Doctor not available at this time");
			}

			PreparedStatement insert = con.prepareStatement(insertSql);
			insert.setInt(1, patientId);
			insert.setInt(2, doctorId);
			insert.setDate(3, date);
			insert.setTime(4, time);
			insert.setString(5, "SCHEDULED");

			insert.executeUpdate();
			con.commit();
		}
	}
}
