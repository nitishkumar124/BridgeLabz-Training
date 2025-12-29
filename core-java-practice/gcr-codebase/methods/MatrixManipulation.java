package level3;

import java.util.*;

public class MatrixManipulation {

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
//		int[][] m2 = createMatrix(d[1][0], d[1][1]);
//		int[][] product = matrixProduct(m1, m2);
		int dt = matrixDeterminant3x3(m1);
//		print(m1);
		print(m1);
		System.out.println(dt);
//		print(m2);
//		print(product);

		sc.close();
	}

	static int[][] createMatrix(int row, int col) {
		int[][] matrix = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = (int) (Math.random() * 9) + 1;
			}
		}
		return matrix;
	}

	static int[][] matrixTranspose(int[][] m) {
		int[][] t = new int[m[0].length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				t[j][i] = m[i][j];
			}
		}
		return t;
	}

	static int matrixDeterminant2x2(int[][] m) {
		if (m.length != 2 || m[0].length != 2) {
			System.out.println("Use a 2x2 matrix only.");
			return -1;
		}
		return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
	}

	static int matrixDeterminant3x3(int[][] m) {
		if (m.length != 3 || m[0].length != 3) {
			System.out.println("Use a 3x3 matrix only.");
			return -1;
		}
		int d = (m[0][0] * ((m[1][1] * m[2][2]) - (m[2][1] * m[1][2])))
				- (m[0][1] * ((m[1][0] * m[2][2]) - (m[2][0] * m[1][2])))
				+ (m[0][2] * ((m[1][0] * m[2][1]) - (m[2][0] * m[1][1])));
		return d;
	}

	static double[][] matrixInverse2x2(int[][] m) {
		double[][] inverse = { { m[1][1], -1 * m[0][1] }, { -1 * m[1][0], m[0][0] } };
		double dt = 1.0 / matrixDeterminant2x2(m);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				inverse[i][j] /= dt;
			}
		}
		return inverse;
	}
	
	public static double[][] matrixInverse3x3(double[][] m) {
        double det = m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                   - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                   + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);

        if (det == 0) return null;

        double[][] inv = new double[3][3];
        double invDet = 1.0 / det;

        inv[0][0] = (m[1][1] * m[2][2] - m[1][2] * m[2][1]) * invDet;
        inv[0][1] = (m[0][2] * m[2][1] - m[0][1] * m[2][2]) * invDet;
        inv[0][2] = (m[0][1] * m[1][2] - m[0][2] * m[1][1]) * invDet;

        inv[1][0] = (m[1][2] * m[2][0] - m[1][0] * m[2][2]) * invDet;
        inv[1][1] = (m[0][0] * m[2][2] - m[0][2] * m[2][0]) * invDet;
        inv[1][2] = (m[0][2] * m[1][0] - m[0][0] * m[1][2]) * invDet;

        inv[2][0] = (m[1][0] * m[2][1] - m[1][1] * m[2][0]) * invDet;
        inv[2][1] = (m[0][1] * m[2][0] - m[0][0] * m[2][1]) * invDet;
        inv[2][2] = (m[0][0] * m[1][1] - m[0][1] * m[1][0]) * invDet;

        return inv;
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

}
