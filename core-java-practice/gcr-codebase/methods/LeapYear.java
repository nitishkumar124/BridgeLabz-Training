package level2;

import java.util.*;

public class LeapYear {
//	Write a program that takes a year as input and outputs the Year is a Leap Year or not 
//	Hint => 
//	The LeapYear program only works for year >= 1582, corresponding to a year in the Gregorian calendar. 
//	Also Leap year is divisible by 4 and not divisible by 100 or divisible by 400
//	Write a method to check for Leap Year using the conditions a and b

	static boolean checkLeapYear(int n) {
		if (n < 1582)
			return false;

		if (n % 4 == 0 && n % 100 != 0)
			return true;
		else if (n % 400 == 0)
			return true;

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter year : ");
		int year = sc.nextInt();
		
		boolean check = checkLeapYear(year);
		
		if (check) System.out.println("It's a leap year.");
		else System.out.println("It's NOT a leap year.");

		sc.close();
	}
}
