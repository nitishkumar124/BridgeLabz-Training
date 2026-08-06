package com.clinic.ui;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();

    public void start() {
        while (true) {
            System.out.println("\n=== HEALTH CLINIC MANAGEMENT SYSTEM ===");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor & Specialization Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing & Payment Management");
            System.out.println("5. Patient Medical History");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    patientMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    appointmentMenu();
                    break;
                case 4:
                    billingMenu();
                    break;
                case 5:
                    medicalHistoryMenu();
                    break;
                case 6:
                    System.out.println("Exiting application. Closing pool...");
                    HikariConnectionPool.closePool();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private void patientMenu() {
        System.out.println("\n--- Patient Operations ---");
        System.out.println("1. Register Patient");
        System.out.println("2. View Patient by ID");
        System.out.println("3. List All Patients");
        System.out.println("4. Update Patient Info");
        System.out.println("5. Deactivate Patient");
        System.out.print("Choice: ");

        int choice = readInt();
        switch (choice) {
            case 1:
                System.out.print("First Name: "); String fn = scanner.nextLine();
                System.out.print("Last Name: "); String ln = scanner.nextLine();
                System.out.print("DOB (YYYY-MM-DD): "); Date dob = Date.valueOf(scanner.nextLine());
                System.out.print("Gender (Male/Female/Other): "); String gender = scanner.nextLine();
                System.out.print("Phone: "); String phone = scanner.nextLine();
                System.out.print("Email: "); String email = scanner.nextLine();
                int id = patientDAO.insertPatient(new Patient(fn, ln, dob, gender, phone, email));
                System.out.println(id > 0 ? "Registered with ID: " + id : "Registration failed.");
                break;
            case 2:
                System.out.print("Enter Patient ID: ");
                Patient p = patientDAO.getPatientById(readInt());
                System.out.println(p != null ? p : "Patient not found.");
                break;
            case 3:
                List<Patient> patients = patientDAO.getAllPatients();
                for (Patient patient : patients) {
                    System.out.println(patient);
                }
                break;
            case 4:
                System.out.print("Patient ID to update: "); int updateId = readInt();
                Patient patientToUpdate = patientDAO.getPatientById(updateId);
                if (patientToUpdate != null) {
                    System.out.print("New First Name: "); patientToUpdate.setFirstName(scanner.nextLine());
                    System.out.print("New Last Name: "); patientToUpdate.setLastName(scanner.nextLine());
                    System.out.print("New Phone: "); patientToUpdate.setPhoneNumber(scanner.nextLine());
                    System.out.print("New Email: "); patientToUpdate.setEmail(scanner.nextLine());
                    System.out.println(patientDAO.updatePatient(patientToUpdate) ? "Updated successfully." : "Update failed.");
                } else {
                    System.out.println("Patient not found.");
                }
                break;
            case 5:
                System.out.print("Patient ID to deactivate: ");
                System.out.println(patientDAO.deactivatePatient(readInt()) ? "Deactivated." : "Operation failed.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void doctorMenu() {
        System.out.println("\n--- Doctor & Specialization Operations ---");
        System.out.println("1. Add Specialization");
        System.out.println("2. List All Specializations");
        System.out.println("3. Add Doctor");
        System.out.println("4. Link Specialization to Doctor");
        System.out.println("5. Fetch Doctors by Specialization ID");
        System.out.println("6. List All Doctors");
        System.out.print("Choice: ");

        int choice = readInt();
        switch (choice) {
            case 1:
                System.out.print("Specialization Name: "); String specName = scanner.nextLine();
                System.out.print("Description: "); String desc = scanner.nextLine();
                int specId = specializationDAO.insertSpecialization(new Specialization(specName, desc));
                System.out.println(specId > 0 ? "Specialization created with ID: " + specId : "Failed.");
                break;
            case 2:
                List<Specialization> specs = specializationDAO.getAllSpecializations();
                for (Specialization s : specs) {
                    System.out.println(s);
                }
                break;
            case 3:
                System.out.print("First Name: "); String fn = scanner.nextLine();
                System.out.print("Last Name: "); String ln = scanner.nextLine();
                System.out.print("Phone: "); String phone = scanner.nextLine();
                System.out.print("Email: "); String email = scanner.nextLine();
                int id = doctorDAO.insertDoctor(new Doctor(fn, ln, phone, email));
                System.out.println(id > 0 ? "Doctor added with ID: " + id : "Operation failed.");
                break;
            case 4:
                System.out.print("Doctor ID: "); int docId = readInt();
                System.out.print("Specialization ID: "); int sId = readInt();
                System.out.println(doctorDAO.linkSpecialization(docId, sId) ? "Linked successfully." : "Link failed.");
                break;
            case 5:
                System.out.print("Specialization ID: ");
                List<Doctor> docs = doctorDAO.getDoctorsBySpecialization(readInt());
                for (Doctor doc : docs) {
                    System.out.println(doc);
                }
                break;
            case 6:
                List<Doctor> allDoctors = doctorDAO.getAllDoctors();
                for (Doctor doc : allDoctors) {
                    System.out.println(doc);
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void appointmentMenu() {
        System.out.println("\n--- Appointment Operations ---");
        System.out.println("1. Schedule Appointment");
        System.out.println("2. View Schedule by Doctor");
        System.out.println("3. Complete Appointment (Transaction)");
        System.out.print("Choice: ");

        int choice = readInt();
        switch (choice) {
            case 1:
                System.out.print("Patient ID: "); int pid = readInt();
                System.out.print("Doctor ID: "); int did = readInt();
                System.out.print("Date & Time (YYYY-MM-DD HH:MM:SS): ");
                Timestamp ts = Timestamp.valueOf(scanner.nextLine());
                int id = appointmentDAO.scheduleAppointment(new Appointment(pid, did, ts));
                System.out.println(id > 0 ? "Scheduled with ID: " + id : "Scheduling failed.");
                break;
            case 2:
                System.out.print("Doctor ID: ");
                List<Appointment> appts = appointmentDAO.getAppointmentsByDoctor(readInt());
                for (Appointment appt : appts) {
                    System.out.println(appt);
                }
                break;
            case 3:
                System.out.print("Appointment ID: "); int apptId = readInt();
                System.out.print("Billing Amount: "); BigDecimal amount = new BigDecimal(scanner.nextLine());
                System.out.print("Diagnosis: "); String diag = scanner.nextLine();
                System.out.print("Prescription: "); String rx = scanner.nextLine();
                System.out.print("Visit Notes: "); String notes = scanner.nextLine();
                
                boolean ok = appointmentService.completeAppointment(apptId, amount, diag, rx, notes);
                System.out.println(ok ? "Appointment completed and billed!" : "Transaction failed.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void billingMenu() {
        System.out.println("\n--- Billing Operations ---");
        System.out.println("1. View Pending Bills");
        System.out.println("2. Process Payment");
        System.out.print("Choice: ");

        int choice = readInt();
        switch (choice) {
            case 1:
                List<Billing> pending = billingDAO.getPendingBills();
                for (Billing b : pending) {
                    System.out.println(b);
                }
                break;
            case 2:
                System.out.print("Enter Bill ID: "); int billId = readInt();
                System.out.print("Status (Paid/Refunded): "); String status = scanner.nextLine();
                boolean updated = billingDAO.updatePaymentStatus(billId, status);
                System.out.println(updated ? "Payment updated." : "Update failed.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void medicalHistoryMenu() {
        System.out.println("\n--- Medical History Operations ---");
        System.out.print("Enter Patient ID: "); int pid = readInt();
        List<VisitHistory> history = visitHistoryDAO.getPatientMedicalHistory(pid);
        if (history.isEmpty()) {
            System.out.println("No past medical records found for this patient.");
        } else {
            for (VisitHistory v : history) {
                System.out.println(v);
            }
        }
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Enter a valid number: ");
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        return val;
    }
}