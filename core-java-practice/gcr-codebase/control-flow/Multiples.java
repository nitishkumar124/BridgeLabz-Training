package level2;

import java.util.*;

public class Multiples {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int number = sc.nextInt();
		if (number > 0 || number < 100) {
			for (int i = 100; i > 0; i--) {
				if (number % i == 0)
					System.out.println(i);
			}
		} else {
			System.out.println("number is not in the range (0-100).");
		}
		sc.close();
	}
}
