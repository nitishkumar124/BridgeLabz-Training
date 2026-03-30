package practice_problems;

import java.util.*;

public class BusRouteDistanceTracker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double totalDistance = 0;
		while (true) {
			System.out.println("Enter distance to next stop ( in km): ");
			double distance = sc.nextDouble();
			totalDistance += distance;
			System.out.println("Total Distance Covered: " + totalDistance + " km ");
			System.out.println("Want to get off?(yes/no)");
			String choice = sc.next();
			if (choice.equalsIgnoreCase("yes")) {
				System.out.println("Hope You Enjoy the Ride! Travel Again.");
				break;
			}
		}
		sc.close();
	}
}