package week9.disaster_relief_resource_allocation_system;
import java.util.Map;

class AreaRequest {
    private String areaName;
    private Map<String, Integer> requestedItems;

    public AreaRequest(String areaName, Map<String, Integer> requestedItems) {
        this.areaName = areaName;
        this.requestedItems = requestedItems;
    }

    public String getAreaName() {
        return areaName;
    }

    public Map<String, Integer> getRequestedItems() {
        return requestedItems;
    }
}
