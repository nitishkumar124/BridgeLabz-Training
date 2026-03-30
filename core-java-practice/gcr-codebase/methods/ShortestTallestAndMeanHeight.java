package level3;

import java.util.*;

public class ShortestTallestAndMeanHeight {

	static double findMeanHeight(int[] heights) {
		int sum = 0;
		for (int h : heights)
			sum += h;
		return sum * 1.0 / heights.length;
	}

	static double findShortestHeight(int[] heights) {
		int min = heights[0];
		for (int i = 1; i < heights.length; i++) {
			min = Math.min(min, heights[i]);
		}
		return min;
	}

	static double findTallestHeight(int[] heights) {
		int max = heights[0];
		for (int i = 1; i < heights.length; i++) {
			max = Math.max(max, heights[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] heights = new int[3];
		for (int i = 0; i < 3;) {
			int h = (int) (Math.random() * 900) + 100;
			if (h <= 250 && h >= 150) {
				heights[i++] = h;
			}
		}

		for (int h : heights) System.err.println(h);

		System.out.println("Mean Height : " + findMeanHeight(heights));
		System.out.println("Shortest Height : " + findShortestHeight(heights));
		System.out.println("Tallest Height : " + findTallestHeight(heights));

		sc.close();
	}
}
