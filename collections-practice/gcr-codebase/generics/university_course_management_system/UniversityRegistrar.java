package generics.university_course_management_system;

import java.util.*;

class UniversityRegistrar {

	public static void printCourseCatalog(List<Course<? extends CourseType>> courses) {
		System.out.println("\n========== UNIVERSITY COURSE CATALOG ==========");
		for (Course<? extends CourseType> course : courses) {
			course.displayDetails();
			System.out.println("-----------------------------------------------");
		}
	}
}