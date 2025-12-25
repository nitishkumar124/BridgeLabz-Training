package level1;

import java.util.Scanner;

public class ConvertHeight {

	public static void main(String[] args) {
//		Your Height in cm is ___ while in feet is ___ and inches is ___
		Scanner sc = new Scanner(System.in);
		System.out.println("what's your height in cm : ");
		double cmHeight = sc.nextDouble();
		double inchHeight = cmHeight / 2.54;
		double feetHeight = inchHeight / 12;
		System.out.println("Your Height in cm is " + cmHeight + " while in feet is " + feetHeight + " and inches is " + inchHeight);
	}

}
