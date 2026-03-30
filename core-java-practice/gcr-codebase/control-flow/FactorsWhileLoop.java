package level2;

import java.util.*;

public class FactorsWhileLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int number = sc.nextInt();
		if (number > 0) {

			int i = 1;
			while (i <= number) {
				if (number % i == 0) {
					System.out.println("divisible by " + i);
				}
				i++;
			}
		} else {
			System.out.println("number is not positive.");
		}

		sc.close();
	}
}
