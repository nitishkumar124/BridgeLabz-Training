package week6_java8.online_course_enrollment_manager.service;

import java.util.*;
import java.util.stream.Collectors;

import week6_java8.online_course_enrollment_manager.model.*;

public class EnrollmentManager {

	private List<Enrollment> enrollments = new ArrayList<>();

	public void addEnrollment(Enrollment e) {
		enrollments.add(e);
	}

	// 1. Filter by Course Name
	public List<Enrollment> filterByCourse(String courseName) {
		return enrollments.stream().filter(e -> e.getCourseName().equalsIgnoreCase(courseName))
				.collect(Collectors.toList());
	}

	// 2. Filter by Category
	public List<Enrollment> filterByCategory(String category) {
		return enrollments.stream().filter(e -> e.getCourseCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	// 3. Group by Course Name
	public Map<String, List<Enrollment>> groupByCourse() {
		return enrollments.stream().collect(Collectors.groupingBy(Enrollment::getCourseName));
	}

	// 4. Count Enrollments per Category
	public Map<String, Long> countByCategory() {
		return enrollments.stream()
				.collect(Collectors.groupingBy(Enrollment::getCourseCategory, Collectors.counting()));
	}

	// 5. Sort by Enrollment Date
	public List<Enrollment> sortByDate() {
		return enrollments.stream().sorted(Comparator.comparing(Enrollment::getEnrollmentDate))
				.collect(Collectors.toList());
	}
}
