package level2;

import java.util.*;

public class EmployeeBonus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[][] arr = new double[10][2]; // [0] -> salary, [1] -> yearOfService
		double[][] newArr = new double[10][2]; // [0] -> newSalary, [1] -> bonus
		double totalBonus = 0.0;
		double oldSalaryTotal = 0.0;
		double newSalaryTotal = 0.0;

		for (int i = 0; i < 10; i++) {
			int k = i + 1;
			while (true) {
				System.out.print("enter the salary for employee " + k + " : ");
				double salary = sc.nextDouble();
				if (salary > 0) {
					arr[i][0] = salary;
					break;
				} else
					System.out.println("invalid input.");
			}
			while (true) {
				System.out.print("enter the year of service for employee " + k + " : ");
				double yearOfService = sc.nextDouble();
				if (yearOfService > 0) {
					arr[i][1] = yearOfService;
					break;
				} else
					System.out.println("invalid input.");
			}
		}

		for (int i = 0; i < arr.length; i++) {
			double salary = arr[i][0];
			double yearOfService = arr[i][1];
			double bonus = 0.0;

			oldSalaryTotal += salary;

			if (yearOfService >= 5) {
				bonus = salary * 0.05;
			} else
				bonus = salary * 0.02;

			totalBonus += bonus;
			newSalaryTotal += bonus + salary;

			newArr[i][0] = bonus + salary;
			newArr[i][1] = bonus;
		}

		System.out.println("Total old salary : " + oldSalaryTotal);
		System.out.println("Total new salary : " + newSalaryTotal);
		System.out.println("Total bonus : " + totalBonus);

		sc.close();
	}
}
