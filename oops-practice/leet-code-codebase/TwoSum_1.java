package week2;

import java.util.*;

public class TwoSum_1 {

	static public int maxProfit(int[] prices) {
        int profit = 0, n = prices.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += prices[i] - prices[i - 1];
            if (sum < 0)
                sum = 0;
            profit = Math.max(profit, sum);
        }
        return profit;
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
		System.out.println("user input: ");
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input: ");
		String input = sc.nextLine();

		int[] intArray = convertStringInputToIntArray(input);

		System.out.println("Max Profit: " + maxProfit(intArray));

		sc.close();
	}
}
