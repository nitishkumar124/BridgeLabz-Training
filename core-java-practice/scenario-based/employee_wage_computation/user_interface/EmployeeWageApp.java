package week1.employee_wage_computation.user_interface;

import java.util.Scanner;

import week1.employee_wage_computation.controller.EmpWageController;
import week1.employee_wage_computation.service.EmpWageBuilder;
import week1.employee_wage_computation.service.IEmpWageBuilder;

public class EmployeeWageApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		IEmpWageBuilder empWageBuilder = new EmpWageBuilder();
		EmpWageController controller = new EmpWageController(empWageBuilder);

		int choice;

		do {
			System.out.println("\n========= Employee Wage Computation =========");
			System.out.println("1. Add Company");
			System.out.println("2. Compute Wages for All Companies");
			System.out.println("3. Get Total Wage by Company");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter Company Name: ");
				String name = sc.next();

				System.out.print("Enter Wage per Hour: ");
				int wage = sc.nextInt();

				System.out.print("Enter Working Days per Month: ");
				int days = sc.nextInt();

				System.out.print("Enter Max Hours per Month: ");
				int maxHrs = sc.nextInt();

				controller.addCompany(name, wage, days, maxHrs);
				System.out.println("Company added successfully!");
				break;

			case 2:
				controller.processWages();
				System.out.println("Wages computed successfully!");
				break;

			case 3:
				System.out.print("Enter Company Name: ");
				String company = sc.next();
				controller.queryCompanyWage(company);
				break;

			case 4:
				System.out.println("Exiting... Thank you!");
				break;

			default:
				System.out.println("Invalid choice! Try again.");
			}

		} while (choice != 4);

		sc.close();
	}
}
