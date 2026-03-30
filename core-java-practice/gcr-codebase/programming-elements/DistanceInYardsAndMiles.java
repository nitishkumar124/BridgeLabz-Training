package level1;

import java.util.Scanner;

public class DistanceInYardsAndMiles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the distance in feets : ");
		double feet = sc.nextDouble();
		double yard = feet / 3;
		double mile = yard / 1760;
		System.out.println("The distance in feet is " + feet + ". Distance in yards and miles is " + yard + " and " + mile);
	}

}
