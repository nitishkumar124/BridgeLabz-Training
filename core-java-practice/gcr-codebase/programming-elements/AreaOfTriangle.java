package level1;

import java.util.Scanner;

public class AreaOfTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter base of triangle : ");
		double base = sc.nextDouble();
		System.out.println("enter height of triangle : ");
		double height = sc.nextDouble();

		double cmArea = base * height * 1 / 2;
		double inchArea = cmArea / 6.4516;

		System.out.println("The triangle base and height in cm is " + base + " and " + height
				+ ".\nArea in cm and inches is " + cmArea + " and " + inchArea);

	}

}
