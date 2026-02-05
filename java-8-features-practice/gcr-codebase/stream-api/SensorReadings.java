package stream_api;

import java.util.*;

public class SensorReadings {

	public static void main(String[] args) {

		List<Double> readings = Arrays.asList(22.5, 35.8, 18.2, 40.0, 27.6, 45.3);

		double threshold = 30.0;

		readings.stream().filter(reading -> reading > threshold)
				.forEach(reading -> System.out.println("Reading above threshold: " + reading));
	}
}
