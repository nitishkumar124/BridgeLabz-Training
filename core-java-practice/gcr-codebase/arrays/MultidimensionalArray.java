package level1;

import java.util.*;

public class MultidimensionalArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("enter the rows : ");
		int rows = sc.nextInt();
		System.out.print("enter the columns : ");
		int cols = sc.nextInt();

		int[][] twoDArray = new int[rows][cols];
		int[] arr = new int[rows * cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("enter a value for row " + (i + 1) + " and column " + (j + 1) + " : ");
				twoDArray[i][j] = sc.nextInt();

			}
		}
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[index++] = twoDArray[i][j];
			}
		}
		System.out.print("Result using the single dimension array : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		

		sc.close();
	}
}
