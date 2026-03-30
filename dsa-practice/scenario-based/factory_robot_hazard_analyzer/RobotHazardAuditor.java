package week3.factory_robot_hazard_analyzer;

import java.util.*;

public class RobotHazardAuditor {

	public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState)
			throws RobotSafetyException {

		if (armPrecision < 0.0 || armPrecision > 1.0)
			throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");

		if (workerDensity < 1 || workerDensity > 20)
			throw new RobotSafetyException("Error: Worker density must be 1-20");

		if (!machineryState.matches("Worn|Faulty|Critical"))
			throw new RobotSafetyException("Error: Unsupported machinery state");

		double machineRiskFactor = 0;
		switch (machineryState) {
		case "Worn":
			machineRiskFactor = 1.3;
			break;
		case "Faulty":
			machineRiskFactor = 2.0;
			break;
		case "Critical":
			machineRiskFactor = 3.0;
			break;
		}

		return ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
	}
}
