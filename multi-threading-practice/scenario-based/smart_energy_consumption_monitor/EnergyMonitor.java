package week8_multi_threading.smart_energy_consumption_monitor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

class EnergyMonitor {
	private Map<LocalDate, List<Double>> energyData = new HashMap<>();

	public void addReading(LocalDate date, double reading) throws InvalidEnergyReadingException {
		if (reading < 0) {
			throw new InvalidEnergyReadingException("Energy reading cannot be negative.");
		}

		energyData.computeIfAbsent(date, k -> new ArrayList<>()).add(reading);
	}

	public double getDailyAverage(LocalDate date) {
		List<Double> readings = energyData.get(date);
		if (readings == null || readings.isEmpty())
			return 0;

		return readings.stream().mapToDouble(Double::doubleValue).average().orElse(0);
	}

	public double getMonthlyAverage(YearMonth month) {
		double total = 0;
		int count = 0;

		for (Map.Entry<LocalDate, List<Double>> entry : energyData.entrySet()) {
			if (YearMonth.from(entry.getKey()).equals(month)) {
				for (double val : entry.getValue()) {
					total += val;
					count++;
				}
			}
		}
		return count == 0 ? 0 : total / count;
	}

	public void generateReport() {
		System.out.println("Energy Consumption Report:");
		energyData.forEach((date, readings) -> {
			System.out.println(date + " -> Avg: " + getDailyAverage(date));
		});
	}
}