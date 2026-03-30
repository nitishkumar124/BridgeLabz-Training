package linear_binary_search;

import java.util.*;

public class CompareStringBufferWithStringBuilderForStringConcatenation {

	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder("");
		StringBuffer s2 = new StringBuffer("");

		int n = 1000000;

		long startTimeS1 = System.nanoTime();
		for (int i = 0; i < n; i++) {
			s1.append("hello");
		}
		long endTimeS1 = System.nanoTime();

		long durationS1 = endTimeS1 - startTimeS1;

		long startTimeS2 = System.nanoTime();
		for (int i = 0; i < n; i++) {
			s2.append("hello");
		}
		long endTimeS2 = System.nanoTime();

		long durationS2 = endTimeS2 - startTimeS2;

		System.out.println("Total time to append in the string builder: " + durationS1);
		System.out.println("Total time to append in the string buffer: " + durationS2);

	}
}
