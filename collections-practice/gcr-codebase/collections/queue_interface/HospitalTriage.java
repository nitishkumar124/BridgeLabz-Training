package collections.queue_interface;

import java.util.PriorityQueue;
import java.util.Collections;

class Patient implements Comparable<Patient> {
	String name;
	int severity;

	public Patient(String name, int severity) {
		this.name = name;
		this.severity = severity;
	}

	@Override
	public int compareTo(Patient other) {

		return Integer.compare(other.severity, this.severity);
	}

	@Override
	public String toString() {
		return name + " (Severity: " + severity + ")";
	}
}

public class HospitalTriage {
	public static void main(String[] args) {

		PriorityQueue<Patient> triage = new PriorityQueue<>();

		triage.add(new Patient("John", 3));
		triage.add(new Patient("Alice", 5));
		triage.add(new Patient("Bob", 2));

		System.out.println("Treating patients in order of severity:");
		while (!triage.isEmpty()) {

			System.out.println("Processing: " + triage.poll());
		}
	}
}