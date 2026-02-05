package stream_api;

import java.util.*;
import java.util.stream.*;

public class DoctorFinder {

	// Main method
	public static void main(String[] args) {

		List<Doctor> doctors = Arrays.asList(new Doctor("Dr. Anil", "Cardiology", true),
				new Doctor("Dr. Meera", "Dermatology", false), new Doctor("Dr. Raj", "Orthopedics", true),
				new Doctor("Dr. Neha", "Cardiology", true), new Doctor("Dr. Vikram", "Neurology", false));

		// Filter doctors available on weekends and sort by specialty
		doctors.stream().filter(Doctor::isAvailableOnWeekend).sorted(Comparator.comparing(Doctor::getSpecialty))
				.forEach(System.out::println);
	}
}

class Doctor {
	private String name;
	private String specialty;
	private boolean availableOnWeekend;

	public Doctor(String name, String specialty, boolean availableOnWeekend) {
		this.name = name;
		this.specialty = specialty;
		this.availableOnWeekend = availableOnWeekend;
	}

	public String getName() {
		return name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public boolean isAvailableOnWeekend() {
		return availableOnWeekend;
	}

	@Override
	public String toString() {
		return name + " - " + specialty;
	}
}