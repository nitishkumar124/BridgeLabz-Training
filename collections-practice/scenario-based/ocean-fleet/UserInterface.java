package week4_collections.ocean_fleet;

import java.util.*;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of vessels to be added: ");
		int n = sc.nextInt();
		sc.nextLine();

		VesselUtil vu = new VesselUtil();

		while (n-- > 0) {
			System.out.println("Enter vessel details: ");
			String[] details = sc.nextLine().split(":");
			vu.addVesselPerformance(new Vessel(details[0], details[1], Double.parseDouble(details[2]), details[3]));
			System.out.println("Vessel added successfully.");
		}

		System.out.println("Enter the Vessel Id to check speed: ");
		String vesselId = sc.nextLine();
		Vessel v = vu.getVesselById(vesselId);
		if (v != null) {
			System.out.println(v);
		} else {
			System.out.println("Vessel Id " + vesselId + " not found.");
		}

		List<Vessel> highPerformers = vu.getHighPerformanceVessels();
		System.out.println("High performance vessels are");
		for (Vessel hp : highPerformers) {
			System.out.println(hp);
		}

		sc.close();
	}
}
