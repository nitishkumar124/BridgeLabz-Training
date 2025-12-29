package practice_problems;

import java.util.*;

public class ElectionBoothManager {
//	Design a polling booth system.
//	● Take age input.
//	● Use if to check if eligible (>=18).
//	● Record vote (1, 2, or 3 for candidates).
//	● Loop for multiple voters, exit on special code.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Enter age : ");
			int age = sc.nextInt();

			if (age > 17) {
				System.out.println("Eligible to Vote.");
				System.out.print("\nSelect Candidate(1, 2 or 3) : ");
				int c = sc.nextInt();
				if (c == 1) {
					System.out.println("Voted for Candidate A.");
				} else if (c == 2) {
					System.out.println("Voted for Candidate B.");
				} else if (c == 3) {
					System.out.println("Voted for Candidate C.");
				} else {
					System.out.println("Invalid Selection.");
				}

				System.out.print("\npress 1 to continue.\npress 0 to exit : ");
				int f = sc.nextInt();
				if (f == 0) {
					System.out.println("Thanks for voting.");
					break;
				}
				System.out.println();
			} else {
				System.out.println("Not eligible to Vote.\n");
			}
		}

		sc.close();
	}
}
