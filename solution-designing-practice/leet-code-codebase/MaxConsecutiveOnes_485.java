package week7;

public class MaxConsecutiveOnes_485 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		System.out.println("Max consecutive ones: " + findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0, temp = 0;
		for (int n : nums) {
			if (n == 1)
				temp++;
			else
				temp = 0;
			count = Math.max(count, temp);
		}
		return count;
	}
}
