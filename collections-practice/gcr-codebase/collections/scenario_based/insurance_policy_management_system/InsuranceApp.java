package collections.scenario_based.insurance_policy_management_system;

import java.time.LocalDate;
import java.util.*;

public class InsuranceApp {
	public static void main(String[] args) {
		PolicyManager manager = new PolicyManager();

		manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500));
		manager.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(45), "Auto", 300));
		manager.addPolicy(new Policy("P003", "Charlie", LocalDate.now().plusDays(5), "Home", 1200));
		manager.addPolicy(new Policy("P004", "Alice", LocalDate.now().plusDays(15), "Health", 500)); // Duplicate ID?
																										// No, different
																										// ID

		manager.displayAllSets();

		System.out.println("\nExpiring in < 30 days: " + manager.getExpiringSoon());
		System.out.println("Health Policies: " + manager.getByCoverage("Health"));

		comparePerformance();
	}

	public static void comparePerformance() {
		int count = 100000;
		List<Policy> testData = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			testData.add(new Policy("ID" + i, "Name", LocalDate.now(), "Type", 100));
		}

		System.out.println("\n--- Performance Comparison (100k elements) ---");
		testSetPerformance(new HashSet<>(), "HashSet", testData);
		testSetPerformance(new LinkedHashSet<>(), "LinkedHashSet", testData);
		testSetPerformance(new TreeSet<>(), "TreeSet", testData);
	}

	private static void testSetPerformance(Set<Policy> set, String name, List<Policy> data) {
		long start = System.currentTimeMillis();
		for (Policy p : data)
			set.add(p);
		long end = System.currentTimeMillis();
		System.out.println(name + " Add Time: " + (end - start) + "ms");
	}
}