package stack_queue_hashmap;

import java.util.*;

public class SubarrayZeroSum {

	static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> sumIndicesMap = new HashMap<>();
		int cumulativeSum = 0;

		sumIndicesMap.put(0, new ArrayList<>(Arrays.asList(-1)));

		for (int i = 0; i < arr.length; i++) {
			cumulativeSum += arr[i];

			if (sumIndicesMap.containsKey(cumulativeSum)) {
				List<Integer> indices = sumIndicesMap.get(cumulativeSum);
				for (int startIndex : indices) {
					List<Integer> subarray = new ArrayList<>();
					for (int j = startIndex + 1; j <= i; j++) {
						subarray.add(arr[j]);
					}
					result.add(subarray);
				}
			}

			sumIndicesMap.putIfAbsent(cumulativeSum, new ArrayList<>());
			sumIndicesMap.get(cumulativeSum).add(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, -3, 1, 6, -4, -2, 2 };
		List<List<Integer>> result = findZeroSumSubarrays(arr);
		System.out.println("Zero-sum subarrays: " + result);
	}
}
