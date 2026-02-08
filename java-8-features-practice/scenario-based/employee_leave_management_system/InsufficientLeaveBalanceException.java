package week6_java8.employee_leave_management_system;

class InsufficientLeaveBalanceException extends Exception {
	public InsufficientLeaveBalanceException(String message) {
		super(message);
	}
}