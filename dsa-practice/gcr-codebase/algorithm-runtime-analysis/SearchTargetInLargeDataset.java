package algorithm_runtime_analysis;

public class SearchTargetInLargeDataset {
	public static void main(String[] args) {
		int[] sizes = { 1000, 100000, 10000000 };

		for (int n : sizes) {
			System.out.println("------------------------------------------");
			System.out.println("Dataset Size: " + n);
			comparePerformance(n);
		}
	}

	public static void comparePerformance(int size) {
		int[] data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = i; // Creating a sorted array
		}

		// Target: last element
		int target = size - 1;

		// 1. Linear Search
		long startTime = System.nanoTime();
		linearSearch(data, target);
		long endTime = System.nanoTime();
		double linearTimeMs = (endTime - startTime) / 1_000_000.0;

		// 2. Binary Search
		startTime = System.nanoTime();
		binarySearch(data, target);
		endTime = System.nanoTime();
		double binaryTimeMs = (endTime - startTime) / 1_000_000.0;

		System.out.printf("Linear Search Time: %.4f ms\n", linearTimeMs);
		System.out.printf("Binary Search Time: %.4f ms\n", binaryTimeMs);
	}

	public static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target)
				return i;
		}
		return -1;
	}

	public static int binarySearch(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;
			if (arr[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}