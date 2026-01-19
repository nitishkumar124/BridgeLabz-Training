package week3;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class ContainsDuplicate_217 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter integers separated by spaces: ");
		String input = scanner.nextLine();

		if (input.trim().isEmpty()) {
			System.out.println("Result: false");
			return;
		}

		int[] nums = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

		boolean result = containsDuplicate(nums);
		System.out.println("Contains duplicate? " + result);

		scanner.close();
	}

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> seen = new HashSet<>();

		for (int num : nums) {

			if (!seen.add(num)) {
				return true;
			}
		}

		return false;
	}
}