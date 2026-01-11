package week2;

public class HospitalPatientManagementSystem {

	public static void main(String[] args) {
		Doctor d1 = new Doctor("Ajay Singhaniya", "Nuero Surgeon");
		Doctor d2 = new Doctor("Siddharth Anand", "Cardiology");

		Patient p1 = new InPatient("Atul Patel", 101, 150, 5);
		Patient p2 = new OutPatient("Shivam Sharma", 102, 250);

		Bill.generateBill(p1, d1);
		Bill.generateBill(p2, d2);

	}
}

abstract class Patient {
	String patientName;
	int patientID;

	Patient(String patientName, int patientID) {
		this.patientName = patientName;
		this.patientID = patientID;
	}

	public abstract void displayInfo();
}

class InPatient extends Patient implements IPayable {
	private double roomCharges;
	private int days;

	InPatient(String patientName, int patientID, double roomCharges, int days) {
		super(patientName, patientID);
		this.roomCharges = roomCharges;
		this.days = days;
	}

	@Override
	public double calculateBill() {
		return roomCharges * days;
	}

	@Override
	public void displayInfo() {
		System.out.println("[In-Patient] ID: " + patientID + ", Name: " + patientName + ", Stay: " + days + " days");
	}
}

class OutPatient extends Patient implements IPayable {

	double consultationFee;

	OutPatient(String patientName, int patientID, double consulatationFee) {
		super(patientName, patientID);
		this.consultationFee = consulatationFee;
	}

	@Override
	public double calculateBill() {
		return consultationFee;
	}

	@Override
	public void displayInfo() {
		System.out.println("[Out-Patient] ID: " + patientID + ", Name: " + patientName);
	}
}

class Doctor {
	private String doctorName;
	private String speciality;

	Doctor(String doctorName, String speciality) {
		this.doctorName = doctorName;
		this.speciality = speciality;
	}

	public void displayInfo() {
		System.out.println("Name: " + doctorName + ", (Speciality: " + speciality + ")");
	}
}

interface IPayable {
	double calculateBill();
}

class Bill {
	public static void generateBill(Patient p, Doctor d) {
		System.out.println("----- Hospital Bill -----");
		p.displayInfo();
		d.displayInfo();

		if (p instanceof Patient) {
			double billAmount = ((IPayable) p).calculateBill();
			System.out.println("Total Amount: $" + billAmount);
		}

		System.out.println("-------------------------");
	}
}