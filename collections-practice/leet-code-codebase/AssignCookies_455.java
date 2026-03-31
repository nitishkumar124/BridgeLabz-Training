package week4.part2;

import java.util.*;

public class AssignCookies_455 {

	public static void main(String[] args) {
		int[] g = { 1, 2, 3 };
		int[] s = { 1, 2 };
		System.out.println("number of content children: " + findContentChildren(g, s));
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int i = 0;
		int j = 0;
		while (i < g.length && j < s.length) {
			if (s[j] >= g[i]) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		return i;
	}
}
