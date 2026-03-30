package week3.payroll_system;

public class Developer extends Employee {
	private final double cachedBonus;

	public Developer(String name, double salary) {
		super(name, salary);
		if (salary > 50000) {
			this.cachedBonus = salary * 0.05;
		} else {
			this.cachedBonus = 0.00;
		}
	}

	@Override
	public double getBonus() {
		return cachedBonus;
	}
}