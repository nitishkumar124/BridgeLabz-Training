package level3;

import java.util.*;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();

		if (n > 1) {
			boolean isPrime = true;
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(n + " is Prime.");
			} else
				System.out.println(n + " is not Prime.");

		} else {
			System.out.println("Works only for numbers grater than 1.");
		}

		sc.close();
	}
}
