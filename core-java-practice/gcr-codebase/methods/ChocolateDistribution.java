package level1;

import java.util.*;

public class ChocolateDistribution {

	public static int[] findRemainderAndQuotient(int chocolates, int children) {
		return new int[] { (chocolates / children), (chocolates % children) };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of chocolates : ");
		int chocolates = sc.nextInt();
		System.out.print("Enter number of children : ");
		int children = sc.nextInt();

		int[] result = findRemainderAndQuotient(chocolates, children);
		int share = result[0], left = result[1];
		System.out.println("chocolate for each child : " + share);
		System.out.println("chocolates left: " + left);
		
		
		sc.close();
	}
}
