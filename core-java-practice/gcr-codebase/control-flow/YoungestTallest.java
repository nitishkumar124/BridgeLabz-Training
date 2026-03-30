package level2;

import java.util.*;

public class YoungestTallest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Amar's age: ");
		int ageAmar = sc.nextInt();
		System.out.print("Enter Amar's height: ");
		int heightAmar = sc.nextInt();
		System.out.print("Enter Akbar's age: ");
		int ageAkbar = sc.nextInt();
		System.out.print("Enter Akbar's height: ");
		int heightAkbar = sc.nextInt();
		System.out.print("Enter Anthony's age: ");
		int ageAnthony = sc.nextInt();
		System.out.print("Enter Anthony's height: ");
		int heightAnthony = sc.nextInt();

		if (ageAkbar < ageAmar) {
			if (ageAkbar < ageAnthony) {
				System.out.println("Akbar is the youngest");
			} else {
				System.out.println("Anthony is the youngest");
			}
		} else if (ageAmar < ageAnthony)
			System.out.println("Amar is the youngest");
		else
			System.out.println("Anthony is the youngest");
		
		if (heightAkbar > heightAmar) {
			if (heightAkbar > heightAnthony) {
				System.out.println("Akbar is the tallest");
			} else {
				System.out.println("Anthony is the tallest");
			}
		} else if (heightAmar > heightAnthony)
			System.out.println("Amar is the tallest");
		else
			System.out.println("Anthony is the tallest");


		sc.close();
	}
}
