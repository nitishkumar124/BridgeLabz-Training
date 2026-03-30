package level3;

import java.util.*;

public class OTP {

	static int genearteOTP() {
		return (int) (Math.random() * 900000) + 100000;
	}

	static int[] getOTPList() {
		int[] numbers = new int[10];
		for (int i = 0; i < 10; i++) {
			numbers[i] = genearteOTP();
		}
		return numbers;
	}

	static void print(int[] numbers) {
		System.out.println("\nOTP numbers : ");
		for (int n : numbers) {
			System.out.println(n);
		}
		System.out.println();
	}

	static boolean isOTPUnique(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			int a = numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				int b = numbers[j];
				if (a == b)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] numbers = getOTPList();
		print(numbers);
		System.out.println("is OTP unique : " + isOTPUnique(numbers));

		sc.close();
	}
}
