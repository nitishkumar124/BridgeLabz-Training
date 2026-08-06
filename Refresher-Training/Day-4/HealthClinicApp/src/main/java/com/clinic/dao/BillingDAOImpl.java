package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Billing;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public Billing getBillByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM billing WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapResultSetToBilling(rs);
        } catch (SQLException e) {
            System.err.println("Error fetching bill: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updatePaymentStatus(int billId, String status) {
        String sql = "UPDATE billing SET payment_status = ? WHERE bill_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, billId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating bill status: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Billing> getPendingBills() {
        List<Billing> list = new ArrayList<>();
        String sql = "SELECT * FROM billing WHERE payment_status = 'Pending'";
        try (Connection conn = HikariConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSetToBilling(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching pending bills: " + e.getMessage());
        }
        return list;
    }

    private Billing mapResultSetToBilling(ResultSet rs) throws SQLException {
        Billing b = new Billing();
        b.setBillId(rs.getInt("bill_id"));
        b.setAppointmentId(rs.getInt("appointment_id"));
        b.setAmount(rs.getBigDecimal("amount"));
        b.setPaymentStatus(rs.getString("payment_status"));
        b.setBillingDate(rs.getTimestamp("billing_date"));
        return b;
    }
}