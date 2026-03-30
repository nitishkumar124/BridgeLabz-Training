package level2;

import java.util.*;

public class YoungestAndTallest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] height = new int[3];
		int[] age = new int[3];
		String youngest = "";
		String tallest = "";
		
		String[] arr = new String[] { "Amar", "Akbar", "Anthony" };
		for (int i = 0; i < age.length; i++) {
			System.out.print("enter height for " + arr[i] + " : ");
			height[i] = sc.nextInt();
			System.out.print("enter age for " + arr[i] + " : ");
			age[i] = sc.nextInt();
		}
		
		int minAge = Integer.MAX_VALUE;
		int maxHeight = 0;
		
		for (int i = 0; i < age.length; i++) {
			if (age[i] < minAge) {
				youngest = arr[i];
				minAge = age[i];
			}
			if (maxHeight < height[i]) {
				tallest = arr[i];
				maxHeight = height[i];
			}
		}
		
		System.out.println("tallest : " + tallest);
		System.out.println("youngest : " + youngest);
		
		sc.close();
	}
}
