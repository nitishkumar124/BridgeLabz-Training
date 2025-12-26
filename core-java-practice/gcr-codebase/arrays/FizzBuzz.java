package level1;

import java.util.*;

public class FizzBuzz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();

		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			int k = i + 1;
			if (k % 15 == 0) {
				arr[i] = "FizzBuzz";
			} else if (k % 5 == 0) {
				arr[i] = "Buzz";
			} else if (k % 3 == 0) {
				arr[i] = "Fizz";
			} else {
				arr[i] = String.valueOf(k);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.err.println("position " + (i + 1) + " : " + arr[i]);
		}

		sc.close();
	}
}
