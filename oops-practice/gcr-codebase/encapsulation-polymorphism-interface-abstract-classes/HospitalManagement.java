package level1;

import java.util.*;

public class HospitalManagement {
	public static void main(String[] args) {
		Patient[] ward = { new InPatient("P001", "John Doe", 45, 4), new OutPatient("P002", "Jane Smith", 29),
				new InPatient("P003", "Robert Brown", 60, 2) };

		System.out.println("--- Hospital Billing Summary ---");
		for (Patient p : ward) {
			p.getPatientDetails();
			System.out.printf("Total Bill: $%.2f%n", p.calculateBill());
			System.out.println("---------------------------------");
		}
	}
}

interface MedicalRecord {
	void addRecord(String record);

	void viewRecords();
}

abstract class Patient {
	private String patientId;
	private String name;
	private int age;
	private String diagnosis;
	protected List<String> history;

	public Patient(String patientId, String name, int age) {
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.history = new ArrayList<>();
	}

	public void getPatientDetails() {
		System.out.println("ID: " + patientId + " | Name: " + name + " | Age: " + age);
	}

	public abstract double calculateBill();

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getName() {
		return name;
	}
}

class InPatient extends Patient implements MedicalRecord {
	private int daysStayed;
	private double dailyRate = 500.00;

	public InPatient(String id, String name, int age, int days) {
		super(id, name, age);
		this.daysStayed = days;
	}

	@Override
	public double calculateBill() {
		return daysStayed * dailyRate;
	}

	@Override
	public void addRecord(String record) {
		history.add(record);
	}

	@Override
	public void viewRecords() {
		System.out.println("Medical History for " + getName() + ": " + history);
	}
}

class OutPatient extends Patient {
	private double consultationFee = 150.00;

	public OutPatient(String id, String name, int age) {
		super(id, name, age);
	}

	@Override
	public double calculateBill() {
		return consultationFee;
	}
}
