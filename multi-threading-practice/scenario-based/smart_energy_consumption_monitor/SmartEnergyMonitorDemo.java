package week8_multi_threading.smart_energy_consumption_monitor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class SmartEnergyMonitorDemo {
	public static void main(String[] args) {
		EnergyMonitor monitor = new EnergyMonitor();

		try {
			monitor.addReading(LocalDate.of(2026, 2, 1), 5.2);
			monitor.addReading(LocalDate.of(2026, 2, 1), 6.1);
			monitor.addReading(LocalDate.of(2026, 2, 2), 4.9);
			monitor.addReading(LocalDate.of(2026, 2, 2), -3.0); // Invalid
		} catch (InvalidEnergyReadingException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Daily Avg (2026-02-01): " + monitor.getDailyAverage(LocalDate.of(2026, 2, 1)));

		System.out.println("Monthly Avg (2026-02): " + monitor.getMonthlyAverage(YearMonth.of(2026, 2)));

		monitor.generateReport();
	}
}