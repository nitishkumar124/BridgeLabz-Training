package week4;

import java.util.*;

public class ContainerWithMostWater_11 {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	static public int maxArea(int[] height) {
		int most = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			int temp = Math.min(height[left], height[right]) * (right - left);
			most = Math.max(temp, most);
			if (height[left] > height[right])
				right--;
			else
				left++;
		}
		return most;
	}
}
