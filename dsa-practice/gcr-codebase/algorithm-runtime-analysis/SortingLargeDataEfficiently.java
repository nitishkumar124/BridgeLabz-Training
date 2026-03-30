package algorithm_runtime_analysis;

import java.util.*;

public class SortingLargeDataEfficiently {
	public static void main(String[] args) {
		int[] sizes = { 1000, 10000, 50000 };

		for (int n : sizes) {
			System.out.println("\n--- Dataset Size: " + n + " ---");
			int[] original = generateRandomArray(n);

			// 1. Bubble Sort 
			int[] bubbleArr = Arrays.copyOf(original, original.length);
			long start = System.currentTimeMillis();
			bubbleSort(bubbleArr);
			System.out.println("Bubble Sort (O(N^2)): " + (System.currentTimeMillis() - start) + "ms");

			// 2. Merge Sort 
			int[] mergeArr = Arrays.copyOf(original, original.length);
			start = System.currentTimeMillis();
			mergeSort(mergeArr, 0, mergeArr.length - 1);
			System.out.println("Merge Sort (O(N log N)): " + (System.currentTimeMillis() - start) + "ms");

			// 3. Quick Sort 
			int[] quickArr = Arrays.copyOf(original, original.length);
			start = System.currentTimeMillis();
			quickSort(quickArr, 0, quickArr.length - 1);
			System.out.println("Quick Sort (O(N log N)): " + (System.currentTimeMillis() - start) + "ms");
		}
	}

	public static int[] generateRandomArray(int size) {
		Random rand = new Random();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = rand.nextInt(size * 10);
		return arr;
	}

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j])
				arr[k++] = L[i++];
			else
				arr[k++] = R[j++];
		}
		while (i < n1)
			arr[k++] = L[i++];
		while (j < n2)
			arr[k++] = R[j++];
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
