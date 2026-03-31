package collections.scenario_based.insurance_policy_management_system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Policy implements Comparable<Policy> {
	private String policyNumber;
	private String policyholderName;
	private LocalDate expiryDate;
	private String coverageType;
	private double premiumAmount;

	public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType,
			double premiumAmount) {
		this.policyNumber = policyNumber;
		this.policyholderName = policyholderName;
		this.expiryDate = expiryDate;
		this.coverageType = coverageType;
		this.premiumAmount = premiumAmount;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public String getCoverageType() {
		return coverageType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Policy policy = (Policy) o;
		return Objects.equals(policyNumber, policy.policyNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(policyNumber);
	}

	@Override
	public int compareTo(Policy other) {
		int dateCompare = this.expiryDate.compareTo(other.expiryDate);
		if (dateCompare == 0) {
			return this.policyNumber.compareTo(other.policyNumber);
		}
		return dateCompare;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s | Exp: %s | Type: %s | $%.2f", policyNumber, policyholderName, expiryDate,
				coverageType, premiumAmount);
	}
}