package week6_java8.online_classroom_attendance_taker;

public class Main {
	public static void main(String[] args) {
		AttendanceTracker tracker = new AttendanceTracker();

		try {

			tracker.markAttendance("MATH101", "STU_001");
			tracker.markAttendance("MATH101", "STU_002");

			tracker.markAttendance("SCI202", "STU_001");

			tracker.markAttendance("MATH101", "STU_001");

		} catch (DuplicateAttendanceException e) {
			System.err.println("Error: " + e.getMessage());
		}

		tracker.displayAttendance("MATH101");

		tracker.removeAttendance("MATH101", "STU_002");
		tracker.displayAttendance("MATH101");
	}
}