package week9.smart_parking_slot_allocation_system;
class Car extends Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public String getType() {
        return "CAR";
    }
}