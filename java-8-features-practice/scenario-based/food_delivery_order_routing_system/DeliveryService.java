package week6_java8.food_delivery_order_routing_system;
import java.util.*;

class DeliveryService {
    private Queue<Order> orderQueue = new LinkedList<>();
    private List<Agent> agents = new ArrayList<>();
    private Map<Order, Agent> activeDeliveries = new HashMap<>();

    public void addAgent(Agent agent) { agents.add(agent); }
    
    public void placeOrder(Order order) {
        orderQueue.add(order);
        System.out.println("Order added to queue: " + order.getId());
    }

    public void assignOrders() throws NoAgentAvailableException {
        while (!orderQueue.isEmpty()) {
            Order currentOrder = orderQueue.peek();
            Agent bestAgent = findNearestAvailableAgent(currentOrder);

            if (bestAgent == null) {
                throw new NoAgentAvailableException("All agents are busy. Order " + currentOrder.getId() + " is pending.");
            }

            // Remove from queue and assign
            orderQueue.poll();
            bestAgent.setAvailable(false);
            activeDeliveries.put(currentOrder, bestAgent);
            System.out.println("Assigned " + currentOrder + " to Agent " + bestAgent.getName());
        }
    }

    private Agent findNearestAvailableAgent(Order order) {
        Agent nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Agent agent : agents) {
            if (agent.isAvailable()) {
                double dist = calculateDistance(order.getLat(), order.getLon(), agent.getLat(), agent.getLon());
                if (dist < minDistance) {
                    minDistance = dist;
                    nearest = agent;
                }
            }
        }
        return nearest;
    }

    private double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public void viewActiveDeliveries() {
        System.out.println("\n--- Current Active Deliveries ---");
        activeDeliveries.forEach((order, agent) -> 
            System.out.println(order.getId() + " is being delivered by " + agent.getName()));
    }
}