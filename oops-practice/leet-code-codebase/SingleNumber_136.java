package week2;

import java.util.Scanner;
import java.util.Arrays;

public class SingleNumber_136 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter integers (separated by spaces) where all but one repeat twice: ");
		String input = scanner.nextLine();

		if (input.trim().isEmpty()) {
			System.out.println("Empty input.");
			return;
		}

		int[] nums = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

		int result = singleNumber(nums);
		System.out.println("The single number is: " + result);

		scanner.close();
	}

	public static int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}
}