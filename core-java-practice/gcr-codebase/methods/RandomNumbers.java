package level2;

import java.util.*;

public class RandomNumbers {
//	Write a program that generates five 4 digit random values and then finds their average value, and their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().
//	Hint => 
//	Write a method that generates array of 4 digit random numbers given the size as a parameter as shown in the method signature 
//	public int[] generate4DigitRandomArray(int size)
//	Write a method to find average, min and max value of an array 
//	public double[] findAverageMinMax(int[] numbers) 

	static int[] generate4DigitRandomArray(int size) {
		int[] nums = new int[size];

		for (int i = 0; i < size; i++)
			nums[i] = (int) (Math.random() * 9000) + 1000;

		return nums;
	}

	static void print(int[] nums) {
		for (int n : nums) {
			System.out.println(n);
		}
	}

	public static double[] findAverageMinMax(int[] nums) {

		int sum = 0;
		for (int n : nums)
			sum += n;
		double average = sum * 1.0 / (nums.length);

		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}

		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}

		return new double[] { average, min, max };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array with random 4 digit numbers : ");
		int n = sc.nextInt();
		int[] nums = generate4DigitRandomArray(n);
		double[] results = findAverageMinMax(nums);

		print(nums); 
		System.out.println();
		System.out.println("average : " + results[0]);
		System.out.println("min : " + (int) results[1]);
		System.out.println("max : " + (int) results[2]);
		sc.close();
	}
}
