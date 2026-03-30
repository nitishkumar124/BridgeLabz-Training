package week3.factory_robot_hazard_analyzer;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Arm Precision(0.0 - 1.0): ");
		double armPrecision = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter Work Density(1 - 20): ");
		int workDensity = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Machinery State (Worn/Faulty/Critical): ");
		String machineryState = sc.nextLine();

		try {
			RobotHazardAuditor auditor = new RobotHazardAuditor();
			System.out.println("Robot Hazard Risk Score: "
					+ auditor.calculateHazardRisk(armPrecision, workDensity, machineryState));
		} catch (RobotSafetyException e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}
}
