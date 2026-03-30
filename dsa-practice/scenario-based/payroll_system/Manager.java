package week3.payroll_system;

public class Manager extends Employee {
	private final double cachedBonus;

	public Manager(String name, double salary) {
		super(name, salary);
		this.cachedBonus = salary * 0.10;
	}

	@Override
	public double getBonus() {
		return cachedBonus;
	}
}