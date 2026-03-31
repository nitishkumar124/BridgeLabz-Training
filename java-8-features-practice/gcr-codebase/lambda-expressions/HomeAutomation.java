package lambda_expressions;

import java.util.*;

public class HomeAutomation {

	public static void main(String[] args) {
		SmartLight livingRoom = new SmartLight("Living Room");

		LightBehaviour wakeUpMode = () -> System.out.println("Increasing brightness to 80% with warm yellow.");
		LightBehaviour movieMode = () -> System.out.println("Dimming to 10% with deep blue hue.");
		LightBehaviour emergencyMode = () -> System.out.println("Flashing red! Emergency detected.");

		System.out.println("--- Scenario: 7:00 AM (Time Trigger) ---");
		livingRoom.performAction(wakeUpMode);

		System.out.println("\n--- Scenario: 'Hey Google, Movie Night' (Voice Trigger) ---");
		livingRoom.performAction(movieMode);

		System.out.println("\n--- Scenario: Motion detected at 2 AM (Sensor Trigger) ---");
		livingRoom.performAction(() -> System.out.println("Soft floor-level guide lights turned on."));
	}
}

@FunctionalInterface
interface LightBehaviour {
	void execute();
}

class SmartLight {
	private String name;

	public SmartLight(String name) {
		this.name = name;
	}

	public void performAction(LightBehaviour behaviour) {
		System.out.println(name + ": ");
		behaviour.execute();
	}
}
