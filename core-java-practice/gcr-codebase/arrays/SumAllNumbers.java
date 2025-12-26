package level1;

import java.util.*;

public class SumAllNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		double total = 0.0;
		double[] arr = new double[10];
		
		while (true) {
			if (i == 10) break;
			System.out.print("enter number " + (i + 1) + " : ");
			double n = sc.nextDouble();
			if (n <= 0.0) break;
			arr[i] = n;
			i++;
		}
		
		for (int j = 0; j < arr.length; j++) {
			total += arr[j];
		}
		System.out.println("Total : " + total);

		sc.close();
	}
}
