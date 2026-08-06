package com.clinic.dao;

import com.clinic.dto.Billing;
import java.util.List;

public interface BillingDAO {
    Billing getBillByAppointmentId(int appointmentId);
    boolean updatePaymentStatus(int billId, String status);
    List<Billing> getPendingBills();
}