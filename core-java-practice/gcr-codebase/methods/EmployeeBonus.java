package level3;

import java.util.*;

public class EmployeeBonus {

	static double[][] getEmployeeData() {
		double[][] arr = new double[10][2];
		for (int i = 0; i < 10; i++) {
			arr[i][0] = (int) (Math.random() * 90000) + 10000; // salary
			arr[i][1] = (int) (Math.random() * 90) + 10; // years of service
		}
		return arr;
	}

	static double[][] calculateBonus(double[][] arr) {
		double[][] newArr = new double[10][2];
		for (int i = 0; i < arr.length; i++) {
			double salary = arr[i][0];
			double yearOfService = arr[i][1];
			double bonus = 0.0;

			if (yearOfService >= 5) {
				bonus = salary * 0.05;
			} else
				bonus = salary * 0.02;

			newArr[i][0] = bonus + salary; // new salary
			newArr[i][1] = bonus; // bonus
		}
		return newArr;
	}

	static double[] calculateTotal(double[][] arr, double[][] newArr) {
		double oldSalarySum = 0;
		for (double[] a : arr)
			oldSalarySum += a[0];
		double newSalarySum = 0;
		double bonusSum = 0;
		for (double[] n : newArr) {
			newSalarySum += n[0];
			bonusSum += n[1];
		}

		return new double[] { oldSalarySum, newSalarySum, bonusSum };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[][] arr = getEmployeeData(); // [0] -> salary, [1] -> years Of service
		double[][] newArr = calculateBonus(arr); // [0] -> new salary, [1] -> bonus
		double[] total = calculateTotal(arr, newArr);
		double oldSalaryTotal = total[0], newSalaryTotal = total[1], totalBonus = total[2];

		System.out.printf("%-12s %-12s %s", "Old Salary", "New Salary", "Bonus");
		System.out.println();
		System.out.printf("%-12.1f %-12.1f %.1f", oldSalaryTotal, newSalaryTotal, totalBonus);

		sc.close();
	}
}
