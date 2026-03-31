package week9.ev_charging_station_management_system;
public class ChargingSlot {
    private boolean occupied;

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        this.occupied = true;
    }

    public void free() {
        this.occupied = false;
    }
}
