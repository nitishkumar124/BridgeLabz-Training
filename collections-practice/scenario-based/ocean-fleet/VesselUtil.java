package week4_collections.ocean_fleet;

import java.util.*;

public class VesselUtil {
	private List<Vessel> vesselList = new ArrayList<>();

	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}

	public Vessel getVesselById(String vesselId) {
		for (Vessel vessel : vesselList) {
			if (vessel.getVesselId().equals(vesselId))
				return vessel;
		}
		return null;
	}

	public List<Vessel> getHighPerformanceVessels() {
		List<Vessel> highPerformers = new ArrayList<Vessel>();
		double highestAvgSpeed = 0;
		for (Vessel v : vesselList) {
			highestAvgSpeed = Math.max(v.getAverageSpeed(), highestAvgSpeed);
		}

		for (Vessel v : vesselList) {
			if (v.getAverageSpeed() == highestAvgSpeed)
				highPerformers.add(v);
		}
		return highPerformers;
	}
}
