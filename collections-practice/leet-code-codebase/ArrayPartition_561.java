package week4.part2;
import java.util.*;
public class ArrayPartition_561 {

	public static void main(String[] args) {
		int[] nums = { 1, 4, 3, 2 };
		System.out.println("The maximum sum of min(ai, bi) is: " + arrayPairSum(nums));
	}
	
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		return sum;
	}
}

