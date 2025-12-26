package level1;

import java.util.*;

public class StudentVoteEligibility {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.print("Student " + (i + 1) + " age : ");
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0)
				System.out.println("Invalid age : " + arr[i]);
			else if (arr[i] > 17)
				System.out.println("Student with the age " + arr[i] + " can vote.");
			else
				System.out.println("Student with the age " + arr[i] + " can NOT vote.");
		}

		sc.close();
	}
}
