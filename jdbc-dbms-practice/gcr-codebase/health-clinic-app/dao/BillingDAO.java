package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnection;

public class BillingDAO {

    public void generateBill(int visitId, double amount) throws Exception {
        String sql = "INSERT INTO bills(visit_id, total_amount, payment_status, bill_date) VALUES(?,?, 'UNPAID', CURDATE())";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, visitId);
            ps.setDouble(2, amount);
            ps.executeUpdate();
        }
    }

    public void payBill(int billId, String mode, double amount) throws Exception {
        String updateBill = "UPDATE bills SET payment_status='PAID' WHERE bill_id=?";
        String paymentSql = "INSERT INTO payment_transactions(bill_id, payment_mode, payment_date, amount) VALUES(?,?,CURDATE(),?)";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(updateBill);
            ps1.setInt(1, billId);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(paymentSql);
            ps2.setInt(1, billId);
            ps2.setString(2, mode);
            ps2.setDouble(3, amount);
            ps2.executeUpdate();

            con.commit();
        }
    }
}
