package week2.traffic_manager;
public class TrafficManagingSystem {
    public static void main(String[] args) {
        SmartRoundabout cityCircle = new SmartRoundabout();

        // 1. Vehicles arrive at the gate (Queue)
        cityCircle.approachRoundabout("CAR-001");
        cityCircle.approachRoundabout("CAR-002");
        cityCircle.approachRoundabout("CAR-003");

        // 2. Vehicles enter the flow (Circular Linked List)
        cityCircle.enterRoundabout();
        cityCircle.enterRoundabout();

        cityCircle.displayStatus();

        // 3. Vehicle exits
        cityCircle.exitRoundabout("CAR-001");

        // 4. Check final state
        cityCircle.displayStatus();
    }
}