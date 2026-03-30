package level3;

import java.util.*;

public class LeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter year : ");
		int year = sc.nextInt();
		if (year >= 1582) {
			if (year % 4 == 0) {
				if (year % 100 == 0) {
					System.out.println("Not a leap year.");
				} else
					System.out.println("It's a leap year.");
			} else if (year % 400 == 0) {
				System.out.println("It's a leap year.");
			} else {
				System.out.println("Not a leap year.");
			}
		} else {
			System.out.println("Not applicable as a leap year.\nWorks only for year >= 1582");
		}
		sc.close();
	}
}
