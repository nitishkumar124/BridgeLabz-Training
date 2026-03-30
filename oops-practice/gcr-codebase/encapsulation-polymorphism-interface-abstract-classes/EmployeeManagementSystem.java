package level1;

import java.util.*;

public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Employee emp1 = new FullTimeEmployee("Aryansh", 101, "HR", 50000);
		Employee emp2 = new PartTimeEmployee("Himanshu", 102, "IT", 150, 50000);

		emp1.displayDetails();
		emp2.displayDetails();
	}
}

interface Department {
	void assignDepartment(String department);

	void getDepartmentDetails();
}

abstract class Employee implements Department {
	int employeeID;
	String name;
	String department;
	double salary;

	Employee(String name, int employeeID, String department) {
		this.name = name;
		this.employeeID = employeeID;
		this.department = department;
	}

	abstract double calculateSalary(double salary);

	void displayDetails() {
		System.out.println('\n' + "Name: " + name);
		System.out.println("Employee ID: " + employeeID);
		System.out.println("Department: " + department);
		System.out.println("Salary: " + (salary == 0 ? "Salary not available" : "$" + salary));
	}

	@Override
	public void assignDepartment(String department) {
		this.department = department;
	}

	public void getDepartmentDetails() {
		System.out.println("Department: " + department);
	}

}

class FullTimeEmployee extends Employee {

	public FullTimeEmployee(String name, int employeeID, String department, double salary) {
		super(name, employeeID, department);
		this.salary = calculateSalary(salary);
	}

	double calculateSalary(double salary) {
		return salary;
	}
}

class PartTimeEmployee extends Employee {

	int workingHours;

	public PartTimeEmployee(String name, int employeeID, String department, int workingHours, double salary) {
		super(name, employeeID, department);
		this.workingHours = workingHours;
		this.salary = calculateSalary(salary);
	}

	@Override
	double calculateSalary(double salary) {
		return 20 * workingHours + salary;
	}
}
