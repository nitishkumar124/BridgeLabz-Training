package level3;

import java.util.*;

public class HarshadNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		int number = n;
		int digitSum = 0;

		while (n > 0) {
			digitSum += n % 10;
			n /= 10;
		}

		if (number % digitSum == 0)
			System.out.println("It's a Harshad Number.");
		else
			System.out.println("It's NOT a Harshad Number.");

		sc.close();
	}
}
