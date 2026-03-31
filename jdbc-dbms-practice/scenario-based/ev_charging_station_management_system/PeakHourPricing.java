package week9.ev_charging_station_management_system;
public class PeakHourPricing implements PricingStrategy {
    public double calculatePrice(double units) {
        return units * 8;   // ₹8 per unit
    }
}
