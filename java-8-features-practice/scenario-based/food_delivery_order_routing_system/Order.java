package week6_java8.food_delivery_order_routing_system;
class Order {
    private String id;
    private String foodItem;
    private double latitude;
    private double longitude;

    public Order(String id, String foodItem, double lat, double lon) {
        this.id = id;
        this.foodItem = foodItem;
        this.latitude = lat;
        this.longitude = lon;
    }

    // Getters
    public String getId() { return id; }
    public double getLat() { return latitude; }
    public double getLon() { return longitude; }
    @Override
    public String toString() { return "Order " + id + " (" + foodItem + ")"; }
}

class Agent {
    private String name;
    private double latitude;
    private double longitude;
    private boolean isAvailable = true;

    public Agent(String name, double lat, double lon) {
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
    }

    // Getters and Seters
    public String getName() { return name; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public double getLat() { return latitude; }
    public double getLon() { return longitude; }
}