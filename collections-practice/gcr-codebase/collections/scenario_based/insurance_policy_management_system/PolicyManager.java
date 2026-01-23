package collections.scenario_based.insurance_policy_management_system;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class PolicyManager {
	private Set<Policy> quickLookupSet = new HashSet<>();
	private Set<Policy> insertionOrderSet = new LinkedHashSet<>();
	private Set<Policy> expirySortedSet = new TreeSet<>();

	public void addPolicy(Policy p) {
		quickLookupSet.add(p);
		insertionOrderSet.add(p);
		expirySortedSet.add(p);
	}

	public List<Policy> getExpiringSoon() {
		LocalDate today = LocalDate.now();
		LocalDate thirtyDaysLater = today.plusDays(30);

		return expirySortedSet.stream()
				.filter(p -> !p.getExpiryDate().isBefore(today) && p.getExpiryDate().isBefore(thirtyDaysLater))
				.collect(Collectors.toList());
	}

	public List<Policy> getByCoverage(String type) {
		return quickLookupSet.stream().filter(p -> p.getCoverageType().equalsIgnoreCase(type))
				.collect(Collectors.toList());
	}

	public void displayAllSets() {
		System.out.println("\n--- HashSet (Unordered) ---");
		quickLookupSet.forEach(System.out::println);

		System.out.println("\n--- LinkedHashSet (Insertion Order) ---");
		insertionOrderSet.forEach(System.out::println);

		System.out.println("\n--- TreeSet (Sorted by Expiry) ---");
		expirySortedSet.forEach(System.out::println);
	}
}