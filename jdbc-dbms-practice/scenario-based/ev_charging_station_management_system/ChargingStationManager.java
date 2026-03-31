package week9.ev_charging_station_management_system;
import java.util.*;

public class ChargingStationManager {

    private Map<Integer, ChargingSlot> slots = new HashMap<>();
    private Queue<Vehicle> waitingQueue = new LinkedList<>();

    public ChargingStationManager(int numberOfSlots) {
        for (int i = 1; i <= numberOfSlots; i++) {
            slots.put(i, new ChargingSlot());
        }
    }

    public void bookSlot(Vehicle v) throws NoChargingSlotAvailableException {
        for (ChargingSlot slot : slots.values()) {
            if (!slot.isOccupied()) {
                slot.occupy();
                System.out.println("Slot allocated to: " + v.getVehicleNumber());
                return;
            }
        }
        throw new NoChargingSlotAvailableException("No charging slot available for " + v.getVehicleNumber());
    }

    public double generateBill(double units, PricingStrategy strategy) {
        return strategy.calculatePrice(units);
    }
}
