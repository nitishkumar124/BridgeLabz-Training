package week3.smart_city_traffic;

import java.util.LinkedList;
import java.util.Queue;

public class SmartCityTraffic {
	public static void main(String[] args) {
		TrafficManager manager = new TrafficManager();

		manager.joinWaitingQueue("KA-01-123");
		manager.joinWaitingQueue("DL-05-999");
		manager.joinWaitingQueue("MH-12-555");

		manager.enterRoundabout();
		manager.enterRoundabout();

		manager.printState();

		manager.exitRoundabout("KA-01-123");

		manager.printState();
	}
}