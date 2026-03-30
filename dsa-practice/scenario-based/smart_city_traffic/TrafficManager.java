package week3.smart_city_traffic;

import java.util.LinkedList;
import java.util.Queue;

public class TrafficManager {
	private Queue<Vehicle> waitingQueue;
	private Vehicle tail = null; 
	private int roundaboutCount = 0;
	private final int QUEUE_CAPACITY = 5;
	private final int ROUNDABOUT_CAPACITY = 8;

	public TrafficManager() {
		this.waitingQueue = new LinkedList<>();
	}

	public void joinWaitingQueue(String plate) {
		if (waitingQueue.size() >= QUEUE_CAPACITY) {
			System.out.println("Queue Overflow: Waiting area is full for " + plate);
			return;
		}
		waitingQueue.add(new Vehicle(plate));
		System.out.println(plate + " joined the waiting queue.");
	}

	public void enterRoundabout() {
		if (waitingQueue.isEmpty()) {
			System.out.println("Queue Underflow: No vehicles waiting to enter.");
			return;
		}
		if (roundaboutCount >= ROUNDABOUT_CAPACITY) {
			System.out.println("Roundabout Full: " + waitingQueue.peek().licensePlate + " must wait.");
			return;
		}

		Vehicle newVehicle = waitingQueue.poll();

		if (tail == null) {
			tail = newVehicle;
			tail.next = tail;
		} else {
			newVehicle.next = tail.next;
			tail.next = newVehicle;
			tail = newVehicle;
		}
		roundaboutCount++;
		System.out.println(newVehicle.licensePlate + " entered the roundabout.");
	}

	public void exitRoundabout(String plate) {
		if (tail == null) {
			System.out.println("Empty Roundabout: Nothing to remove.");
			return;
		}

		Vehicle current = tail.next;
		Vehicle prev = tail;
		boolean found = false;

		for (int i = 0; i < roundaboutCount; i++) {
			if (current.licensePlate.equals(plate)) {
				found = true;
				break;
			}
			prev = current;
			current = current.next;
		}

		if (found) {
			if (roundaboutCount == 1) {
				tail = null;
			} else {
				prev.next = current.next;
				if (current == tail)
					tail = prev;
			}
			roundaboutCount--;
			System.out.println(plate + " has exited the roundabout.");
		} else {
			System.out.println(plate + " not found in roundabout.");
		}
	}

	public void printState() {
		System.out.println("\n--- Traffic State ---");
		System.out.print("Roundabout: ");
		if (tail == null) {
			System.out.print("Empty");
		} else {
			Vehicle temp = tail.next;
			do {
				System.out.print(temp + " -> ");
				temp = temp.next;
			} while (temp != tail.next);
			System.out.print("(back to start)");
		}
		System.out.println("\nWaiting Queue: " + waitingQueue);
		System.out.println("---------------------\n");
	}
}