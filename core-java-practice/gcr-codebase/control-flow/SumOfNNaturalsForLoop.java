package level1;

import java.util.*;

public class SumOfNNaturalsForLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value : ");
		int n = sc.nextInt();
		int temp = n;
		if (n > 0) {
			int sum1 = 0;
			for (; n > 0; n--)
				sum1 += n;
			n = temp;
			System.out.println("sum using for loop : " + sum1);
			int sum2 = (n * (n + 1) / 2);
			System.out.println("sum using formula : " + sum2);
		} else {
			System.out.println("value not a natural number.");
		}

		sc.close();
	}
}
