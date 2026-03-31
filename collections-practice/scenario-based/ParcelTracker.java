package week4_collections;

import java.util.*;

class Stage {
	String description;
	Stage next;

	Stage(String description) {
		this.description = description;
		this.next = null;
	}
}

public class ParcelTracker {
	private Stage head;

	public void addInitialStage(String description) {
		Stage newStage = new Stage(description);
		if (head == null) {
			head = newStage;
			return;
		}
		Stage temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newStage;
	}

	public void addCheckpointAfter(String existingStageName, String newStageName) {
		Stage temp = head;
		while (temp != null && !temp.description.equals(existingStageName)) {
			temp = temp.next;
		}

		if (temp != null) {
			Stage newCheckpoint = new Stage(newStageName);
			newCheckpoint.next = temp.next;
			temp.next = newCheckpoint;
			System.out.println("Added checkpoint: " + newStageName + " after " + existingStageName);
		} else {
			System.out.println("Stage " + existingStageName + " not found!");
		}
	}

	public void trackParcel() {
		if (head == null) {
			System.out.println("Error: Parcel record does not exist (Lost/Missing).");
			return;
		}

		System.out.println("\n--- Tracking Parcel Progress ---");
		Stage current = head;
		while (current != null) {
			System.out.print("[" + current.description + "]");
			if (current.next != null) {
				System.out.print(" -> ");
			}
			current = current.next;
		}
		System.out.println("\n-------------------------------");
	}

	public static void main(String[] args) {
		ParcelTracker tracker = new ParcelTracker();

		tracker.addInitialStage("Packed");
		tracker.addInitialStage("Shipped");
		tracker.addInitialStage("In Transit");
		tracker.addInitialStage("Delivered");

		tracker.trackParcel();

		tracker.addCheckpointAfter("In Transit", "Arrived at Local Hub");

		tracker.trackParcel();
	}
}