package level1;

import java.util.*;

public class FactorialForLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value : ");
		int n = sc.nextInt();
		if (n > 0) {
			int factorial = 1;
			for (; n > 0; n--)
				factorial *= n;
			System.out.println("factorial using for loop : " + factorial);
		} else {
			System.out.println("value not positive.");
		}

		sc.close();
	}
}
