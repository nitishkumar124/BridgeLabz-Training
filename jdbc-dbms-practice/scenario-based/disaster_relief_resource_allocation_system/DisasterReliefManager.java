package week9.disaster_relief_resource_allocation_system;

import java.util.*;

class DisasterReliefManager {

	private Map<String, ReliefCenter> centers = new HashMap<>();
	private Queue<AreaRequest> requestQueue = new LinkedList<>();

	public void addCenter(ReliefCenter center) {
		centers.put(center.getName(), center);
	}

	public void addRequest(AreaRequest request) {
		requestQueue.offer(request); // FIFO
	}

	public void processRequests() {
		while (!requestQueue.isEmpty()) {
			AreaRequest request = requestQueue.poll();
			System.out.println("\nProcessing request for area: " + request.getAreaName());

			for (Map.Entry<String, Integer> entry : request.getRequestedItems().entrySet()) {
				String item = entry.getKey();
				int qty = entry.getValue();

				boolean allocated = false;

				for (ReliefCenter center : centers.values()) {
					if (center.hasSufficient(item, qty)) {
						center.allocate(item, qty);
						System.out.println("Allocated " + qty + " " + item + " from " + center.getName());
						allocated = true;
						break;
					}
				}

				if (!allocated) {
					throw new InsufficientResourceException(
							"Insufficient " + item + " for area " + request.getAreaName());
				}
			}
		}
	}

	public void generateReport() {
		System.out.println("\nAllocation Report:");
		centers.values().forEach(center -> {
			System.out.println(center.getName() + " stock: " + center.getResources());
		});
	}
}
