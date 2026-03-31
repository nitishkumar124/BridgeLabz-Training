package week9.smart_parking_slot_allocation_system;
class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public String getType() {
        return "BIKE";
    }
}