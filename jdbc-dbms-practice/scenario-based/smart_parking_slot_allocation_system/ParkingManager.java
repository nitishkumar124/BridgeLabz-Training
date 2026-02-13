package week9.smart_parking_slot_allocation_system;
import java.util.*;

class ParkingManager {
    private Map<Integer, ParkingSlot> slots = new TreeMap<>();
    private Queue<Vehicle> waitingQueue = new LinkedList<>();

    public ParkingManager(int totalSlots) {
        for (int i = 1; i <= totalSlots; i++) {
            slots.put(i, new ParkingSlot(i));
        }
    }

    public void parkVehicle(Vehicle vehicle) throws NoParkingSlotAvailableException {
        for (ParkingSlot slot : slots.values()) {
            if (slot.isFree()) {
                slot.park(vehicle);
                System.out.println(vehicle.getType() + " parked at slot " + slot.getSlotId());
                return;
            }
        }
        waitingQueue.offer(vehicle);
        throw new NoParkingSlotAvailableException("No slots available. Vehicle added to waiting queue.");
    }

    public void freeSlot(int slotId) {
        ParkingSlot slot = slots.get(slotId);
        slot.free();
        System.out.println("Slot " + slotId + " is now free.");

        if (!waitingQueue.isEmpty()) {
            Vehicle next = waitingQueue.poll();
            slot.park(next);
            System.out.println("Waiting " + next.getType() + " allocated to slot " + slotId);
        }
    }
}
