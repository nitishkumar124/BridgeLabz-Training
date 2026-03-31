package week9.smart_water_tank_mnitoring_system;
import java.util.*;

public class WaterTankMonitor {

    public static void main(String[] args) {

        List<WaterTank> tanks = new ArrayList<>();

        tanks.add(new WaterTank("T1", 1000, 150));
        tanks.add(new WaterTank("T2", 1000, 800));
        tanks.add(new WaterTank("T3", 1000, 100));

        System.out.println("⚠ Low Water Alerts:");
        tanks.stream()
             .filter(WaterTank::isBelowThreshold)
             .forEach(tank -> System.out.println("Alert! Low water in tank: " + tank.getTankId()));

        tanks.sort(Comparator.comparingDouble(WaterTank::getCurrentLevel));

        System.out.println("\n📉 Tanks Sorted by Lowest Level:");
        tanks.forEach(System.out::println);
    }
}
