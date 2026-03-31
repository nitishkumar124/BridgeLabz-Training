package stream_api;

import java.util.*;

public class StockPriceDisplay {

	public static void main(String[] args) {

		List<Double> stockPrices = Arrays.asList(1520.75, 1532.40, 1518.90, 1540.10, 1535.60);

		stockPrices.stream().forEach(price -> System.out.println("Live Stock Price: ₹" + price));
	}
}
