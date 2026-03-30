package level1;

public class Employee {

	public int employeeID;
	protected String department;
	private double salary;

	Employee(int employeeID, String department, double salary) {
		this.employeeID = employeeID;
		this.department = department;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
		System.out.println("Balance salary: " + this.salary);
	}

	public static void main(String[] args) {
		Manager m = new Manager(1245, "Management", 145654, 50000);
		m.displayManagerInfo();
	}
}

class Manager extends Employee {
    private double bonus;

    public Manager(int employeeID, String department, double salary, double bonus) {
        super(employeeID, department, salary);
        this.bonus = bonus;
    }

    public void displayManagerInfo() {
        System.out.println("Manager ID: " + employeeID);
        System.out.println("Department: " + department);
        
        System.out.println("Base Salary: $" + getSalary());
        System.out.println("Bonus: $" + bonus);
    }
}
