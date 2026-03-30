package level2;

import java.util.*;

public class DigitFrequency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();

		int[] arr = new int[10];

		while (n > 0) {
			int d = n % 10;
			arr[d] += 1;
			n /= 10;
		}
		System.out.println("Digit : Frequency");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				System.out.println(i + " : " + arr[i]);
		}

		sc.close();
	}
}
