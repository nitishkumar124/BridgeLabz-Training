package level1;

class Employee {
	String name;
	int id;
	double salary;

	Employee(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	void displayDetails() {
		System.out.println("Name: " + name);
		System.out.println("id: " + id);
		System.out.println("Salary: " + salary);
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee("Rohan", 1, 500000.0);

		emp1.displayDetails();
	}
}