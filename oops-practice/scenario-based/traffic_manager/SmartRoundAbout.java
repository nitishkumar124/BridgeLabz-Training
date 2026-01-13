package week2.traffic_manager;

import java.util.*;

class SmartRoundabout {
    private Vehicle head = null;
    private Vehicle tail = null;
    private Queue<String> entryQueue = new LinkedList<>();
    private final int MAX_QUEUE_SIZE = 5;
    private int vehicleCount = 0;

    // Requirement: Queue Overflow/Underflow Handling
    public void approachRoundabout(String plate) {
        if (entryQueue.size() >= MAX_QUEUE_SIZE) {
            System.out.println("Alert: Entry Queue Full! Vehicle " + plate + " must wait outside.");
        } else {
            entryQueue.add(plate);
            System.out.println("Vehicle " + plate + " is waiting in queue.");
        }
    }

    // Requirement: Add cars in a circular path
    public void enterRoundabout() {
        if (entryQueue.isEmpty()) {
            System.out.println("Entry Queue is empty. No vehicles to enter.");
            return;
        }

        String plate = entryQueue.poll();
        Vehicle newVehicle = new Vehicle(plate);

        if (head == null) {
            head = newVehicle;
            tail = newVehicle;
            newVehicle.next = head; // Point to itself to make it circular
        } else {
            tail.next = newVehicle;
            tail = newVehicle;
            tail.next = head; // Maintain circularity
        }
        vehicleCount++;
        System.out.println("Vehicle " + plate + " entered the roundabout.");
    }

    // Requirement: Remove cars from circular path
    public void exitRoundabout(String plate) {
        if (head == null) return;

        Vehicle curr = head;
        Vehicle prev = tail;

        do {
            if (curr.licensePlate.equals(plate)) {
                if (curr == head && curr == tail) { // Only one vehicle
                    head = null; tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                }
                vehicleCount--;
                System.out.println("Vehicle " + plate + " has exited the roundabout.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Vehicle " + plate + " not found in the roundabout.");
    }

    // Requirement: Print state of roundabout
    public void displayStatus() {
        System.out.print("\n--- ROUNDABOUT STATE --- \nFlow: ");
        if (head == null) {
            System.out.print("Empty");
        } else {
            Vehicle temp = head;
            do {
                System.out.print("[" + temp.licensePlate + "] -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.print("(Back to " + head.licensePlate + ")");
        }
        System.out.println("\nWaiting in Queue: " + entryQueue);
        System.out.println("------------------------\n");
    }
}