package level3;

import java.util.*;

public class AbundantNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input: ");
		int n = sc.nextInt();

		int divisorSum = 0;

		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				divisorSum += i;
			}
		}

		if (divisorSum > n) {
			System.out.println("It's a Abundant Number.");
		} else
			System.out.println("It's NOT a Abundant Number.");

		sc.close();
	}
}
