package level2;

import java.util.*;

public class MultiplesWhileLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int number = sc.nextInt();
		if (number > 0 || number < 100) {
			int i = 100;
			while (i > 0) {
				if (number % i == 0)
					System.out.println(i);
				i--;
			}
		} else {
			System.out.println("number is not in the range (0-100).");
		}
		sc.close();
	}
}
