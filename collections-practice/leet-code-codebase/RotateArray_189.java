package week4.part2;

public class RotateArray_189 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Original array:");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		int k = 3;
		rotate(nums, k);
		System.out.println("Rotated array "+ "after "+ k + " rotations:");
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		int[] rotated = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int pos = (i + k) % nums.length;
			rotated[pos] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = rotated[i];
		}
	}
}
