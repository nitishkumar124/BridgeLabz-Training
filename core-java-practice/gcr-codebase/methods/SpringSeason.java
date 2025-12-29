package level1;

import java.util.*;

public class SpringSeason {

	static void isSpringSeason(int month, int day) {
		if (month == 3) {
			if (day >= 20)
				System.out.println("It's a Spring Season.");
			else
				System.out.println("Not a spring Season.");
		} else if (month == 4 || month == 5) {
			System.out.println("It's a Spring Season.");
		} else if (month == 6) {
			if (day <= 20)
				System.out.println("It's a Spring Season.");
			else
				System.out.println("Not a Spring Season.");
		} else {
			System.out.println("Not a Spring Season.");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter month(1-12) : ");
		int month = sc.nextInt();

		System.out.print("Enter day : ");
		int day = sc.nextInt();
		
		isSpringSeason(month, day);

		sc.close();
	}
}
