package level1;

public class SchoolSystem {
	public static void main(String[] args) {
		Person2 t = new Teacher("Mr. Sharma", 40, "Mathematics");
        Person2 s = new Student("Riya", 16, "10th Grade");
        Person2 st = new Staff("Amit", 35, "Administration");

        ((Teacher) t).displayRole();
        System.out.println();

        ((Student) s).displayRole();
        System.out.println();

        ((Staff) st).displayRole();
	}
}
class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person2 {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person2 {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person2 {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
    }
}