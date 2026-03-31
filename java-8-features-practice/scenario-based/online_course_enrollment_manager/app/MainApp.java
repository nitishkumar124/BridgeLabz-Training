package week6_java8.online_course_enrollment_manager.app;

import java.time.LocalDate;

import week6_java8.online_course_enrollment_manager.model.*;
import week6_java8.online_course_enrollment_manager.service.*;

public class MainApp {
	public static void main(String[] args) {

		EnrollmentManager manager = new EnrollmentManager();

		manager.addEnrollment(new Enrollment("Amit", "Java", "Programming", LocalDate.of(2024, 1, 10)));
		manager.addEnrollment(new Enrollment("Riya", "Python", "Programming", LocalDate.of(2024, 2, 5)));
		manager.addEnrollment(new Enrollment("John", "AWS", "Cloud", LocalDate.of(2024, 1, 20)));
		manager.addEnrollment(new Enrollment("Neha", "Java", "Programming", LocalDate.of(2024, 3, 1)));
		manager.addEnrollment(new Enrollment("Rahul", "Azure", "Cloud", LocalDate.of(2024, 2, 15)));

		System.out.println("🔹 Filter by Course: Java");
		manager.filterByCourse("Java").forEach(System.out::println);

		System.out.println("\n🔹 Filter by Category: Cloud");
		manager.filterByCategory("Cloud").forEach(System.out::println);

		System.out.println("\n🔹 Group by Course");
		manager.groupByCourse().forEach((course, list) -> {
			System.out.println(course + " => " + list);
		});

		System.out.println("\n🔹 Count by Category");
		manager.countByCategory().forEach((cat, count) -> {
			System.out.println(cat + " => " + count);
		});

		System.out.println("\n🔹 Sorted by Enrollment Date");
		manager.sortByDate().forEach(System.out::println);
	}
}
