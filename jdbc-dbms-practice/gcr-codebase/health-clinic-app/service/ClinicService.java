package service;

import java.sql.Date;
import java.sql.Time;

import dao.AppointmentDAO;
import dao.BillingDAO;
import dao.DoctorDAO;
import dao.PatientDAO;
import dao.VisitDAO;

public class ClinicService {

	private PatientDAO patientDAO = new PatientDAO();
	private DoctorDAO doctorDAO = new DoctorDAO();
	private AppointmentDAO appointmentDAO = new AppointmentDAO();
	private VisitDAO visitDAO = new VisitDAO();
	private BillingDAO billingDAO = new BillingDAO();

	// UC-1.1 Register Patient
	public void registerPatient(String name, Date dob, String phone, String email, String address, String bloodGroup)
			throws Exception {
		patientDAO.registerPatient(name, dob, phone, email, address, bloodGroup);
	}

	// UC-1.3 Search Patient
	public void searchPatient(String name) throws Exception {
		patientDAO.searchPatientByName(name);
	}

	// UC-2.1 Add Doctor
	public void addDoctor(String name, String contact, double fee, int specialtyId) throws Exception {
		doctorDAO.addDoctor(name, contact, fee, specialtyId);
	}

	// UC-3.1 Book Appointment
	public void bookAppointment(int patientId, int doctorId, Date date, Time time) throws Exception {
		appointmentDAO.bookAppointment(patientId, doctorId, date, time);
	}

	// UC-4.1 Record Visit
	public void recordVisit(int appointmentId, int patientId, int doctorId, String diagnosis, String notes)
			throws Exception {
		visitDAO.recordVisit(appointmentId, patientId, doctorId, diagnosis, notes);
	}

	// UC-5.1 Generate Bill
	public void generateBill(int visitId, double amount) throws Exception {
		billingDAO.generateBill(visitId, amount);
	}

	// UC-5.2 Pay Bill
	public void payBill(int billId, String mode, double amount) throws Exception {
		billingDAO.payBill(billId, mode, amount);
	}
}
