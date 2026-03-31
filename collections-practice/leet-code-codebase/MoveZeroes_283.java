package week4.part2;

public class MoveZeroes_283 {
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	public static void moveZeroes(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < nums.length) {
			if (nums[start] == 0) {
				int i = start;
				while (i < nums.length - 1 && nums[i] == 0)
					i++;
				nums[start] = nums[i];
				nums[i] = 0;
			}
			start++;
		}
	}
}