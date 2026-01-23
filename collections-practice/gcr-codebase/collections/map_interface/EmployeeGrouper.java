package collections.map_interface;

import java.util.*;

class Employee {
	String name;
	String department;

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class EmployeeGrouper {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Alice", "HR"), new Employee("Bob", "IT"),
				new Employee("Carol", "HR"), new Employee("Dave", "Finance"), new Employee("Eve", "IT"));

		Map<String, List<Employee>> groupedByDept = groupByDepartment(employees);

		System.out.println("Employees grouped by Department:");
		groupedByDept.forEach((dept, list) -> System.out.println(dept + ": " + list));
	}

	public static Map<String, List<Employee>> groupByDepartment(List<Employee> list) {
		Map<String, List<Employee>> map = new HashMap<>();

		for (Employee emp : list) {

			map.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
		}

		return map;
	}
}