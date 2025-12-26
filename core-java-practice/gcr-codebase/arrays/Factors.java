package level1;

import java.util.*;

public class Factors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();

		int maxFactor = 10;
		int[] factors = new int[maxFactor];
		int index = 0;
		for (int i = 0; i < n; i++) {
			int k = i + 1;
			if (i == maxFactor) {
				maxFactor *= 2;
				int[] temp = new int[maxFactor];
				for (int j = 0; j < factors.length; j++) {
					temp[j] = factors[j];
				}
				factors = temp;
			}
			if (n % k == 0) {
				factors[i] = k;
			}
		}
		int count = 1;
		for (int i = 0; i < factors.length; i++) {
			if (factors[i] != 0)
				System.out.println("factor " + count++ + " : " + factors[i]);
		}

		sc.close();
	}
}
