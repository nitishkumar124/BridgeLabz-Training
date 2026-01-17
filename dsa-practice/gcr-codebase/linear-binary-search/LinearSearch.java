package challenge_problem_1;

public class LinearSearch {
	public static int firstMissingPositive(int[] arr) {
		int n = arr.length;
		boolean[] present = new boolean[n + 1];
		for (int num : arr) {
			if (num > 0 && num <= n) {
				present[num] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!present[i]) {
				return i;
			}
		}
		return n + 1;
	}
}
