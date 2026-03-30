package level1;

import java.util.*;

public class MeanHeight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] arr = new double[11];
		double sum = 0;

		for (int i = 0; i < 11; i++) {
			System.out.print("enter height of player " + (i + 1) + " : ");
			arr[i] = sc.nextDouble();
		}
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double avgHeight = sum / 11;
		System.out.println("The average height of 11 players is : " + avgHeight);
		sc.close();
	}
}
