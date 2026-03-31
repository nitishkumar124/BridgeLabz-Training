package week4_collections;

import java.util.*;

class Student {
	String name;
	int score;

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return String.format("%-10s : %d", name, score);
	}
}

public class EduResults {

	public static void mergeSort(List<Student> students, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;

			mergeSort(students, left, mid);
			mergeSort(students, mid + 1, right);

			merge(students, left, mid, right);
		}
	}

	private static void merge(List<Student> students, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		List<Student> leftList = new ArrayList<>(students.subList(left, mid + 1));
		List<Student> rightList = new ArrayList<>(students.subList(mid + 1, right + 1));

		int i = 0, j = 0, k = left;

		while (i < n1 && j < n2) {
			if (leftList.get(i).score >= rightList.get(j).score) {
				students.set(k++, leftList.get(i++));
			} else {
				students.set(k++, rightList.get(j++));
			}
		}

		while (i < n1)
			students.set(k++, leftList.get(i++));
		while (j < n2)
			students.set(k++, rightList.get(j++));
	}

	public static void main(String[] args) {
		List<Student> stateList = new ArrayList<>();

		stateList.add(new Student("Alice", 85));
		stateList.add(new Student("Bob", 92));
		stateList.add(new Student("Charlie", 85));
		stateList.add(new Student("David", 78));
		stateList.add(new Student("Eve", 95));

		System.out.println("--- Raw District Data ---");
		stateList.forEach(System.out::println);

		mergeSort(stateList, 0, stateList.size() - 1);

		System.out.println("\n--- Final State Rank List ---");
		for (int i = 0; i < stateList.size(); i++) {
			System.out.println("Rank " + (i + 1) + ": " + stateList.get(i));
		}
	}
}