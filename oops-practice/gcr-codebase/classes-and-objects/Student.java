package level2;

public class Student {
	String name;
	String rollNumber;
	double Mark1, Mark2, Mark3;

	char grade() {
		double avg = (Mark1 + Mark2 + Mark3) / 3.0;
		if (avg >= 75)
			return 'B';
		else if (avg >= 60)
			return 'C';
		else
			return 'D';
	}
	void display() {
		System.out.println("Student Name: " + name);
		System.out.println("Student RollNumber: " + rollNumber);
		System.out.println("Student Marks:");
		System.out.println("Mark1: " + Mark1);
		System.out.println("Mark2: " + Mark2);
		System.out.println("Mark3: " + Mark3);
		System.out.println("Grade " + grade());
		System.out.println();
	}
	public static void main(String[] args) {
		Student s1 = new Student();
        s1.name = "Thamarai";
        s1.rollNumber = "ECE001";
        s1.Mark1 = 80;
        s1.Mark2 = 70;
        s1.Mark3 = 75;

        Student s2 = new Student();
        s2.name = "Kannan";
        s2.rollNumber = "CSC002";
        s2.Mark1 = 60;
        s2.Mark2 = 65;
        s2.Mark3 = 50;

        s1.display();
        s2.display();
	}
}