package level3;

import java.util.*;

public class Calendar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the year : ");
		int year = sc.nextInt();
		System.out.print("Enter the month(1-12) : ");
		int month = sc.nextInt();

		String monthName = getMonthName(month);

		String[] dayNames = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
				
		System.out.println("\n" + monthName + " " + year);
		
		for (String d : dayNames) System.out.printf("%-5s", d);
		System.out.println();
		
		int firstDay = getFirstDayOfMonth(month, year);
		int days = getDaysInMonth(month, year);
		
		for (int i = 0; i < firstDay; i++) {
			System.out.printf("%-5s", "");
		}
		int date = 1;
		for (int i = firstDay; date <= days; i++) {
			if (i % 7 == 0) System.out.println(); 
			System.out.printf("%-5d", date++);
		}

		sc.close();
	}

	static String getMonthName(int month) {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		return months[month - 1];
	}

	static int getDaysInMonth(int month, int year) {

		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (isLeapYear(year)) {
			days[1] = 29;
		}

		return days[month - 1];

	}

	static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	static int getFirstDayOfMonth(int month, int year) {
		int y = year - (14 - month) / 12;
		int x = y + (y / 4) - (y / 100) + (y / 400);
		int m = month + 12 * ((14 - month) / 12) - 2;
		int day = (1 + x + ((31 * m) / 12)) % 7;
		return day;
	}

}
