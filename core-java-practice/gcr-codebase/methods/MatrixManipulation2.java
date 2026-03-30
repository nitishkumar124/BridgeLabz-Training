package level3;

import java.util.*;

public class MatrixManipulation2 {

	static int[][] createMatrix(int row, int col) {
		int[][] matrix = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = (int) (Math.random() * 9) + 1;
			}
		}
		return matrix;
	}

	static int[][] matrixAddition(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			System.out.println("Matrices Dimensions must be same for addition.");
			return null;
		}
		int[][] sum = new int[m1.length][m1[0].length];

		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				sum[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return sum;
	}

	static int[][] matrixSubtraction(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			System.out.println("Matrices Dimensions must be same for subtraction.");
			return null;
		}
		int[][] difference = new int[m1.length][m1[0].length];

		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				difference[i][j] = m1[i][j] - m2[i][j];
			}
		}
		return difference;
	}

	static int[][] matrixProduct(int[][] m1, int[][] m2) {
		if (m1[0].length != m2.length) {
			System.out.println("Matrix 1 columns must be equal to Matrix 2 rows for product.");
			return null;
		}
		int[][] product = new int[m1[0].length][m2.length];

		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					product[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}

		return product;
	}

	static void print(int[][] matrix) {
		System.out.println();
		for (int[] row : matrix) {
			for (int num : row) {
				System.out.printf("%-4d", num);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] d = new int[2][2];

		for (int i = 0; i < 2; i++) {
			System.out.println("Matrix " + (i + 1) + " : ");
			System.out.print("Enter the number of rows : ");
			d[i][0] = sc.nextInt();
			System.out.print("Enter the number of columns : ");
			d[i][1] = sc.nextInt();
			System.out.println();
		}

		int[][] m1 = createMatrix(d[0][0], d[0][1]);
		int[][] m2 = createMatrix(d[1][0], d[1][1]);
		int[][] product = matrixProduct(m1, m2);
		print(m1);
		print(m2);
		print(product);

		sc.close();
	}
}
