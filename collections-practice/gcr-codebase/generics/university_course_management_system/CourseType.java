package generics.university_course_management_system;

abstract class CourseType {
	private String typeName;

	public CourseType(String typeName) {
		this.typeName = typeName;
	}

	public abstract String getEvaluationCriteria();

	@Override
	public String toString() {
		return typeName;
	}
}

class ExamCourse extends CourseType {
	public ExamCourse() {
		super("Exam-Based");
	}

	public String getEvaluationCriteria() {
		return "Midterm: 40%, Final: 60%";
	}
}

class AssignmentCourse extends CourseType {
	public AssignmentCourse() {
		super("Assignment-Based");
	}

	public String getEvaluationCriteria() {
		return "4 Projects, 25% each";
	}
}

class ResearchCourse extends CourseType {
	public ResearchCourse() {
		super("Research-Based");
	}

	public String getEvaluationCriteria() {
		return "Thesis Defense: 100%";
	}
}