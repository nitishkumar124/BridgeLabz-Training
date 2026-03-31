package week9.disaster_relief_resource_allocation_system;
import java.util.*;

public class DisasterReliefApp {
    public static void main(String[] args) {

        ReliefCenter rc1 = new ReliefCenter("Center-A");
        rc1.addResource("Food", 100);
        rc1.addResource("Water", 50);

        ReliefCenter rc2 = new ReliefCenter("Center-B");
        rc2.addResource("Food", 50);
        rc2.addResource("MedicalKit", 30);

        DisasterReliefManager manager = new DisasterReliefManager();
        manager.addCenter(rc1);
        manager.addCenter(rc2);

        Map<String, Integer> req1 = Map.of("Food", 20, "Water", 10);
        Map<String, Integer> req2 = Map.of("MedicalKit", 5);

        manager.addRequest(new AreaRequest("Area-1", req1));
        manager.addRequest(new AreaRequest("Area-2", req2));

        manager.processRequests();
        manager.generateReport();
    }
}
