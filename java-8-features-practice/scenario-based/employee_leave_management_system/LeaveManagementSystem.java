package week6_java8.employee_leave_management_system;

import java.util.*;

class LeaveManagementSystem {
	private Map<String, Employee> employeeMap = new HashMap<>();
	private List<LeaveRequest> allRequests = new ArrayList<>();

	public void addEmployee(Employee emp) {
		employeeMap.put(emp.getId(), emp);
	}

	public void submitRequest(LeaveRequest request) throws InsufficientLeaveBalanceException {
		Employee emp = employeeMap.get(request.getEmployeeId());

		if (emp == null) {
			System.out.println("Employee not found.");
			return;
		}

		if (request.getRequestedDays() > emp.getLeaveBalance()) {
			throw new InsufficientLeaveBalanceException("Denied: " + emp.getId() + " requested "
					+ request.getRequestedDays() + " days but only has " + emp.getLeaveBalance());
		}

		allRequests.add(request);
		System.out.println("Request submitted for " + emp.getId());
	}

	public void processRequests() {
		for (LeaveRequest req : allRequests) {
			Employee emp = employeeMap.get(req.getEmployeeId());

			if (emp.getLeaveBalance() >= req.getRequestedDays()) {
				emp.deductLeave(req.getRequestedDays());
				req.setStatus("APPROVED");
			} else {
				req.setStatus("REJECTED");
			}
		}
	}

	public void displayAllRequests() {
		System.out.println("\n--- Leave Request Report ---");
		allRequests.forEach(System.out::println);
	}
}