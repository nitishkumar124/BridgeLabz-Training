package week2.hotel_reservation_system;

import java.util.*;

public interface PricingStrategy {
	double calculateBill(double pricePerDay);
}

class StandardPricing implements PricingStrategy {
	@Override
	public double calculateBill(double pricePerDay) {
		return pricePerDay;
	}
}

class SeasonalPricing implements PricingStrategy {
	@Override
	public double calculateBill(double pricePerDay) {
		return pricePerDay * 1.5;
	}
}