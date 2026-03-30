package level1;

import java.util.Scanner;

public class ConvertUserInputKmToMiles {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double km = input.nextInt();
		// The total miles is ___ mile for the given ___ km
		double miles = km * 1.6;
		System.out.println("The total miles is " + miles + " mile for the given " + km + " km.");
	}

}
