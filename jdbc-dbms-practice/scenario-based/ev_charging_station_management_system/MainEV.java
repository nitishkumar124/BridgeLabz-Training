package week9.ev_charging_station_management_system;
public class MainEV {
    public static void main(String[] args) {
        ChargingStationManager manager = new ChargingStationManager(1);
        Vehicle v1 = new Car("KA-01-1234");
        Vehicle v2 = new Car("KA-02-5678");

        try {
            manager.bookSlot(v1);
            manager.bookSlot(v2);
        } catch (NoChargingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }

        PricingStrategy pricing = new PeakHourPricing();
        double bill = manager.generateBill(20, pricing);
        System.out.println("Bill Amount: ₹" + bill);
    }
}
