package week3;

import java.util.*;

public class RemoveElement_27 {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 3, 3 };
		int val = 3;
		System.out.println("Elements left after removal: " + removeElement(nums, val)); // Output: 2
	}

	static public int removeElement(int[] nums, int val) {
		int left = 0, right = nums.length - 1;
		int count = 0;

		while (left <= right) {
			if (nums[right] == val) {
				right--;
				continue;
			}
			if (nums[left] == val) {
				nums[left] = nums[right];
				right--;
			}
			left++;
			count++;
		}
		return count;

	}
}
