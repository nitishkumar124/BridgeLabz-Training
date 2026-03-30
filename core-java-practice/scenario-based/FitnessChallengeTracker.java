package practice_problems;

import java.util.*;

public class FitnessChallengeTracker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		System.out.println("----><---- Fitness Tracker ----><----");		
		System.out.println("Note: enter number of push-ups for a week and 0 for rest days.\n");		
		for (int i = 0; i < 7; i++) {
			System.out.print("push ups on day " + (i + 1) + " : ");
			arr[i] = sc.nextInt();
		}
		int total = 0;
		double average;
		for (int a : arr) {
			total += a;
		}
		average = Math.round(total / 7.0);		
		
		System.out.println("Total push-ups this week : " + total);
		System.out.println("Average push-ups a day this week : " + average);

		sc.close();
	}
}
