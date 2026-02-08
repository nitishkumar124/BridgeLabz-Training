package week6_java8.employee_leave_management_system;

public class Main {
	public static void main(String[] args) {
		LeaveManagementSystem system = new LeaveManagementSystem();

		system.addEmployee(new Employee("EMP101", "John Doe", 10));
		system.addEmployee(new Employee("EMP102", "Jane Smith", 5));

		try {

			system.submitRequest(new LeaveRequest("EMP101", 3));

			system.submitRequest(new LeaveRequest("EMP102", 10));

		} catch (InsufficientLeaveBalanceException e) {
			System.err.println("HR Alert: " + e.getMessage());
		}

		system.processRequests();
		system.displayAllRequests();
	}
}