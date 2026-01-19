package week2;

import java.util.*;

public class RemoveDuplicatesFromSortedArray_26 {

	static public int removeDuplicates(int[] nums) {
		int i = 0, j = 1;
		int n = nums.length;
		if (n < 2)
			return n;
		while (i + 1 < n && j < n) {
			while (j < n && nums[i] == nums[j])
				j++;
			if (j < n)
				nums[++i] = nums[j++];
		}
		return i + 1;
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
		System.out.println("User Input: ");
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	static void printArray(int[] array, int index) {
		System.out.println("Result Output: ");
		for (int i = 0; i < array.length && i < index; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input: ");
		String input = sc.nextLine();

		int[] intArray = convertStringInputToIntArray(input);

		printArray(intArray);

		printArray(intArray, removeDuplicates(intArray));

		sc.close();
	}
}
