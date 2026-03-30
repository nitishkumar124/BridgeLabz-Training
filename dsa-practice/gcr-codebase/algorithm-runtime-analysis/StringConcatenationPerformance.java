package algorithm_runtime_analysis;

import java.util.*;

public class StringConcatenationPerformance {
	public static void main(String[] args) {
		int n = 100000;

		// 1. String Concatenation
		long start = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < n; i++) {
			s += "a";
		}
		long end = System.currentTimeMillis();
		System.out.println("String for " + n + " iterations: " + (end - start) + "ms");

		// 2. StringBuilder
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder for " + n + " iterations: " + (end - start) + "ms");

		// 3. StringBuffer
		start = System.currentTimeMillis();
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sbf.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuffer for " + n + " iterations: " + (end - start) + "ms");
	}
}
