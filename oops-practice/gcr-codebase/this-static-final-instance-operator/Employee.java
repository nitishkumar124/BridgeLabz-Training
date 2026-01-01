package level1;

import java.util.*;

public class Employee {

	static String companyName;
	static int employees = 0;

	String name;
	final int id;
	String designation;

	public Employee(String name, int id, String designation) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		employees++;
	}

	static void displayTotalEmployees() {
		System.out.println("Total Employees: " + employees + "\n");
	}

	void displayEmployeeDetails() {
		System.out.println("Name: " + name);
		System.out.println("Employee ID: " + id);
		System.out.println("Designation: " + designation + "\n");
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee("Aryansh", 01, "CEO | CFO");
		Employee emp2 = new Employee("Nitish", 99, "Driver");
		Employee.companyName = "CharPanch Pvt. Ltd.";
		Employee.displayTotalEmployees();
		if (emp1 instanceof Employee)
			emp1.displayEmployeeDetails();

		if (emp2 instanceof Employee)
			emp2.displayEmployeeDetails();
	}
}
