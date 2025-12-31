package level1;

public class Student {

	public int rollNumber;
	protected String name;
	private double CGPA;

	Student(int rollNumber, String name, double CGPA) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.CGPA = CGPA;
	}

	void displayCGPA() {
		System.out.println("CGPA: " + CGPA);
	}

	public void modifyCGPA(double CGPA) {
		this.CGPA = CGPA;
		System.out.println("CGPA modified: " + this.CGPA);
	}

	public static void main(String[] args) {
		PostgraduateStudent pg = new PostgraduateStudent(101, "Alice Smith", 3.8, "Computer Science");

		pg.modifyCGPA(3.9);
		pg.displayDetails();
	}
}

class PostgraduateStudent extends Student {
	private String course;

	public PostgraduateStudent(int rollNumber, String name, double cgpa, String course) {
		super(rollNumber, name, cgpa);
		this.course = course;
	}

	public void displayDetails() {
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("Name: " + name);
		displayCGPA();
		System.out.println("Course: " + course);
	}
}