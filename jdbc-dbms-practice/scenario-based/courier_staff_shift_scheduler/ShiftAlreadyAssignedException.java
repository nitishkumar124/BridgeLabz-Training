package week9.courier_staff_shift_scheduler;

class ShiftAlreadyAssignedException extends Exception {
	public ShiftAlreadyAssignedException(String message) {
		super(message);
	}
}
