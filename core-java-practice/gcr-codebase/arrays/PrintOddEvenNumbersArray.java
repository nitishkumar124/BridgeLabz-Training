package level1;

import java.util.*;

public class PrintOddEvenNumbersArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("enter a number : ");
		int n = sc.nextInt();
		if (n < 1) {
			System.out.println("entered a negative number.");
			return;
		}
		int size = n / 2 + 1;
		int oddIdx = 0, evenIdx = 0;
		int evenArr[] = new int[size];
		int oddArr[] = new int[size];

		for (int i = 0; i < n; i++) {
			int k = i + 1;
			if (k % 2 == 0) {
				evenArr[evenIdx++] = k;
			} else {
				oddArr[oddIdx++] = k;
			}
		}
		oddIdx = 0;
		evenIdx = 0;
		
		for (; evenIdx < evenArr.length; evenIdx++) {
			System.out.println("even array number at index " + evenIdx + " : " + evenArr[evenIdx]);
		}
		for (; oddIdx < oddArr.length; oddIdx++) {
			System.out.println("odd array number at index " + oddIdx + " : " + oddArr[oddIdx]);
		}

		sc.close();
	}
}
