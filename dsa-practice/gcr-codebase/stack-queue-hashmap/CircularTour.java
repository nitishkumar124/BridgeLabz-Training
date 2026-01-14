package stack_queue_hashmap;

import java.util.*;

public class CircularTour {

	static int findStartingPump(PetrolPump[] pumps) {
		int n = pumps.length;
		Queue<Integer> queue = new LinkedList<>();
		int totalSurplus = 0;
		int currentSurplus = 0;
		int startIndex = 0;

		for (int i = 0; i < n; i++) {
			int petrol = pumps[i].petrol;
			int distance = pumps[i].distanceToNext;
			currentSurplus += petrol - distance;
			totalSurplus += petrol - distance;
			queue.offer(i);

			while (currentSurplus < 0 && !queue.isEmpty()) {
				int removedIndex = queue.poll();
				currentSurplus -= pumps[removedIndex].petrol - pumps[removedIndex].distanceToNext;
				startIndex = (removedIndex + 1) % n;
			}
		}

		return totalSurplus >= 0 ? startIndex : -1;
	}

	public static void main(String[] args) {
		PetrolPump[] pumps = { new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3) };

		int startIndex = findStartingPump(pumps);
		if (startIndex != -1) {
			System.out.println("Starting pump index: " + startIndex);
		} else {
			System.out.println("No valid starting pump found.");
		}
	}
}

class PetrolPump {
	int petrol;
	int distanceToNext;

	public PetrolPump(int petrol, int distanceToNext) {
		this.petrol = petrol;
		this.distanceToNext = distanceToNext;
	}
}
