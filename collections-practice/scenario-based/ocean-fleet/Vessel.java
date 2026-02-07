package week4_collections.ocean_fleet;

import java.util.*;

public class Vessel {
	private String vesselId;
	private String vesselName;
	private double averageSpeed;
	private String vesselType;

	public Vessel() {
	};

	public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.averageSpeed = averageSpeed;
		this.vesselType = vesselType;
	}

	public String getVesselId() {
		return vesselId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public String getVesselType() {
		return vesselType;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	@Override
	public String toString() {
		return vesselId + " | " + vesselName + " | " + vesselType + " | " + averageSpeed + " knots";
	}
}
