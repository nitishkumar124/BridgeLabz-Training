package week2;

import java.util.*;

public class BestTimeToBuyAndSellStock_121 {

	static public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] + nums[i] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public static int[] convertStringInputToIntArray(String input) {
		String[] stringArray = input.split(" ");

		int[] intArray = new int[stringArray.length];

		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		return intArray;
	}

	static void printArray(int[] array) {
		System.out.println("number indices: ");
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input: ");
		String input = sc.nextLine();
		System.out.print("Enter target sum: ");
		int target = sc.nextInt();

		int[] intArray = convertStringInputToIntArray(input);

		printArray(twoSum(intArray, target));

		sc.close();
	}
}
