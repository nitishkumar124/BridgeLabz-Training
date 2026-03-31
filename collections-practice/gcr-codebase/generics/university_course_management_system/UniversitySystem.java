package generics.university_course_management_system;

import java.util.*;

public class UniversitySystem {
	public static void main(String[] args) {

		Course<ExamCourse> math = new Course<>("Calculus I", "MATH101", new ExamCourse());
		Course<AssignmentCourse> cs = new Course<>("Java Programming", "CS202", new AssignmentCourse());
		Course<ResearchCourse> phd = new Course<>("AI Ethics Research", "PHD999", new ResearchCourse());

		List<Course<? extends CourseType>> semesterCatalog = new ArrayList<>();
		semesterCatalog.add(math);
		semesterCatalog.add(cs);
		semesterCatalog.add(phd);

		UniversityRegistrar.printCourseCatalog(semesterCatalog);
	}
}