package week9.ev_charging_station_management_system;
public class NormalPricing implements PricingStrategy {
    public double calculatePrice(double units) {
        return units * 5;   // ₹5 per unit
    }
}
