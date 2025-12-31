package level1;

import java.util.*;

public class Course {

	static String instituteName = "GLA";

	String courseName;
	int duration;
	double fee;

	Course(String courseName, int duration, double fee) {
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}

	void displayCourseDetails() {
		System.out.println("course Name: " + courseName);
		System.out.println("institute name: " + instituteName);
		System.out.println("duration: " + duration + " years");
		System.out.println("fee: $" + fee + '\n');
	}

	static void updateInstituteName(String newInstituteName) {
		instituteName = newInstituteName;
		System.out.println("institute name updated.\ninstitute name: " + instituteName);
	}

	public static void main(String[] args) {
		Course c = new Course("MCA", 2, 4000);
		c.displayCourseDetails();
		Course.updateInstituteName("DBRAU");
	}
}
