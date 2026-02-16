package week9.disaster_relief_resource_allocation_system;
import java.util.HashMap;
import java.util.Map;

class ReliefCenter {
    private String name;
    private Map<String, Integer> resources = new HashMap<>();

    public ReliefCenter(String name) {
        this.name = name;
    }

    public void addResource(String item, int quantity) {
        resources.put(item, resources.getOrDefault(item, 0) + quantity);
    }

    public boolean hasSufficient(String item, int qty) {
        return resources.getOrDefault(item, 0) >= qty;
    }

    public void allocate(String item, int qty) {
        resources.put(item, resources.get(item) - qty);
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public String getName() {
        return name;
    }
}
