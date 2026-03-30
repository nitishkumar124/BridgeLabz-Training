package level2;

import java.util.*;

public class StudentVotingEligibility {

	public static int[] getAge(int n) {
		int[] ages = new int[n];
		for (int i = 0; i < n; i++) {
			ages[i] = (int) (Math.random() * 90);
		}
		return ages;
	}

	public static String[][] votingList(int[] ages) {
		String[][] list = new String[ages.length][2];

		for (int i = 0; i < ages.length; i++) {
			int age = ages[i];
			if (age < 18) {
				list[i][0] = String.valueOf(age);
				list[i][1] = "false";
			} else {
				list[i][0] = String.valueOf(age);
				list[i][1] = "true";

			}
		}

		return list;
	}
	
	public static void print(String[][] list) {
		System.out.println("Age : vote");
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i][0] + " : " + list[i][1]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of students to print voting list : ");
		int n = sc.nextInt();
		
		String[][] list = votingList(getAge(n));
		print(list);
		
		
		sc.close();
	}
}
