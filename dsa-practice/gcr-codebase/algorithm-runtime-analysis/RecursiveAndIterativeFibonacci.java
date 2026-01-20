package algorithm_runtime_analysis;

import java.util.*;

public class RecursiveAndIterativeFibonacci {
	public static void main(String[] args) {
		int n = 40;

		System.out.println("Calculating Fibonacci term: " + n);
		System.out.println("------------------------------------------");

		// 1. Iterative Approach
		long start = System.currentTimeMillis();
		long iterativeResult = fibonacciIterative(n);
		long end = System.currentTimeMillis();
		System.out.println("Iterative Result: " + iterativeResult);
		System.out.println("Iterative Time: " + (end - start) + "ms");

		// 2. Recursive Approach
		start = System.currentTimeMillis();
		long recursiveResult = fibonacciRecursive(n);
		end = System.currentTimeMillis();
		System.out.println("Recursive Result: " + recursiveResult);
		System.out.println("Recursive Time: " + (end - start) + "ms");
	}

	public static long fibonacciIterative(int n) {
		if (n <= 1)
			return n;
		long prev = 0, curr = 1;
		for (int i = 2; i <= n; i++) {
			long next = prev + curr;
			prev = curr;
			curr = next;
		}
		return curr;
	}

	public static long fibonacciRecursive(int n) {
		if (n <= 1)
			return n;
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}
}
