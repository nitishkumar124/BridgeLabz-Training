package app;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import service.ClinicService;

public class ClinicApp {

    private static ClinicService service = new ClinicService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== HEALTH CLINIC MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Add Doctor");
            System.out.println("4. Book Appointment");
            System.out.println("5. Record Visit");
            System.out.println("6. Generate Bill");
            System.out.println("7. Pay Bill");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {

                    case 1 -> registerPatientUI(sc);
                    case 2 -> searchPatientUI(sc);
                    case 3 -> addDoctorUI(sc);
                    case 4 -> bookAppointmentUI(sc);
                    case 5 -> recordVisitUI(sc);
                    case 6 -> generateBillUI(sc);
                    case 7 -> payBillUI(sc);

                    case 0 -> {
                        System.out.println("Exiting system... Goodbye!");
                        System.exit(0);
                    }

                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }

    private static void registerPatientUI(Scanner sc) throws Exception {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("DOB (yyyy-mm-dd): ");
        Date dob = Date.valueOf(sc.nextLine());

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("Blood Group: ");
        String bg = sc.nextLine();

        service.registerPatient(name, dob, phone, email, address, bg);
        System.out.println("✅ Patient registered successfully.");
    }

    private static void searchPatientUI(Scanner sc) throws Exception {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        service.searchPatient(name);
    }

    private static void addDoctorUI(Scanner sc) throws Exception {
        System.out.print("Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        System.out.print("Consultation Fee: ");
        double fee = sc.nextDouble();

        System.out.print("Specialty ID: ");
        int specId = sc.nextInt();

        service.addDoctor(name, contact, fee, specId);
        System.out.println("✅ Doctor added successfully.");
    }

    private static void bookAppointmentUI(Scanner sc) throws Exception {
        System.out.print("Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Doctor ID: ");
        int did = sc.nextInt();

        sc.nextLine();
        System.out.print("Date (yyyy-mm-dd): ");
        Date date = Date.valueOf(sc.nextLine());

        System.out.print("Time (HH:mm:ss): ");
        Time time = Time.valueOf(sc.nextLine());

        service.bookAppointment(pid, did, date, time);
        System.out.println("✅ Appointment booked.");
    }

    private static void recordVisitUI(Scanner sc) throws Exception {
        System.out.print("Appointment ID: ");
        int appId = sc.nextInt();

        System.out.print("Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Doctor ID: ");
        int did = sc.nextInt();

        sc.nextLine();
        System.out.print("Diagnosis: ");
        String diagnosis = sc.nextLine();

        System.out.print("Notes: ");
        String notes = sc.nextLine();

        service.recordVisit(appId, pid, did, diagnosis, notes);
        System.out.println("✅ Visit recorded.");
    }

    private static void generateBillUI(Scanner sc) throws Exception {
        System.out.print("Visit ID: ");
        int visitId = sc.nextInt();

        System.out.print("Total Amount: ");
        double amount = sc.nextDouble();

        service.generateBill(visitId, amount);
        System.out.println("✅ Bill generated.");
    }

    private static void payBillUI(Scanner sc) throws Exception {
        System.out.print("Bill ID: ");
        int billId = sc.nextInt();

        sc.nextLine();
        System.out.print("Payment Mode (CASH/CARD/UPI): ");
        String mode = sc.nextLine();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        service.payBill(billId, mode, amount);
        System.out.println("✅ Payment successful.");
    }
}
