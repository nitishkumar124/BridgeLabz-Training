package algorithm_runtime_analysis;

import java.util.*;

public class DataStructuresForSeachingElements {
	public static void main(String[] args) {
		int size = 100000; 
		int target = 99999; 

		// Setup Data Structures
		int[] array = new int[size];
		HashSet<Integer> hashSet = new HashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();

		for (int i = 0; i < size; i++) {
			array[i] = i;
			hashSet.add(i);
			treeSet.add(i);
		}

		System.out.println("--- Search (Size: " + size + ") ---");

		// 1. Array Search (Linear)
		long start = System.nanoTime();
		boolean foundArray = false;
		for (int n : array) {
			if (n == target) {
				foundArray = true;
				break;
			}
		}
		long end = System.nanoTime();
		System.out.printf("Array Search (O(N)): %.4f ms\n", (end - start) / 1_000_000.0);

		// 2. TreeSet Search (O(log N))
		start = System.nanoTime();
		boolean foundTree = treeSet.contains(target);
		end = System.nanoTime();
		System.out.printf("TreeSet Search (O(log N)): %.4f ms\n", (end - start) / 1_000_000.0);

		// 3. HashSet Search (O(1))
		start = System.nanoTime();
		boolean foundHash = hashSet.contains(target);
		end = System.nanoTime();
		System.out.printf("HashSet Search (O(1)): %.4f ms\n", (end - start) / 1_000_000.0);
	}
}
