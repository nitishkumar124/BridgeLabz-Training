package level2;

import java.util.*;

public class DigitsInANumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter number : ");
		int n = sc.nextInt();
		int maxDigit = 10;
		int[] digits = new int[maxDigit];
		int index = 0;

		int largest = 0, secondLargest = 0;

		while (n > 0) {
			if (index == maxDigit)
				break;
			int digit = n % 10;
			digits[index++] = digit;
			n /= 10;
		}

		for (int i = 0; i < digits.length; i++) {
			int num = digits[i];
			if (largest < num) {
				secondLargest = largest;
				largest = num;
			} else if (num > secondLargest && num != largest) {
                secondLargest = num; 
            }
		}

		System.out.println("largest : " + largest);
		System.out.println("second largest : " + secondLargest);

		sc.close();
	}
}
