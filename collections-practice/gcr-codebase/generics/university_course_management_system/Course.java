package generics.university_course_management_system;

class Course<T extends CourseType> {
	private String courseName;
	private String courseCode;
	private T evaluationMethod;

	public Course(String courseName, String courseCode, T evaluationMethod) {
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.evaluationMethod = evaluationMethod;
	}

	public void displayDetails() {
		System.out.println("Course: " + courseName + " [" + courseCode + "]");
		System.out.println("Evaluation: " + evaluationMethod);
		System.out.println("Criteria: " + evaluationMethod.getEvaluationCriteria());
	}

	public T getEvaluationMethod() {
		return evaluationMethod;
	}
}