package week9.smart_parking_slot_allocation_system;

class ParkingSlot {
	private int slotId;
	private boolean isFree = true;
	private Vehicle parkedVehicle;

	public ParkingSlot(int slotId) {
		this.slotId = slotId;
	}

	public boolean isFree() {
		return isFree;
	}

	public void park(Vehicle vehicle) {
		this.parkedVehicle = vehicle;
		this.isFree = false;
	}

	public void free() {
		this.parkedVehicle = null;
		this.isFree = true;
	}

	public int getSlotId() {
		return slotId;
	}
}
