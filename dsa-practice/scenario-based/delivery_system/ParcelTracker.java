package week3.delivery_system;

public class ParcelTracker {
	private Stage head;
	private String parcelID;

	public ParcelTracker(String parcelID, String initialStage) {
		this.parcelID = parcelID;
		this.head = new Stage(initialStage);
	}

	public void addFinalStage(String name) {
		Stage newStage = new Stage(name);
		Stage current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newStage;
	}

	public void addCheckpointAfter(String existingStageName, String newStageName) {
		Stage current = head;
		while (current != null && !current.name.equals(existingStageName)) {
			current = current.next;
		}

		if (current != null) {
			Stage newCheckpoint = new Stage(newStageName);
			newCheckpoint.next = current.next;
			current.next = newCheckpoint;
			System.out.println("Inserted checkpoint: " + newStageName + " after " + existingStageName);
		} else {
			System.out.println("⚠️ Stage '" + existingStageName + "' not found. Cannot insert checkpoint.");
		}
	}

	public void trackParcel() {
		System.out.println("\n--- Tracking for Parcel: " + parcelID + " ---");
		Stage current = head;

		if (current == null) {
			System.out.println("❌ Error: Parcel record is empty/lost.");
			return;
		}

		while (current != null) {
			System.out.print(current.name);
			if (current.next != null) {
				System.out.print(" ➔ ");
			} else if (!current.name.equalsIgnoreCase("Delivered")) {

				System.out.print(" ➔ [MISSING/LOST AT SEA]");
			}
			current = current.next;
		}
		System.out.println("\n----------------------------------------");
	}
}
