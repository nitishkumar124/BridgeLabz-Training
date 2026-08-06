package com.clinic.service;

import com.clinic.config.HikariConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentService {

    /**
     * Executes completing an appointment, creating a billing record,
     * and recording visit history inside a single ACID database transaction.
     *
     * @param appointmentId The ID of the appointment to complete
     * @param amount        The billed amount for the visit
     * @param diagnosis     Medical diagnosis recorded by doctor
     * @param prescription  Prescribed medication/treatment
     * @param notes         Additional visit notes
     * @return boolean      True if transaction commits successfully, false if rolled back
     */
    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis, String prescription, String notes) {
        String updateApptSql = "UPDATE appointments SET status = 'Completed' WHERE appointment_id = ?";
        String insertBillSql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, 'Pending')";
        String insertVisitSql = "INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes) VALUES (?, ?, ?, ?)";

        Connection conn = null;

        try {
            // 1. Obtain connection from HikariCP Pool
            conn = HikariConnectionPool.getConnection();

            // 2. Begin ACID Transaction
            conn.setAutoCommit(false);

            // Task A: Update Appointment status
            try (PreparedStatement pstmt1 = conn.prepareStatement(updateApptSql)) {
                pstmt1.setInt(1, appointmentId);
                int rowsUpdated = pstmt1.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new SQLException("Appointment ID " + appointmentId + " not found. Transaction aborted.");
                }
            }

            // Task B: Create Billing entry
            try (PreparedStatement pstmt2 = conn.prepareStatement(insertBillSql)) {
                pstmt2.setInt(1, appointmentId);
                pstmt2.setBigDecimal(2, amount);
                pstmt2.executeUpdate();
            }

            // Task C: Log Visit History
            try (PreparedStatement pstmt3 = conn.prepareStatement(insertVisitSql)) {
                pstmt3.setInt(1, appointmentId);
                pstmt3.setString(2, diagnosis);
                pstmt3.setString(3, prescription);
                pstmt3.setString(4, notes);
                pstmt3.executeUpdate();
            }

            // 3. Commit all 3 queries together
            conn.commit();
            return true;

        } catch (SQLException e) {
            System.err.println("Transaction failed! Rolling back changes. Error: " + e.getMessage());
            if (conn != null) {
                try {
                    // Roll back all changes if any single operation fails
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    // Reset auto-commit and return connection to pool
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}