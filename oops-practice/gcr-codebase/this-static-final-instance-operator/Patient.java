package level1;

import java.util.*;

public class Patient {

	static String hospitalName = "GLA Medical Institute and Hospital";
	static int totalPatients = 0;

	final int patientID;
	String name;
	int age;
	String ailment;

	Patient(int patientID, String name, int age, String ailment) {
		totalPatients++;
		this.patientID = patientID;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
	}

	static void getTotalPatients() {
		System.out.println("Total Patients Admitted: " + totalPatients + '\n');
	}

	void displayPatientDetails() {
		System.out.println("Hospital Name: " + hospitalName);
		System.out.println("Patient ID: " + patientID);
		System.out.println("Name: " + name);
		System.out.println("Ailment: " + ailment + '\n');
	}

	public static void main(String[] args) {
		Patient p1 = new Patient(01, "John", 23, "Flu");
		Patient p2 = new Patient(01, "Dave", 23, "Fracture");
		
		Patient.getTotalPatients();
		
		if (p1 instanceof Patient) p1.displayPatientDetails();
		if (p2 instanceof Patient) p2.displayPatientDetails();

	}
}
