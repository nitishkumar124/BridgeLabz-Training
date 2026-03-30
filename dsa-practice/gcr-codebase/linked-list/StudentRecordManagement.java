package linked_list;

public class StudentRecordManagement {
	public static void main(String[] args) {
		StudentManagementSystem sms = new StudentManagementSystem();

		sms.addStudent(101, "Alice", 20, 'A', 1);
		sms.addStudent(102, "Bob", 22, 'B', 2);
		sms.addStudent(103, "Charlie", 21, 'B', 2);

		System.out.println("All Students:");
		sms.displayAll();

		sms.updateGrade(102, 'A');
		sms.deleteStudent(103);

		System.out.println("\nAfter Updates:");
		sms.displayAll();
	}
}

class Node {
	int rollNumber;
	String name;
	int age;
	char grade;
	Node next;

	public Node(int rollNumber, String name, int age, char grade) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}

class StudentManagementSystem {
	private Node head;

	public void addStudent(int rollNumber, String name, int age, char grade, int pos) {
		Node newNode = new Node(rollNumber, name, age, grade);

		// Add at the start
		if (pos == 1 || head == null) {
			newNode.next = head;
			head = newNode;
			return;
		}

		Node temp = head;
		int currentPos = 1;
		// Traverse to position - 1 or the end of the list
		while (temp.next != null && currentPos < pos - 1) {
			temp = temp.next;
			currentPos++;
		}

		newNode.next = temp.next;
		temp.next = newNode;
	}

	// Delete Student
	public void deleteStudent(int rollNumber) {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		// delete head
		if (head.rollNumber == rollNumber) {
			head = head.next;
			return;
		}

		Node current = head;
		Node prev = null;
		while (current != null && current.rollNumber != rollNumber) {
			prev = current;
			current = current.next;
		}

		if (current == null) {
			System.out.println("Roll Number " + rollNumber + " not found.");
			return;
		}

		prev.next = current.next;
	}

	// Search Student
	public void searchStudent(int rollNumber) {
		Node temp = head;
		while (temp != null) {
			if (temp.rollNumber == rollNumber) {
				System.out.println("Found: " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found.");
	}

	// Update Grade
	public void updateGrade(int rollNumber, char newGrade) {
		Node temp = head;
		while (temp != null) {
			if (temp.rollNumber == rollNumber) {
				temp.grade = newGrade;
				System.out.println("Grade updated for " + temp.name);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found.");
	}

	// Display All Records
	public void displayAll() {
		if (head == null) {
			System.out.println("No records to display.");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.println("ID: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: "
					+ temp.grade);
			temp = temp.next;
		}
	}
}
