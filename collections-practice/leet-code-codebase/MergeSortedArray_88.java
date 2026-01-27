package week4;

import java.util.*;

public class MergeSortedArray_88 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m + n - 1;
		m--;
		n--;
		while (n >= 0) {
			if (m >= 0 && nums1[m] > nums2[n]) {
				nums1[i] = nums1[m];
				m--;
			} else {
				nums1[i] = nums2[n];
				n--;
			}
			i--;
		}
	}
}
