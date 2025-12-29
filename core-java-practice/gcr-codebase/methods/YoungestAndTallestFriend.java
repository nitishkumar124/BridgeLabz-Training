package level2;

import java.util.*;

public class YoungestAndTallestFriend {
//	Create a program to find the youngest friends among 3 Amar, Akbar and Anthony based on their ages and tallest among the friends based on their heights and display it
//	Hint => 
//	Take user input for age and height for the 3 friends and store it in two arrays each to store the values for age and height of the 3 friends
//	Write a Method to find the youngest of the 3 friends
//	Write a Method to find the tallest of the 3 friends

	static int findYoungestFriend(int[] ages) {
		int minIndex = 0;
		int minAge = ages[0];
		for (int i = 1; i < 3; i++) {
			if (ages[i] < minAge) {
				minAge = ages[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	static int findTallestFriend(int[] heights) {
		int maxIndex = 0;
		int maxHeight = heights[0];
		for (int i = 1; i < 3; i++) {
			if (maxHeight < heights[i]) {
				maxHeight = heights[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] ages = new int[3];
		int[] heights = new int[3];
		String[] friends = { "Amar", "Akbar", "Anthony" };

		for (int i = 0; i < 3; i++) {
			System.out.print("enter the age of " + friends[i] + " : ");
			ages[i] = sc.nextInt();
			System.out.print("enter the height of " + friends[i] + " : ");
			heights[i] = sc.nextInt();
		}

		String tallest = friends[findTallestFriend(heights)];
		String youngest = friends[findYoungestFriend(ages)];
		
		System.out.println("Tallest : " + tallest);
		System.out.println("Youngest : " + youngest);

		sc.close();
	}
}
