package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnection;

public class VisitDAO {

	public void recordVisit(int appointmentId, int patientId, int doctorId, String diagnosis, String notes)
			throws Exception {

		String visitSql = "INSERT INTO visits(appointment_id, patient_id, doctor_id, diagnosis, notes, visit_date) VALUES(?,?,?,?,?,CURDATE())";
		String updateApp = "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";

		try (Connection con = DBConnection.getConnection()) {
			con.setAutoCommit(false);

			PreparedStatement ps1 = con.prepareStatement(visitSql);
			ps1.setInt(1, appointmentId);
			ps1.setInt(2, patientId);
			ps1.setInt(3, doctorId);
			ps1.setString(4, diagnosis);
			ps1.setString(5, notes);
			ps1.executeUpdate();

			PreparedStatement ps2 = con.prepareStatement(updateApp);
			ps2.setInt(1, appointmentId);
			ps2.executeUpdate();

			con.commit();
		}
	}
}
