package level3;

import java.util.*;

public class DayOfWeek {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter month (use 1 for January, 2 for February, and so forth) : ");
		int month = sc.nextInt();
		System.out.print("Enter date : ");
		int date = sc.nextInt();
		System.out.print("Enter year : ");
		int year = sc.nextInt();

		int y = year - (14 - month) / 12;
		int x = y + y / 4 - y / 100 + y / 400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (date + x + (31 * m) / 12) % 7;

		switch (d) {
		case 0:
			System.out.println("Sunday.");
			break;
		case 1:
			System.out.println("Monday.");
			break;
		case 2:
			System.out.println("Tuesday.");
			break;
		case 3:
			System.out.println("Wednesday.");
			break;
		case 4:
			System.out.println("Thursday.");
			break;
		case 5:
			System.out.println("Friday.");
			break;
		case 6:
			System.out.println("Saturday.");
			break;
		default:
			System.out.println("Some Error Occured.");
		}

		sc.close();
	}
}
