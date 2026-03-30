package challenge_problem_1;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		int[] arr = {3, 4, -1, 1};
		int target = 4;
		
		// Linear Search Part
		int missing = LinearSearch.firstMissingPositive(arr);
		System.out.println("First Missing Positive: " + missing);
		
		// Binary Search Part
		Arrays.sort(arr);
		int index = BinarySearch.binarySearch(arr, target);
		
		if (index != -1) {
			System.out.println("Element found at index: " + index);
		} else {
			System.out.println("Element not found");
		}
	}
}
