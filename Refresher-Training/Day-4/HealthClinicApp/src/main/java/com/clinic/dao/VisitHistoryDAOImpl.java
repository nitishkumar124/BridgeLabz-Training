package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.VisitHistory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public VisitHistory getVisitByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM visit_history WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapResultSetToVisit(rs);
        } catch (SQLException e) {
            System.err.println("Error fetching visit history: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<VisitHistory> getPatientMedicalHistory(int patientId) {
        List<VisitHistory> list = new ArrayList<>();
        String sql = "SELECT v.* FROM visit_history v " +
                     "JOIN appointments a ON v.appointment_id = a.appointment_id " +
                     "WHERE a.patient_id = ? ORDER BY a.appointment_date DESC";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, patientId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToVisit(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching patient history: " + e.getMessage());
        }
        return list;
    }

    private VisitHistory mapResultSetToVisit(ResultSet rs) throws SQLException {
        VisitHistory v = new VisitHistory();
        v.setVisitId(rs.getInt("visit_id"));
        v.setAppointmentId(rs.getInt("appointment_id"));
        v.setDiagnosis(rs.getString("diagnosis"));
        v.setPrescription(rs.getString("prescription"));
        v.setVisitNotes(rs.getString("visit_notes"));
        return v;
    }
}