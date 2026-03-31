package week6_java8.food_delivery_order_routing_system;
public class Main {
    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();

        service.addAgent(new Agent("Alice", 10.0, 10.0));
        service.addAgent(new Agent("Bob", 50.0, 50.0));

        Order order1 = new Order("ORD001", "Pizza", 12.0, 12.0);
        Order order2 = new Order("ORD002", "Sushi", 48.0, 48.0); 
        Order order3 = new Order("ORD003", "Burger", 15.0, 15.0);

        service.placeOrder(order1);
        service.placeOrder(order2);
        service.placeOrder(order3);

        try {
            service.assignOrders();
        } catch (NoAgentAvailableException e) {
            System.err.println("ALERT: " + e.getMessage());
        }

        service.viewActiveDeliveries();
    }
}