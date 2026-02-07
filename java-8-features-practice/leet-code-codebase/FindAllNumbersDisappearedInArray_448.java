package week6;

import java.util.*;

public class FindAllNumbersDisappearedInArray_448 {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println("numbers not appeared in nums: " + findDisappearedNumbers(nums));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int[] hash = new int[nums.length + 1];
		for (int num : nums) {
			hash[num]++;
		}
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i < hash.length; i++)
			if (hash[i] == 0)
				result.add(i);

		return result;
	}
}
