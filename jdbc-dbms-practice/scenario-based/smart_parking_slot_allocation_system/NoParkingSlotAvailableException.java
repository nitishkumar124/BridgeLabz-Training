package week9.smart_parking_slot_allocation_system;
class NoParkingSlotAvailableException extends Exception {
    public NoParkingSlotAvailableException(String message) {
        super(message);
    }
}
