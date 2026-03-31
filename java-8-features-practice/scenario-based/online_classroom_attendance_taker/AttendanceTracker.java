package week6_java8.online_classroom_attendance_taker;

import java.util.*;

class AttendanceTracker {

	private Map<String, Set<String>> sessionAttendance = new HashMap<>();

	public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {

		sessionAttendance.putIfAbsent(sessionId, new HashSet<>());

		Set<String> students = sessionAttendance.get(sessionId);

		if (students.contains(studentId)) {
			throw new DuplicateAttendanceException(
					"Student " + studentId + " is already marked for session " + sessionId);
		}

		students.add(studentId);
		System.out.println("Attendance marked: " + studentId + " in " + sessionId);
	}

	public void removeAttendance(String sessionId, String studentId) {
		if (sessionAttendance.containsKey(sessionId)) {
			boolean removed = sessionAttendance.get(sessionId).remove(studentId);
			if (removed) {
				System.out.println("Removed " + studentId + " from session " + sessionId);
			}
		}
	}

	public void displayAttendance(String sessionId) {
		System.out.println("\n--- Attendance List for " + sessionId + " ---");
		Set<String> students = sessionAttendance.getOrDefault(sessionId, Collections.emptySet());

		if (students.isEmpty()) {
			System.out.println("No students present.");
		} else {
			students.forEach(id -> System.out.println("Student ID: " + id));
		}
	}
}