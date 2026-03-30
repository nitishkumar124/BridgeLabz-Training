package practice_problems;

public class DigitalWatch {

	public static void main(String[] args) {
		turnOnWatch();
	}

	public static void turnOnWatch() {

		for (int hours = 0; hours < 24; hours++) {

			if (hours == 13) {
				System.out.println("\nSimulation stopped at 13:00.");
				break;
			}

			for (int minutes = 0; minutes < 60; minutes++) {
				displayTime(hours, minutes);
			}

			System.out.println();
		}
	}

	public static void displayTime(int h, int m) {
		System.out.printf("%02d:%02d\n", h, m);
	}
}
